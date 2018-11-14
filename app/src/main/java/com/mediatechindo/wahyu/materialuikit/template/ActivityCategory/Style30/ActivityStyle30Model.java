package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style30;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle30Model {

    public ActivityStyle30Model(int ty, String msg, String tm){
        message = msg;
        time = tm;
        type = ty;
    }

    public ActivityStyle30Model(){

    }

    private String id;
    private String message;
    private int type;
    private String time;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
