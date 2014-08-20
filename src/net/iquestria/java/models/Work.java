package net.iquestria.java.models;

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
}
