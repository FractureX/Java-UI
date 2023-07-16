/*
 * Proyecto M&M
 */
package com.mnm.view.frame;

import com.mnm.form.view.stepper1.Step;
import com.mnm.form.view.stepper1.StepperPanel1;
import com.mnm.form.view.stepper1.StepperPanel2;
import com.mnm.form.view.stepper1.StepperPanel3;
import com.mnm.form.view.stepper1.StepperPanel4;
import java.awt.Color;
import java.awt.Toolkit;

public class Example extends javax.swing.JFrame {
    
    public Example() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
        addSteps();
    }
    
    private void addSteps() {
        stepper.addStep(new Step("/images/info-32x32.png", "/images/info-32x32-2.png", new StepperPanel1(), "Título 1", "Descripción 1"));
        stepper.addStep(new Step("/images/contact-mail-32x32.png", "/images/contact-mail-32x32-2.png", new StepperPanel2(), "Título 2", "Descripción 2"));
        stepper.addStep(new Step("/images/user-32x32.png", "/images/user-32x32-2.png", new StepperPanel3(), "Título 3", "Descripción 3"));
        stepper.addStep(new Step("/images/info-32x32.png", "/images/info-32x32-2.png", new StepperPanel4(), "Título 4", "Descripción 4"));
        stepper.checkIconsSize();
        stepper.init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        containerPrincipal = new com.mnm.view.component.RoundedJPanel();
        containerCentral = new com.mnm.view.component.RoundedJPanel();
        stepper = new com.mnm.form.view.stepper1.Stepper();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        containerPrincipal.setMNM_arc(0);
        containerPrincipal.setMNM_backgroundColor(new java.awt.Color(215, 221, 230));
        containerPrincipal.setMNM_backgroundColor2(new java.awt.Color(215, 221, 230));
        containerPrincipal.setMNM_shadowPixelsApply(false);
        containerPrincipal.setPreferredSize(new java.awt.Dimension(800, 600));
        containerPrincipal.setLayout(new java.awt.GridBagLayout());

        containerCentral.setMNM_shadowPixels(10);
        containerCentral.setPreferredSize(new java.awt.Dimension(700, 530));
        containerCentral.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        stepper.setMNM_backgroundColor(new java.awt.Color(255, 255, 255));
        stepper.setMNM_backgroundColor2(new java.awt.Color(255, 255, 255));
        stepper.setPreferredSize(new java.awt.Dimension(680, 510));
        containerCentral.add(stepper);

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
    private com.mnm.view.component.RoundedJPanel containerCentral;
    private com.mnm.view.component.RoundedJPanel containerPrincipal;
    private com.mnm.form.view.stepper1.Stepper stepper;
    // End of variables declaration//GEN-END:variables
}