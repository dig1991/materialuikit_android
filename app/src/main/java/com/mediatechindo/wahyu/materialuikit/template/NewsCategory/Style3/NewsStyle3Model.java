package com.mediatechindo.wahyu.materialuikit.template.NewsCategory.Style3;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class NewsStyle3Model {

    public NewsStyle3Model(){

    }

    public NewsStyle3Model(String title, String imageUrl, boolean isButtonSelected) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.isButtonSelected = isButtonSelected;
    }

    private String id;
    private String title;
    private String imageUrl;
    private boolean isButtonSelected;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isButtonSelected() {
        return isButtonSelected;
    }

    public void setButtonSelected(boolean buttonSelected) {
        isButtonSelected = buttonSelected;
    }
}
