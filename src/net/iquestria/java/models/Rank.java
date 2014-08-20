package net.iquestria.java.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * (c) iQuestria Team 2014
 * See LICENSE file for license details.
 */
public class Rank extends Model{
    public String name;
    public String displayName;
    public Number permissionLevel;
    public static Rank RANK_DEFAULT = new Rank(1, "default", "User", 0);
    public static Rank RANK_MODERATOR = new Rank(2, "mod", "Moderator", 1);
    public static Rank RANK_ADMIN = new Rank(3, "admin", "Admin", 2);

    public Rank(){
        this.id = 1;
        this.name = "default";
        this.displayName = "User";
        this.permissionLevel = 0;
    }

    public Rank(Number id,
                String name,
                String displayName,
                Number permissionLevel){
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.permissionLevel = permissionLevel;
    }

    public Rank(JSONObject object) throws JSONException{
        this.id = object.getLong("id");
        this.name = object.getString("name");
        this.displayName = object.getString("display_name");
        this.permissionLevel = object.getLong("permission_level");
    }
}
