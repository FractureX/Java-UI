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

        buttonGroup1 = new javax.swing.ButtonGroup();
        stepsInfoPanel1 = new com.mnm.form.view.stepper1.StepsInfoPanel();
        roundedJTextField1 = new com.mnm.form.view.component.RoundedJTextField();
        roundedJRadioButton1 = new com.mnm.form.view.component.RoundedJRadioButton();
        roundedJRadioButton2 = new com.mnm.form.view.component.RoundedJRadioButton();
        roundedJRadioButton3 = new com.mnm.form.view.component.RoundedJRadioButton();

        setMNM_backgroundColor(new java.awt.Color(235, 237, 243));
        setMNM_backgroundColor2(new java.awt.Color(235, 237, 243));
        setMNM_shadowPixelsApply(false);

        stepsInfoPanel1.setMNM_arc(10);
        stepsInfoPanel1.setMNM_backgroundColor(new java.awt.Color(216, 228, 248));
        stepsInfoPanel1.setMNM_circleSize(35);
        stepsInfoPanel1.setMNM_distanceBetweenStep(40);
        stepsInfoPanel1.setMNM_iconSize(20);
        stepsInfoPanel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        roundedJTextField1.setText("Campo de texto");

        buttonGroup1.add(roundedJRadioButton1);
        roundedJRadioButton1.setText("Selección 1");

        buttonGroup1.add(roundedJRadioButton2);
        roundedJRadioButton2.setText("Selección 2");

        buttonGroup1.add(roundedJRadioButton3);
        roundedJRadioButton3.setText("Selección 3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stepsInfoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundedJTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(roundedJRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(roundedJRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addComponent(roundedJRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(roundedJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roundedJRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundedJRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roundedJRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(stepsInfoPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.mnm.form.view.component.RoundedJRadioButton roundedJRadioButton1;
    private com.mnm.form.view.component.RoundedJRadioButton roundedJRadioButton2;
    private com.mnm.form.view.component.RoundedJRadioButton roundedJRadioButton3;
    private com.mnm.form.view.component.RoundedJTextField roundedJTextField1;
    private com.mnm.form.view.stepper1.StepsInfoPanel stepsInfoPanel1;
    // End of variables declaration//GEN-END:variables
}
