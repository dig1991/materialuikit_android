package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style3;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class MusicStyle3Model {

    public MusicStyle3Model(){

    }

    public MusicStyle3Model(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    public MusicStyle3Model(String imageUrl, String title, String songCount, String year) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.songCount = songCount;
        this.year = year;
    }

    private String id;
    private String imageUrl;
    private String title;
    private String genre;
    private String artist;
    private String songCount;
    private String year;
    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongCount() {
        return songCount;
    }

    public void setSongCount(String songCount) {
        this.songCount = songCount;
    }
}
