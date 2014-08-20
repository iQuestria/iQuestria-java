package net.iquestria.java.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * (c) iQuestria Team 2014
 * See LICENSE file for license details.
 */
public class Work extends Model{
    public String title;
    public String description;
    public User user;
    public String url;

    public Work(){
        this.id = 0;
        this.title = "Title";
        this.description = "Description";
        this.user = new User();
        this.url = "http://datastorage.iquestria.net/sorry.jpg";
    }

    public Work(Number id,
                String title,
                String description,
                User user,
                String url){
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
        this.url = url;
    }

    public Work(JSONObject object) throws JSONException{
        this.id = object.getLong("id");
        this.title = object.getString("title");
        this.description = object.getString("description");
        this.user = new User(object.getJSONObject("user"));
        this.url = object.getString("url");
    }
}
