/*
 * Proyecto M&M
 */
package com.mnm.form.view.stepper1;

import com.mnm.view.component.RoundedJPanel;

public class Stepper extends RoundedJPanel {
    
    
    
    public Stepper() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stepsInfoPanel1 = new com.mnm.form.view.stepper1.StepsInfoPanel();

        setMNM_backgroundColor(new java.awt.Color(235, 237, 243));
        setMNM_backgroundColor2(new java.awt.Color(235, 237, 243));
        setMNM_shadowPixelsApply(false);

        stepsInfoPanel1.setMNM_arc(10);
        stepsInfoPanel1.setMNM_backgroundColor(new java.awt.Color(216, 228, 248));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stepsInfoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(359, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stepsInfoPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mnm.form.view.stepper1.StepsInfoPanel stepsInfoPanel1;
    // End of variables declaration//GEN-END:variables
}
