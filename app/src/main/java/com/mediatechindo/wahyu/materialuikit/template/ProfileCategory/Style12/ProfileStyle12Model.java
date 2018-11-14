package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style12;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ProfileStyle12Model {

    public ProfileStyle12Model(String mTitle, String lCount, String url){
        title = mTitle;
        photoCount = lCount;
        imageUrl = url;
    }

    public ProfileStyle12Model(){

    }

    private String id;
    private String imageUrl;
    private String title;
    private String photoCount;

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

    public String getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(String photoCount) {
        this.photoCount = photoCount;
    }
}
