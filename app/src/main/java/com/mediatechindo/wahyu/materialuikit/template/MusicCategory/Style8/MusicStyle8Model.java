package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style8;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class MusicStyle8Model {

    public MusicStyle8Model(){

    }

    public MusicStyle8Model(String imageUrl, String title, String songCount) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.songCount = songCount;
    }

    private String id;
    private String imageUrl;
    private String title;
    private String songCount;

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

    public String getSongCount() {
        return songCount;
    }

    public void setSongCount(String songCount) {
        this.songCount = songCount;
    }
}
