package net.iquestria.java.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * (c) iQuestria Team 2014
 * See LICENSE file for license details.
 */
public class User {
    public Number id;
    public String username;
    public String realName;
    public String bio;
    public Rank rank;
    public String email;
    public String color;
    public String profileUrl;

    public User(){
        this.id = 0;
        this.username = "User";
        this.realName = "Anon";
        this.bio = "";
        this.rank = Rank.RANK_DEFAULT;
        this.email = "anon@iquestria.net";
        this.profileUrl = generateProfileUrl(this);
    }

    public User(Number id,
                String username,
                String realName,
                String bio,
                Rank rank,
                String email,
                String color){
        this.id = id;
        this.username = username;
        this.realName = realName;
        this.bio = bio;
        this.rank = rank;
        this.email = email;
        this.color = color;
    }

    public User(JSONObject object) throws JSONException{
        this.id = object.getLong("id");
        this.username = object.getString("username");
        this.realName = object.getString("real_name");
        this.bio = object.getString("bio");
        this.rank = new Rank(object.getJSONObject("rank"));
        this.email = object.getString("email");
        this.profileUrl = generateProfileUrl(this);
    }

    private String generateProfileUrl(User user){
        return "http://api.iquestria.net/fetchProfilePicture.php?id=" + user.id;
    }
}
