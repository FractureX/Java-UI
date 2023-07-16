/*
 * Proyecto M&M
 */
package com.mnm.form.view.stepper1;

import com.mnm.view.component.RoundedJPanel;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

public class StepsInfoPanel extends RoundedJPanel {
    
    private Color MNM_borderColor = new Color(255, 255, 255);
    private int MNM_borderSize = 5;
    private int MNM_distanceBetweenStep = 30;
    private int MNM_margin = 30;
    private int MNM_circleSize = 50;
    private int MNM_iconSize = 32;
    
    private List<Step> steps = new ArrayList<>();
    private Color checkColor = new Color(32, 195, 117);
    private Color currentColor = new Color(64, 64, 250);
    private Color inactiveColor = new Color(215, 221, 230);
    private int currentIndex = 0;
    private int heightSize = 0;
    
    public StepsInfoPanel() {
        initComponents();
        addSteps();
    }
    
    private void addSteps() {
        addStep(new Step("/images/info-32x32.png", new StepperPanel1(), "Título 1", "Descripción 1"));
        addStep(new Step("/images/contact-mail-32x32.png", new StepperPanel2(), "Título 2", "Descripción 2"));
        addStep(new Step("/images/user-32x32.png", new StepperPanel3(), "Título 3", "Descripción 3"));
    }
    
    private void addStep(Step step) {
        steps.add(step);
        heightSize = (MNM_circleSize * steps.size()) + (MNM_distanceBetweenStep * (steps.size() - 1));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Border
        g2d.setColor(MNM_borderColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), getMNM_arc(), getMNM_arc());
        // Background
        if (getMNM_backgroundColor() != getMNM_backgroundColor2()) {
            g2d.setPaint(new GradientPaint(getWidth() - MNM_borderSize, MNM_borderSize, getMNM_backgroundColor(), MNM_borderSize, getHeight() - MNM_borderSize, getMNM_backgroundColor2()));
        } else {
            g2d.setColor(getMNM_backgroundColor());
        }
        g2d.fillRoundRect(MNM_borderSize, MNM_borderSize, getWidth() - (MNM_borderSize * 2), getHeight() - (MNM_borderSize * 2), getMNM_arc(), getMNM_arc());
        // Steps
        g2d.setFont(getFont());
        for (int i = 0; i < steps.size(); i++) {
            if (i < currentIndex) {
                // checkColor
                
            } else if (i == currentIndex) {
                // currentColor
                
            } else {
                // inactiveColor
                
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMNM_shadowPixelsApply(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public Color getMNM_borderColor() {
        return MNM_borderColor;
    }
    
    public void setMNM_borderColor(Color MNM_borderColor) {
        this.MNM_borderColor = MNM_borderColor;
    }
    
    public int getMNM_borderSize() {
        return MNM_borderSize;
    }
    
    public void setMNM_borderSize(int MNM_borderSize) {
        this.MNM_borderSize = MNM_borderSize;
    }

    public int getMNM_distanceBetweenStep() {
        return MNM_distanceBetweenStep;
    }

    public void setMNM_distanceBetweenStep(int MNM_distanceBetweenStep) {
        this.MNM_distanceBetweenStep = MNM_distanceBetweenStep;
    }

    public int getMNM_margin() {
        return MNM_margin;
    }

    public void setMNM_margin(int MNM_margin) {
        this.MNM_margin = MNM_margin;
    }

    public int getMNM_circleSize() {
        return MNM_circleSize;
    }

    public void setMNM_circleSize(int MNM_circleSize) {
        this.MNM_circleSize = MNM_circleSize;
    }

    public int getMNM_iconSize() {
        return MNM_iconSize;
    }

    public void setMNM_iconSize(int MNM_iconSize) {
        this.MNM_iconSize = MNM_iconSize;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
