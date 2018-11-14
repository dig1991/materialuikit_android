package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style28;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle28Model {

    public ActivityStyle28Model(boolean send, String msg, boolean img, String tm){
        isSend = send;
        message = msg;
        time = tm;
        isImage = img;
    }

    public ActivityStyle28Model(){

    }

    private String id;
    private String message;
    private String time;
    private boolean isSend;
    private boolean isImage;

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean image) {
        isImage = image;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
