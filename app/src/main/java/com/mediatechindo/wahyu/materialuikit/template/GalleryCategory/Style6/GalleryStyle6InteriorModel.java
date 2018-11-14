package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style6;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class GalleryStyle6InteriorModel {

    public GalleryStyle6InteriorModel(int pos, String url){
        id = pos;
        imageUrl = url;
    }

    public GalleryStyle6InteriorModel(int pos){
        id = pos;
    }

    public GalleryStyle6InteriorModel(){

    }

    private int id;
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
