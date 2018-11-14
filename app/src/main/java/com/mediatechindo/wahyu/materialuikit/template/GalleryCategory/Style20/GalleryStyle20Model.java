package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style20;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class GalleryStyle20Model {

    public GalleryStyle20Model(int pos, String url){
        id = pos;
        imageUrl = url;
    }

    public GalleryStyle20Model(int pos){
        id = pos;
    }

    public GalleryStyle20Model(){

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
