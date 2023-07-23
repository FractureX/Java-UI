package com.mnm.component.menu1.view;

import com.mnm.component.menu1.model.Menu_Item;
import com.mnm.component.menu1.view.Menu;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import java.awt.Image;
import javax.swing.BorderFactory;

public class Menu_ItemRenderer extends javax.swing.JPanel implements ListCellRenderer<Menu_Item> {
    
    Color blackTransparent = new Color(0, 0, 0, 75);
    
    public Menu_ItemRenderer() {
        initComponents();
        //setOpaque(true);
        setOpaque(false);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Menu_Item> list, Menu_Item item, int index, boolean isSelected, boolean cellHasFocus) {
        // Background
        /*
        if (item.getItemType() == Menu_Item.MenuType.NESTED_ITEM) {
            setBackground(blackTransparent);
        } else {
            setBackground(list.getBackground());
        }
        */
        // Icono
        if (item.getItemIcon().isEmpty()) {
            lblIcon.setIcon(null);
        } else {
            lblIcon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/sm/" + item.getItemIcon() + ".png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        }
        // Texto
        lblMenuName.setText(item.getItemTitle());
        lblMenuName.setForeground(new Color(255, 255, 255));
        if (item.getItemType() == Menu_Item.MenuType.MENUITEMNEST_NESTED) {
            setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        } else {
            setBorder(null);
        }
        if (item.getItemType() == Menu_Item.MenuType.EMPTY && item.getItemIndex() == (list.getModel().getSize() - 1)) {
            setSize(0, 0);
        }
        return this;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMenuName = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();

        lblMenuName.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuName.setText("Menu Name");

        lblIcon.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblIcon)
                .addGap(18, 18, 18)
                .addComponent(lblMenuName, javax.swing.GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            .addComponent(lblMenuName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMenuName;
    // End of variables declaration//GEN-END:variables
}
