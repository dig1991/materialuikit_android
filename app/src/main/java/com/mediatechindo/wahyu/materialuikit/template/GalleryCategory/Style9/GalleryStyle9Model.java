package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style9;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class GalleryStyle9Model {

    public GalleryStyle9Model(String mTitle, String lCount, String url){
        title = mTitle;
        pictureCount = lCount;
        imageUrl = url;
    }

    public GalleryStyle9Model(){

    }

    private String id;
    private String imageUrl;
    private String title;
    private String pictureCount;

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

    public String getPictureCount() {
        return pictureCount;
    }

    public void setPictureCount(String pictureCount) {
        this.pictureCount = pictureCount;
    }
}
