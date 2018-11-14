package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style7;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class NewsStyle7Model {

    public NewsStyle7Model(){

    }

    public NewsStyle7Model(String profileUrl, String name, String time, String comment) {
        this.profileUrl = profileUrl;
        this.name = name;
        this.time = time;
        this.comment = comment;
    }

    private String id;
    private String profileUrl;
    private String name;
    private String time;
    private String comment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
