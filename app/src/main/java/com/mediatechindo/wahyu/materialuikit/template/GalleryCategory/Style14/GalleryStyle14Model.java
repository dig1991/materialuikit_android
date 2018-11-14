package com.mediatechindo.wahyu.materialuikit.template.GalleryCategory.Style14;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class GalleryStyle14Model {

    public GalleryStyle14Model(String mTitle, String lCount, String vCount, String url){
        title = mTitle;
        loveCount = lCount;
        viewCount = vCount;
        imageUrl = url;
    }

    public GalleryStyle14Model(){

    }

    private String id;
    private String imageUrl;
    private String title;
    private String loveCount;
    private String viewCount;

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

    public String getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(String loveCount) {
        this.loveCount = loveCount;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }
}
