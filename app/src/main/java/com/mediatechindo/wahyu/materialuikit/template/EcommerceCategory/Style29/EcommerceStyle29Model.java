package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style29;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class EcommerceStyle29Model {

    public EcommerceStyle29Model(String name, String review, String time) {
        this.name = name;
        this.review = review;
        this.time = time;
    }

    public EcommerceStyle29Model(){

    }

    private String name;
    private String review;
    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
