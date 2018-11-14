package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style13;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle13Model {

    public ActivityStyle13Model(String nm, String url){
        imageUrl = url;
        name = nm;
    }

    public ActivityStyle13Model(){

    }

    private String id;
    private String imageUrl;
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
