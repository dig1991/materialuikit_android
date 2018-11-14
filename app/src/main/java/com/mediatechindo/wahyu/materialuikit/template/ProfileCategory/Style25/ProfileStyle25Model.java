package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style25;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ProfileStyle25Model {
    public ProfileStyle25Model(String tit, String url){
        title = tit;
        imageUrl = url;
    }

    private String id;
    private String imageUrl;
    private String title;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
