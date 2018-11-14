package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style23;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ProfileStyle23PhotoModel {

    public ProfileStyle23PhotoModel(String url){
        imageUrl = url;
    }

    public ProfileStyle23PhotoModel(){

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
