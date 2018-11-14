package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style26;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class EcommerceStyle26Model {

    public EcommerceStyle26Model(String imageProductUrl, String name, String size, String qty, String price) {
        this.imageProductUrl = imageProductUrl;
        this.name = name;
        this.size = size;
        this.qty = qty;
        this.price = price;
    }

    public EcommerceStyle26Model(){

    }

    private String id;
    private String imageProductUrl;
    private String name;
    private String size;
    private String qty;

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageProductUrl() {
        return imageProductUrl;
    }

    public void setImageProductUrl(String imageProductUrl) {
        this.imageProductUrl = imageProductUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
