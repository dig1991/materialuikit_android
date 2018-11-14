package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style11;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class MusicStyle11Model {

    public MusicStyle11Model(){

    }

    public MusicStyle11Model(String textLyric, double timeLyric) {
        this.textLyric = textLyric;
        this.timeLyric = timeLyric;
    }

    private String id;
    private String textLyric;
    private double timeLyric;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextLyric() {
        return textLyric;
    }

    public void setTextLyric(String textLyric) {
        this.textLyric = textLyric;
    }

    public double getTimeLyric() {
        return timeLyric;
    }

    public void setTimeLyric(double timeLyric) {
        this.timeLyric = timeLyric;
    }
}
