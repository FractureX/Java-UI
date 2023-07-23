/*
 * Proyecto M&M
 */
package com.mnm.component.view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

public class RoundedJPanel extends javax.swing.JPanel {
    
    private Color MNM_backgroundColor = new Color(255, 255, 255);
    private Color MNM_backgroundColor2 = new Color(255, 255, 255);
    private int MNM_arc = 20;
    private int MNM_shadowOpacity = 25;
    private int MNM_shadowPixels = 5;
    private boolean MNM_shadowPixelsApply = true;
    
    public RoundedJPanel() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setBorder();
        initEvents();
    }
    
    private void initEvents() {
        mouseEvent();
    }
    
    private void mouseEvent() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                requestFocusInWindow();
            }
        });
    }
    
    private void setBorder() {
        if (MNM_shadowPixelsApply) {
            setBorder(BorderFactory.createEmptyBorder(MNM_shadowPixels, MNM_shadowPixels, MNM_shadowPixels, MNM_shadowPixels));
        } else {
            setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (MNM_backgroundColor != MNM_backgroundColor2) {
            g2d.setPaint(new GradientPaint(getWidth(), 0, MNM_backgroundColor, 0, getHeight(), MNM_backgroundColor2));
        } else {
            g2d.setColor(MNM_backgroundColor);
        }
        if (MNM_shadowPixelsApply) {
            g2d.fillRoundRect(MNM_shadowPixels, MNM_shadowPixels, getWidth() - (MNM_shadowPixels * 2), getHeight() - (MNM_shadowPixels * 2), MNM_arc, MNM_arc);
            int shade = 0;
            for (int i = 0; i < MNM_shadowPixels; i++) {
                g2d.setColor(new Color(shade, shade, shade, ((MNM_shadowOpacity / MNM_shadowPixels) * i)));
                g2d.drawRoundRect(i, i, getWidth() - ((i * 2) + 1), getHeight() - ((i * 2) + 1), MNM_arc, MNM_arc);
            }
        } else {
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), MNM_arc, MNM_arc);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public Color getMNM_backgroundColor() {
        return MNM_backgroundColor;
    }

    public void setMNM_backgroundColor(Color MNM_backgroundColor) {
        this.MNM_backgroundColor = MNM_backgroundColor;
    }

    public int getMNM_arc() {
        return MNM_arc;
    }

    public void setMNM_arc(int MNM_arc) {
        this.MNM_arc = MNM_arc;
    }

    public int getMNM_shadowPixels() {
        return MNM_shadowPixels;
    }

    public void setMNM_shadowPixels(int MNM_shadowPixels) {
        this.MNM_shadowPixels = MNM_shadowPixels;
        setBorder();
    }

    public boolean isMNM_shadowPixelsApply() {
        return MNM_shadowPixelsApply;
    }

    public void setMNM_shadowPixelsApply(boolean MNM_shadowPixelsApply) {
        this.MNM_shadowPixelsApply = MNM_shadowPixelsApply;
        setBorder();
    }

    public int getMNM_shadowOpacity() {
        return MNM_shadowOpacity;
    }

    public void setMNM_shadowOpacity(int MNM_shadowOpacity) {
        this.MNM_shadowOpacity = MNM_shadowOpacity;
    }

    public Color getMNM_backgroundColor2() {
        return MNM_backgroundColor2;
    }

    public void setMNM_backgroundColor2(Color MNM_backgroundColor2) {
        this.MNM_backgroundColor2 = MNM_backgroundColor2;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
