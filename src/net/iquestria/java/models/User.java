package net.iquestria.java.models;

/**
 * (c) iQuestria Team 2014
 * See LICENSE file for license details.
 */
public class User {
    private Integer id;
    private String username;
    private String realName;
    private String bio;
    private Rank rank;
    private String email;

    public User(){
        this.id = 0;
        this.username = "User";
        this.realName = "Anon";
        this.bio = "";
        this.rank = Rank.RANK_DEFAULT;
        this.email = "anon@iquestria.net";
    }

    public User(Integer id,
                String username,
                String realName,
                String bio,
                Rank rank,
                String email){
        this.id = id;
        this.username = username;
        this.realName = realName;
        this.bio = bio;
        this.rank = rank;
        this.email = email;
    }
}
