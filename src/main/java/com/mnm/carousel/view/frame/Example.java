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
        containerCarousel = new com.mnm.carousel.view.component.Carousel();
        containerForm = new com.mnm.carousel.view.component.RoundedJPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        containerPrincipal.setMNM_arc(0);
        containerPrincipal.setMNM_backgroundColor(new java.awt.Color(215, 221, 230));
        containerPrincipal.setPreferredSize(new java.awt.Dimension(800, 600));
        containerPrincipal.setLayout(new java.awt.GridBagLayout());

        containerCentral.setPreferredSize(new java.awt.Dimension(700, 510));
        containerCentral.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        containerCarousel.setBackground(new java.awt.Color(255, 255, 255));
        containerCarousel.setMaximumSize(new java.awt.Dimension(300, 500));
        containerCarousel.setMinimumSize(new java.awt.Dimension(300, 500));
        containerCentral.add(containerCarousel);

        containerForm.setPreferredSize(new java.awt.Dimension(385, 500));

        javax.swing.GroupLayout containerFormLayout = new javax.swing.GroupLayout(containerForm);
        containerForm.setLayout(containerFormLayout);
        containerFormLayout.setHorizontalGroup(
            containerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );
        containerFormLayout.setVerticalGroup(
            containerFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        containerCentral.add(containerForm);

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
    private com.mnm.carousel.view.component.Carousel containerCarousel;
    private com.mnm.carousel.view.component.RoundedJPanel containerCentral;
    private com.mnm.carousel.view.component.RoundedJPanel containerForm;
    private com.mnm.carousel.view.component.RoundedJPanel containerPrincipal;
    // End of variables declaration//GEN-END:variables
}
