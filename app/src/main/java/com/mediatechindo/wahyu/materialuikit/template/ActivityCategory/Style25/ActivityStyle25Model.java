package com.mediatechindo.wahyu.materialuikit.template.ActivityCategory.Style25;

/**
 * Created by Wahyu on 06/08/2015.
 */
public class ActivityStyle25Model {

    public ActivityStyle25Model(String prourl, String nm, String tm, String desc){
        profileUrl = prourl;
        name = nm;
        time = tm;
        description = desc;
    }

    public ActivityStyle25Model(){

    }

    private String id;
    private String profileUrl;
    private String name;
    private String time;
    private String description;
    private boolean isChecked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
