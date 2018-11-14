package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style6;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class MusicStyle6Model {

    public MusicStyle6Model(){

    }

    public MusicStyle6Model(String imageUrl, String genre) {
        this.imageUrl = imageUrl;
        this.genre = genre;
    }

    public MusicStyle6Model(String imageUrl, String artist, String songCount) {
        this.imageUrl = imageUrl;
        this.artist = artist;
        this.songCount = songCount;
    }

    private String id;
    private String imageUrl;
    private String title;
    private String genre;
    private String artist;
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
