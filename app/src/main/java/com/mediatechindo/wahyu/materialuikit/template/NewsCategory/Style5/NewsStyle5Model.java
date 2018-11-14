package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style5;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class NewsStyle5Model {

    public NewsStyle5Model(){

    }

    public NewsStyle5Model(String profileUrl, String imageUrl, String name, String title, String time, String description) {
        this.profileUrl = profileUrl;
        this.imageUrl = imageUrl;
        this.name = name;
        this.title = title;
        this.time = time;
        this.description = description;
    }

    private String id;
    private String profileUrl;
    private String imageUrl;
    private String name;
    private String title;
    private String time;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
