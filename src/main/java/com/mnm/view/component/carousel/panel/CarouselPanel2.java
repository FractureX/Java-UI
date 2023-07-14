/*
 * Proyecto M&M
 */
package com.mnm.view.component.carousel.panel;

import com.mnm.view.component.RoundedJPanel;
import java.awt.Component;
import javax.swing.JScrollPane;

public class CarouselPanel2 extends RoundedJPanel {
    
    public CarouselPanel2() {
        initComponents();
        removeListeners(getComponents());
    }
    
    private void removeListeners(Component comps []) {
        for (Component component: comps) {
            if (component.getClass() == RoundedJPanel.class) {
                removeListeners(((RoundedJPanel) component).getComponents());
            } else if (component.getClass() == JScrollPane.class) {
                // Remuevo los listeners del mouse para el view
                Component view = ((JScrollPane) component).getViewport().getView();
                while(view.getMouseListeners().length > 0) {
                    view.removeMouseListener(view.getMouseListeners()[0]);
                }
                while(view.getMouseMotionListeners().length > 0) {
                    view.removeMouseMotionListener(view.getMouseMotionListeners()[0]);
                }
                while(view.getMouseWheelListeners().length > 0) {
                    view.removeMouseWheelListener(view.getMouseWheelListeners()[0]);
                }
                // Remuevo los listeners del mouse del JScrollPane
                while(component.getMouseListeners().length > 0) {
                    component.removeMouseListener(component.getMouseListeners()[0]);
                }
                while(component.getMouseMotionListeners().length > 0) {
                    component.removeMouseMotionListener(component.getMouseMotionListeners()[0]);
                }
                while(component.getMouseWheelListeners().length > 0) {
                    component.removeMouseWheelListener(component.getMouseWheelListeners()[0]);
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setMNM_backgroundColor(new java.awt.Color(64, 64, 250));
        setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Los tqm");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("; ]"); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
