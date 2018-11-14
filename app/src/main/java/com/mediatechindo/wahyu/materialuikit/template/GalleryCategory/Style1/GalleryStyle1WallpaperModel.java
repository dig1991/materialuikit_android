package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style1;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class GalleryStyle1WallpaperModel {

    public GalleryStyle1WallpaperModel(String url){
        imageUrl = url;
    }

    public GalleryStyle1WallpaperModel(){

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
