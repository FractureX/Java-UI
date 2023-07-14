/*
 * Proyecto M&M
 */
package com.mnm.carousel.view.frame;

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

        containerPrincipal = new com.mnm.carousel.view.component.RoundedJPanel();
        containerCentral = new com.mnm.carousel.view.component.RoundedJPanel();
        carousel1 = new com.mnm.carousel.view.component.Carousel();
        roundedJPanel1 = new com.mnm.carousel.view.component.RoundedJPanel();

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

        javax.swing.GroupLayout roundedJPanel1Layout = new javax.swing.GroupLayout(roundedJPanel1);
        roundedJPanel1.setLayout(roundedJPanel1Layout);
        roundedJPanel1Layout.setHorizontalGroup(
            roundedJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );
        roundedJPanel1Layout.setVerticalGroup(
            roundedJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
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
    private com.mnm.carousel.view.component.Carousel carousel1;
    private com.mnm.carousel.view.component.RoundedJPanel containerCentral;
    private com.mnm.carousel.view.component.RoundedJPanel containerPrincipal;
    private com.mnm.carousel.view.component.RoundedJPanel roundedJPanel1;
    // End of variables declaration//GEN-END:variables
}
