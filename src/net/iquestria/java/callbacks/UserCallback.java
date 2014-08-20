package net.iquestria.java.callbacks;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import net.iquestria.java.callbacks.runnables.UserHandler;
import net.iquestria.java.models.Rank;
import net.iquestria.java.models.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    public void onFailure(Request request, IOException e) {

    }

    public void onResponse(Response response) throws IOException {
        String body = response.body().string();
        JSONParser parser = new JSONParser();
        JSONObject userObject = new JSONObject();
        try {
            userObject = (JSONObject) parser.parse(body);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Number id = (Number) userObject.get("id");
        String username = (String) userObject.get("username");
        String realName = (String) userObject.get("real_name");
        String bio = (String) userObject.get("bio");
        String color = (String) userObject.get("color");
        User user = new User(id, username, realName, bio, Rank.RANK_DEFAULT, "", color);
        callback.run(new User());
    }
}
