package com.mediatechindo.wahyu.materialuikit.template.ExtraDesignCategory.CheckboxLight;

/**
 * Created by wahyu on 13/10/16.
 */

public class ExtraCheckboxLightModel {
    public ExtraCheckboxLightModel(String title, int imageIcon) {
        this.title = title;
        this.imageIcon = imageIcon;
    }

    private String title;
    private int imageIcon;
    private boolean isSelected = false;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(int imageIcon) {
        this.imageIcon = imageIcon;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
