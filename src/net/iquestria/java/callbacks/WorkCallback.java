package net.iquestria.java.callbacks;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import net.iquestria.java.callbacks.handlers.UserHandler;
import net.iquestria.java.callbacks.handlers.WorkHandler;
import net.iquestria.java.models.User;
import net.iquestria.java.models.Work;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * (c) iQuestria Team 2014
 * See LICENSE file for license details.
 */
public class WorkCallback implements Callback {
    private WorkHandler callback = null;

    public WorkCallback(WorkHandler callback){
        this.callback = callback;
    }

    @Override
    public void onFailure(Request request, IOException e) {
        callback.run(new Work());
    }

    @Override
    public void onResponse(Response response) throws IOException {
        String body = response.body().string();
        JSONObject workObject = null;
        Work work = new Work();
        try {
            workObject = new JSONObject(body);
            work = new Work(workObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callback.run(work);
    }
}
