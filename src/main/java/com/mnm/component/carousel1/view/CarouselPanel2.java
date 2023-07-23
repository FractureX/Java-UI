/*
 * Proyecto M&M
 */
package com.mnm.component.carousel1.view;

import com.mnm.component.view.RoundedJPanel;

public class CarouselPanel2 extends RoundedJPanel {
    
    public CarouselPanel2() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setMNM_backgroundColor(new java.awt.Color(64, 64, 250));
        setMNM_backgroundColor2(new java.awt.Color(64, 64, 250));
        setMNM_shadowPixelsApply(false);
        setMaximumSize(new java.awt.Dimension(300, 500));
        setMinimumSize(new java.awt.Dimension(300, 500));
        setPreferredSize(new java.awt.Dimension(300, 500));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Shaquille");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 420, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
