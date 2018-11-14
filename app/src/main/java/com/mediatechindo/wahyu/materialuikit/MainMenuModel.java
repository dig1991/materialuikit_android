package com.mediatechindo.wahyu.materialuikit;

/**
 * Created by wahyu on 13/10/16.
 */

public class MainMenuModel {
    private String menuName = "";
    private int menuNotificationCount = 0;
    private boolean isSelected = false;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuNotificationCount() {
        return menuNotificationCount;
    }

    public void setMenuNotificationCount(int menuNotificationCount) {
        this.menuNotificationCount = menuNotificationCount;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
