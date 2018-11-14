package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style13;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ProfileStyle13Model {

    public ProfileStyle13Model(String url){
        imageUrl = url;
    }

    public ProfileStyle13Model(){

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
