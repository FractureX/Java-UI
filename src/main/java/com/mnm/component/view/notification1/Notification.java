/*
 * Proyecto M&M
 */
package com.mnm.component.view.notification1;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class Notification extends JDialog {
    
    private final int imageIconSize = 24;
    private NotificationType notificationType;
    private String notificationTitle;
    private String notificationMessage;
    private String imageIconSuccessPath = "/images/notification1/success-32x32.png";
    private String imageIconErrorPath = "/images/notification1/error-32x32.png";
    private String imageIconWarningPath = "/images/notification1/warning-32x32.png";
    private String imageIconInformationPath = "/images/notification1/information-32x32.png";
    
    public static enum NotificationType {
        Success,
        Error,
        Warning,
        Information
    }
    
    public Notification(NotificationType notificationType, String notificationTitle, String notificationMessage) {
        this.notificationType = notificationType;
        this.notificationTitle = notificationTitle;
        this.notificationMessage = notificationMessage;
        initComponents();
        init();
    }
    
    private void init() {
        setBackground(new Color(0, 0, 0, 0));
        this.title.setText(notificationTitle);
        this.message.setText(notificationMessage);
        ImageIcon imageIcon = null;
        String imageIconPath = "";
        if (notificationType == NotificationType.Success) {
            imageIconPath = imageIconSuccessPath;
        } else if (notificationType == NotificationType.Error) {
            imageIconPath = imageIconErrorPath;
        } else if (notificationType == NotificationType.Warning) {
            imageIconPath = imageIconWarningPath;
        } else if (notificationType == NotificationType.Information) {
            imageIconPath = imageIconInformationPath;
        }
        panelNotification.setMNM_notificationType(notificationType);
        imageIcon = new ImageIcon(new ImageIcon(getClass().getResource(imageIconPath)).getImage().getScaledInstance(imageIconSize, imageIconSize, Image.SCALE_SMOOTH));
        icon.setIcon(imageIcon);
        pack();
        setLocation(getToolkit().getScreenSize().width - getPreferredSize().width, getToolkit().getScreenSize().height - getPreferredSize().height);
    }
    
    public static void showNotification(NotificationType notificationType, String title, String message) {
        new Notification(notificationType, title, message).setVisible(true);
    }
    
    private void mouseClick() {
        this.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNotification = new com.mnm.component.view.notification1.Panel();
        icon = new com.mnm.component.view.RoundedJLabel();
        title = new javax.swing.JLabel();
        message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        panelNotification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelNotificationMousePressed(evt);
            }
        });

        icon.setMNM_backgroundShow(false);
        icon.setMNM_icon(new javax.swing.ImageIcon(getClass().getResource("/images/notification1/success-32x32.png"))); // NOI18N
        icon.setMNM_iconMargin(20);
        icon.setMNM_iconSize(24);

        title.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 51));
        title.setText("¿Sabías que?");
        title.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        title.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 10));

        message.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        message.setText("Ésto es un mensaje, mi pana");
        message.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        message.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 10));

        javax.swing.GroupLayout panelNotificationLayout = new javax.swing.GroupLayout(panelNotification);
        panelNotification.setLayout(panelNotificationLayout);
        panelNotificationLayout.setHorizontalGroup(
            panelNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotificationLayout.createSequentialGroup()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title)
                    .addComponent(message))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelNotificationLayout.setVerticalGroup(
            panelNotificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelNotificationLayout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelNotificationMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelNotificationMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            mouseClick();
        }
    }//GEN-LAST:event_panelNotificationMousePressed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        this.dispose();
    }//GEN-LAST:event_formWindowLostFocus
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mnm.component.view.RoundedJLabel icon;
    private javax.swing.JLabel message;
    private com.mnm.component.view.notification1.Panel panelNotification;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
