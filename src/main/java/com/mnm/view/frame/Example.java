/*
 * Proyecto M&M
 */
package com.mnm.view.frame;

import java.awt.Color;
import java.awt.Toolkit;

public class Example extends javax.swing.JFrame {
    
    public Example() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        containerPrincipal = new com.mnm.view.component.RoundedJPanel();
        containerCentral = new com.mnm.view.component.RoundedJPanel();
        carousel1 = new com.mnm.carousel.view.component.Carousel();
        roundedJPanel1 = new com.mnm.view.component.RoundedJPanel();
        roundedJTextField1 = new com.mnm.form.view.component.RoundedJTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        containerPrincipal.setMNM_arc(0);
        containerPrincipal.setMNM_backgroundColor(new java.awt.Color(215, 221, 230));
        containerPrincipal.setPreferredSize(new java.awt.Dimension(800, 600));
        containerPrincipal.setLayout(new java.awt.GridBagLayout());

        containerCentral.setPreferredSize(new java.awt.Dimension(700, 510));
        containerCentral.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        containerCentral.add(carousel1);

        roundedJPanel1.setPreferredSize(new java.awt.Dimension(385, 500));

        roundedJTextField1.setText("roundedJTextField1");
        roundedJTextField1.setMNM_icon(new javax.swing.ImageIcon(getClass().getResource("/img_persona.jpg"))); // NOI18N
        roundedJTextField1.setMNM_iconSize(25);

        javax.swing.GroupLayout roundedJPanel1Layout = new javax.swing.GroupLayout(roundedJPanel1);
        roundedJPanel1.setLayout(roundedJPanel1Layout);
        roundedJPanel1Layout.setHorizontalGroup(
            roundedJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedJPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(roundedJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        roundedJPanel1Layout.setVerticalGroup(
            roundedJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedJPanel1Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(roundedJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        containerCentral.add(roundedJPanel1);

        containerPrincipal.add(containerCentral, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.mnm.carousel.view.component.Carousel carousel1;
    private com.mnm.view.component.RoundedJPanel containerCentral;
    private com.mnm.view.component.RoundedJPanel containerPrincipal;
    private com.mnm.view.component.RoundedJPanel roundedJPanel1;
    private com.mnm.form.view.component.RoundedJTextField roundedJTextField1;
    // End of variables declaration//GEN-END:variables
}
