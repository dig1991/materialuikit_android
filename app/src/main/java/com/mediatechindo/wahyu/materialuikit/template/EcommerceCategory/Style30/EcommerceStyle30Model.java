package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style30;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class EcommerceStyle30Model {

    public EcommerceStyle30Model(String categoryTitle, String imageUrl) {
        this.categoryTitle = categoryTitle;
        this.imageUrl = imageUrl;
    }

    private String categoryTitle;
    private String imageUrl;

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
