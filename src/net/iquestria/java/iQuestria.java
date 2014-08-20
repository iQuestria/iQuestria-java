package net.iquestria.java;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import net.iquestria.java.callbacks.UserCallback;
import net.iquestria.java.callbacks.WorkCallback;
import net.iquestria.java.callbacks.handlers.UserHandler;
import net.iquestria.java.callbacks.handlers.WorkHandler;
import net.iquestria.java.models.Work;

/**
 * (c) iQuestria Team 2014
 * See LICENSE file for license details.
 */
public class iQuestria {
    public static String API_BASE = "http://beta.iquestria.net";

    public static void getUserById(Integer id, UserHandler callback){
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder().url(API_BASE + "/users/" + id + ".json").build();
        UserCallback userCallback = new UserCallback(callback);
        client.newCall(req).enqueue(userCallback);
    }

    public static void getWorkById(Integer id, WorkHandler callback){
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder().url(API_BASE + "/works/" + id + ".json").build();
        WorkCallback workCallback = new WorkCallback(callback);
        client.newCall(req).enqueue(workCallback);
    }
}
