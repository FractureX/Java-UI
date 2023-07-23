/*
 * Proyecto M&M
 */
package com.mnm.view.component.table1.view;

import com.mnm.view.component.table1.view.PanelPaymentStatusLabel.StatusType;

public class PanelPaymentStatus extends javax.swing.JPanel {
    
    public PanelPaymentStatus(StatusType statusType, String date) {
        initComponents();
        lblStatus.setMNM_statusType(statusType);
        lblUltimoPago.setText("Desde: " + date);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUltimoPago = new javax.swing.JLabel();
        lblStatus = new com.mnm.view.component.table1.view.PanelPaymentStatusLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(215, 221, 230)));

        lblUltimoPago.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblUltimoPago.setForeground(new java.awt.Color(102, 102, 102));
        lblUltimoPago.setText("Último pago");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUltimoPago)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUltimoPago)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mnm.view.component.table1.view.PanelPaymentStatusLabel lblStatus;
    private javax.swing.JLabel lblUltimoPago;
    // End of variables declaration//GEN-END:variables
}
