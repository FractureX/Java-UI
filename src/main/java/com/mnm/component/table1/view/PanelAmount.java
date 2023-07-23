/*
 * Proyecto M&M
 */
package com.mnm.component.table1.view;

public class PanelAmount extends javax.swing.JPanel {
    
    public PanelAmount(String amount, String denomination) {
        initComponents();
        lblAmount.setText(amount);
        lblDenomination.setText(denomination);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAmount = new javax.swing.JLabel();
        lblDenomination = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(215, 221, 230)));

        lblAmount.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(51, 51, 51));
        lblAmount.setText("$0");

        lblDenomination.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblDenomination.setForeground(new java.awt.Color(102, 102, 102));
        lblDenomination.setText("USD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAmount, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDenomination, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAmount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDenomination)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblDenomination;
    // End of variables declaration//GEN-END:variables
}
