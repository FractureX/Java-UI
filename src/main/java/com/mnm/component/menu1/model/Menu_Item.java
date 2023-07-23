package com.mnm.component.menu1.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Menu_Item {
    
    private int itemIndex;
    private String itemIcon;
    private String itemTitle;
    private MenuType itemType;
    
    public Menu_Item(int itemIndex, String itemIcon, String itemTitle, MenuType itemType) {
        this.itemIcon = itemIcon;
        this.itemTitle = itemTitle;
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return itemTitle;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }
    
    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public MenuType getItemType() {
        return itemType;
    }

    public void setItemType(MenuType itemType) {
        this.itemType = itemType;
    }
    
    public Icon toIcon() {
        if (itemType.equals(MenuType.MENUITEM)) {
            return new ImageIcon(getClass().getResource("/images/sm/" + itemIcon + ".png"));
        } else {
            return null;
        }
    }
    
    public static enum MenuType {
        TITLE, 
        MENUITEM, 
        MENUITEMNEST, 
        MENUITEMNEST_NESTED, 
        EMPTY
    }
    
}
