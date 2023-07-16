/*
 * Proyecto M&M
 */
package com.mnm.form.view.stepper1;

import com.mnm.view.component.RoundedJPanel;

public class Step {
    
    private String iconPath;
    private RoundedJPanel panel;
    private String title;
    private String description;
    
    public Step(String iconPath, RoundedJPanel panel, String title, String description) {
        this.iconPath = iconPath;
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
    
}
