package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style6;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle6Model {

    public ActivityStyle6Model(String prourl, String url){
        imageUrl = url;
        profileUrl = prourl;
    }

    public ActivityStyle6Model(){

    }

    private String id;
    private String imageUrl;
    private String profileUrl;
    private String title;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
