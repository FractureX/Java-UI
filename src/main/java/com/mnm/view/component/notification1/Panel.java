/*
 * Proyecto M&M
 */
package com.mnm.view.component.notification1;

import com.mnm.view.component.RoundedJPanel;
import com.mnm.view.component.notification1.Notification.NotificationType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Panel extends RoundedJPanel {
    
    private Color colorSuccess = new Color(32, 195, 117);
    private Color colorError = new Color(232, 80, 48);
    private Color colorWarning = new Color(238, 169, 61);
    private Color colorInformation = new Color(24, 124, 191);
    private Color currentColor = colorSuccess;
    
    private NotificationType MNM_notificationType = NotificationType.Success;
    private int MNM_margin = 10;
    private int MNM_height = 50;
    private int MNM_width = 4;
    private int MNM_arc = 4;
    
    public Panel() {
        initComponents();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(currentColor);
        g2d.fillRoundRect(MNM_margin, (getHeight() / 2) - (MNM_height / 2), MNM_width, MNM_height, MNM_arc, MNM_arc);
        //g2d.fillRoundRect(0, 0, getWidth(), getHeight(), MNM_arc, MNM_arc);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public int getMNM_margin() {
        return MNM_margin;
    }

    public void setMNM_margin(int MNM_margin) {
        this.MNM_margin = MNM_margin;
    }

    public int getMNM_width() {
        return MNM_width;
    }

    public void setMNM_width(int MNM_width) {
        this.MNM_width = MNM_width;
    }

    public int getMNM_arc() {
        return MNM_arc;
    }

    public void setMNM_arc(int MNM_arc) {
        this.MNM_arc = MNM_arc;
    }

    public NotificationType getMNM_notificationType() {
        return MNM_notificationType;
    }

    public void setMNM_notificationType(NotificationType MNM_notificationType) {
        this.MNM_notificationType = MNM_notificationType;
        if (MNM_notificationType == NotificationType.Success) {
            currentColor = colorSuccess;
        } else if (MNM_notificationType == NotificationType.Error) {
            currentColor = colorError;
        } else if (MNM_notificationType == NotificationType.Warning) {
            currentColor = colorWarning;
        } else if (MNM_notificationType == NotificationType.Information) {
            currentColor = colorInformation;
        }
    }

    public int getMNM_height() {
        return MNM_height;
    }

    public void setMNM_height(int MNM_height) {
        this.MNM_height = MNM_height;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
