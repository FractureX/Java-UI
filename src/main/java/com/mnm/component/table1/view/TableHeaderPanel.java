/*
 * Proyecto M&M
 */
package com.mnm.component.table1.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TableHeaderPanel extends javax.swing.JPanel {
    
    public TableHeaderPanel(String title, int column) {
        initComponents();
        if (column == 0) {
            JCheckBox checkBox = new JCheckBox();
            checkBox.setOpaque(true);
            checkBox.setBackground(new Color(242, 246, 254));
            checkBox.setHorizontalAlignment(SwingConstants.CENTER);
            add(checkBox, java.awt.BorderLayout.CENTER);
        } else {
            JLabel label = new JLabel(title);
            label.setText(title);
            label.setFont(new java.awt.Font("Roboto", Font.BOLD, 12)); // NOI18N
            label.setForeground(new java.awt.Color(51, 51, 51));
            add(label, SwingConstants.CENTER);
        }
        Dimension dimension = new Dimension(getWidth(), 40);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setPreferredSize(dimension);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(242, 246, 254));
        setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(215, 221, 230)));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
