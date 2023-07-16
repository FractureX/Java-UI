/*
 * Proyecto M&M
 */
package com.mnm.form.view.stepper1;

import com.mnm.view.component.RoundedJPanel;
import javax.swing.ImageIcon;

public class Step {
    
    private ImageIcon imageIcon;
    private ImageIcon imageIcon2;
    private String iconPath;
    private String iconPath2;
    private RoundedJPanel panel;
    private String title;
    private String description;
    
    public Step(String iconPath, String iconPath2, RoundedJPanel panel, String title, String description) {
        this.iconPath = iconPath;
        this.iconPath2 = iconPath2;
        this.panel = panel;
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RoundedJPanel getPanel() {
        return panel;
    }

    public void setPanel(RoundedJPanel panel) {
        this.panel = panel;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public ImageIcon getImageIcon2() {
        return imageIcon2;
    }

    public void setImageIcon2(ImageIcon imageIcon2) {
        this.imageIcon2 = imageIcon2;
    }

    public String getIconPath2() {
        return iconPath2;
    }

    public void setIconPath2(String iconPath2) {
        this.iconPath2 = iconPath2;
    }
    
}
