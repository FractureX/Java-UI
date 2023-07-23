/*
 * Proyecto M&M
 */
package com.mnm.view.frame;

import com.mnm.form.stepper1.view.StepperPanel1;
import com.mnm.form.stepper1.view.StepperPanel2;
import com.mnm.form.stepper1.view.StepperPanel3;
import com.mnm.form.stepper1.view.StepperPanel4;
import com.mnm.component.table1.view.PanelAmount;
import com.mnm.component.table1.view.PanelName;
import com.mnm.component.table1.view.PanelPaymentStatus;
import com.mnm.component.table1.view.PanelUserStatus;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JCheckBox;

public class Example extends javax.swing.JFrame {
    
    public Example() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLocationRelativeTo(null);
        tablePanel1.setColumnClasses(new Class[] {
            JCheckBox.class,
            PanelName.class,
            PanelUserStatus.class,
            PanelPaymentStatus.class,
            PanelAmount.class
        });
        addSteps();
    }
    
    private void addSteps() {
        /*
        stepper1.addStep("/images/info-32x32.png", "/images/info-32x32-2.png", new StepperPanel1(), "Título 1", "Descripción 1");
        stepper1.addStep("/images/contact-mail-32x32.png", "/images/contact-mail-32x32-2.png", new StepperPanel2(), "Título 2", "Descripción 2");
        stepper1.addStep("/images/user-32x32.png", "/images/user-32x32-2.png", new StepperPanel3(), "Título 3", "Descripción 3");
        stepper1.addStep("/images/info-32x32.png", "/images/info-32x32-2.png", new StepperPanel4(), "Título 4", "Descripción 4");
        stepper1.init();
        */
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tablePanel1 = new com.mnm.component.view.table1.TablePanel();
        containerPrincipal = new com.mnm.component.view.RoundedJPanel();
        containerCentral = new com.mnm.component.view.RoundedJPanel();
        menu1 = new com.mnm.component.menu1.view.Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        containerPrincipal.setMNM_arc(0);
        containerPrincipal.setMNM_backgroundColor(new java.awt.Color(215, 221, 230));
        containerPrincipal.setMNM_backgroundColor2(new java.awt.Color(215, 221, 230));
        containerPrincipal.setMNM_shadowPixelsApply(false);
        containerPrincipal.setPreferredSize(new java.awt.Dimension(800, 600));

        containerCentral.setMNM_shadowPixels(10);
        containerCentral.setPreferredSize(new java.awt.Dimension(750, 650));

        javax.swing.GroupLayout containerCentralLayout = new javax.swing.GroupLayout(containerCentral);
        containerCentral.setLayout(containerCentralLayout);
        containerCentralLayout.setHorizontalGroup(
            containerCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerCentralLayout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 365, Short.MAX_VALUE))
        );
        containerCentralLayout.setVerticalGroup(
            containerCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout containerPrincipalLayout = new javax.swing.GroupLayout(containerPrincipal);
        containerPrincipal.setLayout(containerPrincipalLayout);
        containerPrincipalLayout.setHorizontalGroup(
            containerPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        containerPrincipalLayout.setVerticalGroup(
            containerPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerCentral, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.mnm.component.view.RoundedJPanel containerCentral;
    private com.mnm.component.view.RoundedJPanel containerPrincipal;
    private com.mnm.component.menu1.view.Menu menu1;
    private com.mnm.component.view.table1.TablePanel tablePanel1;
    // End of variables declaration//GEN-END:variables
}
