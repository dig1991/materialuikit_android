package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style4;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class NewsStyle4Model {

    public NewsStyle4Model(){

    }

    public NewsStyle4Model(String imageUrl, String title, String author, String time) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.author = author;
        this.time = time;
    }

    private String id;
    private String imageUrl;
    private String title;
    private String author;
    private String time;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
