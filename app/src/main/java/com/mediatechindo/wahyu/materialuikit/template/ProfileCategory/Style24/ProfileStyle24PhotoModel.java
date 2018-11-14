package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style24;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ProfileStyle24PhotoModel {

    public ProfileStyle24PhotoModel(String url){
        imageUrl = url;
    }

    public ProfileStyle24PhotoModel(){

    }

    private String id;
    private String imageUrl;

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

}
