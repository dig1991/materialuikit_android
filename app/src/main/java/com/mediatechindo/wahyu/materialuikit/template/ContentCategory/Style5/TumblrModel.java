package com.mediatechindo.wahyu.materialuikit.template.ContentCategory.Style5;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class TumblrModel {

    public TumblrModel(){

    }

    public TumblrModel(String imageUrl) {
        this.imageUrl = imageUrl;
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
