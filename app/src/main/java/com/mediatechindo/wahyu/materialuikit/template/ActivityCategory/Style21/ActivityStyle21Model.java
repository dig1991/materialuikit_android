package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style21;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle21Model {

    public ActivityStyle21Model(String prourl, String nm, String msg, String tm){
        profileUrl = prourl;
        name = nm;
        message = msg;
        time = tm;
    }

    public ActivityStyle21Model(){

    }

    private String id;
    private String profileUrl;
    private String name;
    private String message;
    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
