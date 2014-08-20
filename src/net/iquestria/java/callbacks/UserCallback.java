package net.iquestria.java.callbacks;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import net.iquestria.java.callbacks.runnables.UserHandler;
import net.iquestria.java.models.User;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * (c) iQuestria Team 2014
 * See LICENSE file for license details.
 */
public class UserCallback implements Callback {
    private UserHandler callback = null;

    public UserCallback(UserHandler callback){
        this.callback = callback;
    }

    @Override
    public void onFailure(Request request, IOException e) {
        callback.run(new User());
    }

    @Override
    public void onResponse(Response response) throws IOException {
        String body = response.body().string();
        JSONObject userObject = null;
        User user = new User();
        try {
            userObject = new JSONObject(body);
            user = new User(userObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callback.run(user);
    }
}
