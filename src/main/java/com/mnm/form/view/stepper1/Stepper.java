/*
 * Proyecto M&M
 */
package com.mnm.form.view.stepper1;

import com.mnm.view.component.RoundedJPanel;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Stepper extends RoundedJPanel {
    
    Step currentStep = null;
    private Cursor cursorHand = new Cursor(Cursor.HAND_CURSOR);
    private Cursor cursorDefault = new Cursor(Cursor.DEFAULT_CURSOR);
    private ImageIcon rightArrowImageIcon = new ImageIcon(getClass().getResource("/images/right-arrow-32x32.png"));
    
    private String MNM_lastStepText = "Finalizar";
    
    public Stepper() {
        initComponents();
    }
    
    public void init() {
        stepsInfoPanel.init();
        setInitStep();
    }
    
    public void addStep(String iconPath, String iconPath2, RoundedJPanel panel, String title, String description) {
        stepsInfoPanel.addStep(new Step(iconPath, iconPath2, panel, title, description));
    }
    
    private void setInitStep() {
        currentStep = stepsInfoPanel.getCurrentStep();
        setStep(currentStep);
    }
    
    private void previousStep() {
        currentStep = stepsInfoPanel.doStep(StepsInfoPanel.doStep.previous);
        setStep(currentStep);
    }
    
    private void nextStep() {
        if (currentStep != stepsInfoPanel.getLastStep()) {
            currentStep = stepsInfoPanel.doStep(StepsInfoPanel.doStep.next);
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
        checkCurrentStep();
    }
    
    private void checkCurrentStep() {
        btnAnterior.setVisible(true);
        if (stepsInfoPanel.getStepsSize() == 0) {
            btnAnterior.setEnabled(false);
            btnAnterior.setCursor(cursorDefault);
            btnSiguiente.setEnabled(false);
            btnSiguiente.setCursor(cursorDefault);
        } else if (stepsInfoPanel.getStepsSize() == 1) {
            btnAnterior.setVisible(false);
            btnSiguiente.setEnabled(true);
            btnSiguiente.setCursor(cursorHand);
            btnSiguiente.setText(MNM_lastStepText);
            btnSiguiente.setMNM_icon(null);
        } else {
            if (stepsInfoPanel.getCurrentIndex() == 0) {
                btnAnterior.setEnabled(false);
                btnAnterior.setCursor(cursorDefault);
                btnSiguiente.setEnabled(true);
                btnSiguiente.setCursor(cursorHand);
            } else {
                btnAnterior.setEnabled(true);
                btnAnterior.setCursor(cursorHand);
                btnSiguiente.setEnabled(true);
                btnSiguiente.setCursor(cursorHand);
                if (stepsInfoPanel.getCurrentIndex() == (stepsInfoPanel.getStepsSize() - 1)) {
                    btnSiguiente.setText(MNM_lastStepText);
                    btnSiguiente.setMNM_icon(null);
                } else {
                    btnSiguiente.setText("Siguiente");
                    btnSiguiente.setMNM_icon(rightArrowImageIcon);
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        stepsInfoPanel = new com.mnm.form.view.stepper1.StepsInfoPanel();
        roundedJPanel1 = new com.mnm.view.component.RoundedJPanel();
        stepContainer = new com.mnm.view.component.RoundedJPanel();
        btnSiguiente = new com.mnm.view.component.RoundedJLabel();
        btnAnterior = new com.mnm.view.component.RoundedJLabel();

        setMNM_backgroundColor(new java.awt.Color(235, 237, 243));
        setMNM_backgroundColor2(new java.awt.Color(235, 237, 243));
        setMNM_shadowPixels(0);
        setMNM_shadowPixelsApply(false);

        stepsInfoPanel.setMNM_backgroundColor(new java.awt.Color(216, 228, 248));
        stepsInfoPanel.setMNM_borderSize(10);
        stepsInfoPanel.setMNM_circleSize(35);
        stepsInfoPanel.setMNM_distanceBetweenStep(40);
        stepsInfoPanel.setMNM_iconSize(20);
        stepsInfoPanel.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        roundedJPanel1.setMNM_shadowPixelsApply(false);

        stepContainer.setMNM_shadowPixelsApply(false);
        stepContainer.setLayout(new javax.swing.BoxLayout(stepContainer, javax.swing.BoxLayout.LINE_AXIS));

        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setMNM_backgroundActiveColor(new java.awt.Color(64, 64, 250));
        btnSiguiente.setMNM_backgroundInactiveColor(new java.awt.Color(204, 204, 204));
        btnSiguiente.setMNM_icon(new javax.swing.ImageIcon(getClass().getResource("/images/right-arrow-32x32.png"))); // NOI18N
        btnSiguiente.setMNM_iconMargin(20);
        btnSiguiente.setMNM_iconPosition(com.mnm.view.component.RoundedJLabel.iconPosition.Right);
        btnSiguiente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSiguienteMousePressed(evt);
            }
        });

        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAnterior.setText("Anterior");
        btnAnterior.setMNM_backgroundActiveColor(new java.awt.Color(64, 64, 250));
        btnAnterior.setMNM_backgroundInactiveColor(new java.awt.Color(204, 204, 204));
        btnAnterior.setMNM_icon(new javax.swing.ImageIcon(getClass().getResource("/images/left-arrow-32x32.png"))); // NOI18N
        btnAnterior.setMNM_iconMargin(20);
        btnAnterior.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAnteriorMousePressed(evt);
            }
        });

        javax.swing.GroupLayout roundedJPanel1Layout = new javax.swing.GroupLayout(roundedJPanel1);
        roundedJPanel1.setLayout(roundedJPanel1Layout);
        roundedJPanel1Layout.setHorizontalGroup(
            roundedJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(stepContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundedJPanel1Layout.createSequentialGroup()
                        .addGap(0, 29, Short.MAX_VALUE)
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        roundedJPanel1Layout.setVerticalGroup(
            roundedJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedJPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stepContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundedJPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(stepsInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(roundedJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(stepsInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(roundedJPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnteriorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            if (btnAnterior.isEnabled()) {
                previousStep();
            }
        }
    }//GEN-LAST:event_btnAnteriorMousePressed

    private void btnSiguienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            if (btnSiguiente.isEnabled()) {
                nextStep();
            }
        }
    }//GEN-LAST:event_btnSiguienteMousePressed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mnm.view.component.RoundedJLabel btnAnterior;
    private com.mnm.view.component.RoundedJLabel btnSiguiente;
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
