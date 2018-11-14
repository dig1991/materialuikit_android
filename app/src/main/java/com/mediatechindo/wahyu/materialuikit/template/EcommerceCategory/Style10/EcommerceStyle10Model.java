package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style10;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class EcommerceStyle10Model {

    public EcommerceStyle10Model(String title, String category, String price, String imageUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.category = category;
        this.price = price;
    }

    private String id;
    private String imageUrl;
    private String title;
    private String category;
    private String price;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
