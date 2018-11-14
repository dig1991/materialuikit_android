package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style1;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class EcommerceStyle1Model {

    public EcommerceStyle1Model(String mTitle, String mPrice, String url){
        title = mTitle;
        price = mPrice;
        imageUrl = url;
    }

    public EcommerceStyle1Model(){

    }

    private String id;
    private String imageUrl;
    private String title;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
