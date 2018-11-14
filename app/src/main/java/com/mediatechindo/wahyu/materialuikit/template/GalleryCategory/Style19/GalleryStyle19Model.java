package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style19;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class GalleryStyle19Model {

    public GalleryStyle19Model(int pos, String url){
        id = pos;
        imageUrl = url;
    }

    public GalleryStyle19Model(int pos){
        id = pos;
    }

    public GalleryStyle19Model(){

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
