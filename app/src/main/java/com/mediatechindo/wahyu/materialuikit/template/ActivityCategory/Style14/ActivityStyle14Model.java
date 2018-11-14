package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style14;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle14Model {

    public ActivityStyle14Model(String nm, String tit, String url, String thumb){
        imageUrl = url;
        imageUrlThumb = thumb;
        name = nm;
        title = tit;
    }

    public ActivityStyle14Model(){

    }

    private String id;
    private String imageUrl;
    private String imageUrlThumb;
    private String title;
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

    public String getImageUrlThumb() {
        return imageUrlThumb;
    }

    public void setImageUrlThumb(String imageUrlThumb) {
        this.imageUrlThumb = imageUrlThumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
