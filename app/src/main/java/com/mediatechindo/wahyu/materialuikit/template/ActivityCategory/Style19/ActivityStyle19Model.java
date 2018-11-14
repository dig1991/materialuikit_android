package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style19;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle19Model {

    public ActivityStyle19Model(String nm, String tm, String prourl, String url){
        name = nm;
        timed = tm;
        imageUrl = url;
        profileUrl = prourl;
    }

    public ActivityStyle19Model(){

    }

    private String id;
    private String imageUrl;
    private String profileUrl;
    private String name;
    private String timed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getTimed() {
        return timed;
    }

    public void setTimed(String timed) {
        this.timed = timed;
    }
}
