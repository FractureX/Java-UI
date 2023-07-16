/*
 * Proyecto M&M
 */
package com.mnm.form.view.stepper1;

import com.mnm.view.component.RoundedJPanel;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Stepper2 extends RoundedJPanel {
    
    Step currentStep = null;
    private Cursor cursorHand = new Cursor(Cursor.HAND_CURSOR);
    private Cursor cursorDefault = new Cursor(Cursor.DEFAULT_CURSOR);
    private ImageIcon rightArrowImageIcon = new ImageIcon(getClass().getResource("/images/right-arrow-32x32.png"));
    
    private String MNM_lastStepText = "Finalizar";
    
    public Stepper2() {
        initComponents();
        init();
    }
    
    private void init() {
        setInitStep();
    }
    
    private void setInitStep() {
        currentStep = stepsInfoPanel.getCurrentStep();
        setStep(currentStep);
    }
    
    private void previousStep() {
        currentStep = stepsInfoPanel.previousStep();
        setStep(currentStep);
    }
    
    private void nextStep() {
        if (currentStep != stepsInfoPanel.getLastStep()) {
            currentStep = stepsInfoPanel.nextStep();
            setStep(currentStep);
        } else {
            JOptionPane.showMessageDialog(null, "Form finalizado : ]");
        }
    }
    
    private void setStep(Step step) {
        stepContainer.removeAll();
        stepContainer.add(step.getPanel());
        roundedJPanel1.revalidate();
        roundedJPanel1.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        stepsInfoPanel = new com.mnm.form.view.stepper1.StepsInfoPanel();
        roundedJPanel1 = new com.mnm.view.component.RoundedJPanel();
        stepContainer = new com.mnm.view.component.RoundedJPanel();

        setMNM_backgroundColor(new java.awt.Color(235, 237, 243));
        setMNM_backgroundColor2(new java.awt.Color(235, 237, 243));
        setMNM_shadowPixels(0);
        setMNM_shadowPixelsApply(false);

        stepsInfoPanel.setMNM_backgroundColor(new java.awt.Color(216, 228, 248));
        stepsInfoPanel.setMNM_circleSize(35);
        stepsInfoPanel.setMNM_distanceBetweenStep(40);
        stepsInfoPanel.setMNM_iconSize(20);
        stepsInfoPanel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        roundedJPanel1.setMNM_shadowPixelsApply(false);

        stepContainer.setMNM_shadowPixelsApply(false);
        stepContainer.setLayout(new javax.swing.BoxLayout(stepContainer, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout roundedJPanel1Layout = new javax.swing.GroupLayout(roundedJPanel1);
        roundedJPanel1.setLayout(roundedJPanel1Layout);
        roundedJPanel1Layout.setHorizontalGroup(
            roundedJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stepContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundedJPanel1Layout.setVerticalGroup(
            roundedJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stepContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(stepsInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundedJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stepsInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(roundedJPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.mnm.view.component.RoundedJPanel roundedJPanel1;
    private com.mnm.view.component.RoundedJPanel stepContainer;
    private com.mnm.form.view.stepper1.StepsInfoPanel stepsInfoPanel;
    // End of variables declaration//GEN-END:variables

    public String getMNM_lastStepText() {
        return MNM_lastStepText;
    }

    public void setMNM_lastStepText(String MNM_lastStepText) {
        this.MNM_lastStepText = MNM_lastStepText;
    }
}
