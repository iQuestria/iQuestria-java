package net.iquestria.java.models;

/**
 * (c) iQuestria Team 2014
 * See LICENSE file for license details.
 */
public class Rank {
    private Integer id;
    private String name;
    private String displayName;
    private Integer permissionLevel;
    public static Rank RANK_DEFAULT = new Rank(1, "default", "User", 0);
    public static Rank RANK_MODERATOR = new Rank(2, "mod", "Moderator", 1);
    public static Rank RANK_ADMIN = new Rank(3, "admin", "Admin", 2);

    public Rank(){
        this.id = 1;
        this.name = "default";
        this.displayName = "User";
        this.permissionLevel = 0;
    }

    public Rank(Integer id,
                String name,
                String displayName,
                Integer permissionLevel){
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.permissionLevel = permissionLevel;
    }
}
