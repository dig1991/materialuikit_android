package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style3;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class GalleryStyle3Model {

    public GalleryStyle3Model(String mTitle, String url){
        title = mTitle;
        imageUrl = url;
    }

    public GalleryStyle3Model(){

    }

    private String id;
    private String imageUrl;
    private String title;

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
