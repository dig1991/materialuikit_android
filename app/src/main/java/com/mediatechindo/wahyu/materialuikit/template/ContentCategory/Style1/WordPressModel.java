package com.mediatechindo.wahyu.materialuikit.template.ContentCategory.Style1;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class WordPressModel {

    public WordPressModel(){

    }

    public WordPressModel(String imageUrl, String title, String time, String source) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.time = time;
        this.source = source;
    }

    private String id;
    private String imageUrl;
    private String title;
    private String time;
    private String source;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
