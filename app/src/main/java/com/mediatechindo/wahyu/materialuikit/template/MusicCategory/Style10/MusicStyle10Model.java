package com.mediatechindo.wahyu.materialuikit.template.MusicCategory.Style10;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class MusicStyle10Model {

    public MusicStyle10Model(){

    }

    public MusicStyle10Model(String title1, boolean isButton1Selected, String title2, boolean isButton2Selected, String title3, boolean isButton3Selected) {
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
        this.isButton1Selected = isButton1Selected;
        this.isButton2Selected = isButton2Selected;
        this.isButton3Selected = isButton3Selected;
    }

    private String id;
    private String title1;
    private String title2;
    private String title3;
    private boolean isButton1Selected;
    private boolean isButton2Selected;
    private boolean isButton3Selected;

    public boolean isButton1Selected() {
        return isButton1Selected;
    }

    public void setButton1Selected(boolean button1Selected) {
        isButton1Selected = button1Selected;
    }

    public boolean isButton2Selected() {
        return isButton2Selected;
    }

    public void setButton2Selected(boolean button2Selected) {
        isButton2Selected = button2Selected;
    }

    public boolean isButton3Selected() {
        return isButton3Selected;
    }

    public void setButton3Selected(boolean button3Selected) {
        isButton3Selected = button3Selected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }
}
