package com.mediatechindo.wahyu.materialuikit.template.MenuCategory.Style16;

/**
 * Created by wahyu on 13/10/16.
 */

public class MenuNavigation16Model {
    private int iconImage;
    private String menuName = "";
    private int menuNotificationCount = 0;
    private boolean isSelected = false;

    public int getIconImage() {
        return iconImage;
    }

    public void setIconImage(int iconImage) {
        this.iconImage = iconImage;
    }

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
