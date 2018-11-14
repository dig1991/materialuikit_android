package com.mediatechindo.wahyu.materialuikit.template.ProfileCategory.Style3;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ProfileStyle3Model {

    public ProfileStyle3Model(String nm, String adr, String url){
        name = nm;
        address = adr;
        imageUrl = url;
    }

    private String id;
    private String imageUrl;
    private String name;
    private String address;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
