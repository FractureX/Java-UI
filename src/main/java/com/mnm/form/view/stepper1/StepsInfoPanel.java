/*
 * Proyecto M&M
 */
package com.mnm.form.view.stepper1;

import com.mnm.view.component.RoundedJPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class StepsInfoPanel extends RoundedJPanel {
    
    private Color MNM_borderColor = new Color(255, 255, 255);
    private Color MNM_titleForegrundColor = new Color(0, 0, 0);
    private Color MNM_descriptionForegrundColor = new Color(0, 0, 0);
    private int MNM_borderSize = 5;
    private int MNM_distanceBetweenStep = 30;
    private int MNM_margin = 30;
    private int MNM_circleSize = 50;
    private int MNM_circleOutsideMargin = 10;
    private int MNM_iconSize = 32;
    
    private List<Step> steps = new ArrayList<>();
    private Color checkColor = new Color(32, 195, 117);
    private Color currentColor = new Color(64, 64, 250);
    private Color inactiveColor = new Color(215, 221, 230);
    private int currentIndex = 0;
    private int heightSize = 0;
    private String iconCheckPath = "/images/check-mark-32x32.png";
    private ImageIcon iconCheck = new ImageIcon(new ImageIcon(getClass().getResource(iconCheckPath)).getImage().getScaledInstance(MNM_iconSize, MNM_iconSize, Image.SCALE_SMOOTH));
    private Font titleFont = null;
    private Font descriptionFont = null;
    
    public StepsInfoPanel() {
        initComponents();
        titleFont = getFont().deriveFont(Font.BOLD, 14);
        descriptionFont = getFont().deriveFont(Font.BOLD, 18);
    }
    
    public void addStep(Step step) {
        steps.add(step);
        checkHeightSize();
    }
    
    // Métodos públicos
    public Step getCurrentStep() {
        return steps.get(currentIndex);
    }
    
    public Step getFirstStep() {
        return steps.get(0);
    }
    
    public Step getLastStep() {
        return steps.get(steps.size() - 1);
    }
    
    public Step nextStep() {
        if (currentIndex < (steps.size() - 1)) {
            currentIndex++;
        }
        repaint();
        return steps.get(currentIndex);
    }
    
    public Step previousStep() {
        if (currentIndex > 0) {
            currentIndex--;
        }
        repaint();
        return steps.get(currentIndex);
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
                g2d.setColor(checkColor);
            } else if (i == currentIndex) {
                // currentColor
                g2d.setColor(currentColor);
            } else {
                // inactiveColor
                g2d.setColor(inactiveColor);
            }
            // Círculo
            int xCirculo = MNM_margin;
            int yCirculo = ((getHeight() / 2) - (heightSize / 2)) + (i * (MNM_circleSize + MNM_distanceBetweenStep));
            if (i <= currentIndex) {
                g2d.fillOval(xCirculo, yCirculo, MNM_circleSize, MNM_circleSize);
            }
            int xCirculoExterior = xCirculo - (MNM_circleOutsideMargin / 2);
            int yCirculoExterior = yCirculo - (MNM_circleOutsideMargin / 2);
            g2d.drawOval(xCirculoExterior, yCirculoExterior, (MNM_circleSize + MNM_circleOutsideMargin), (MNM_circleSize + MNM_circleOutsideMargin));
            // Ícono
            int xIcono = (xCirculo + (MNM_circleSize / 2)) - (MNM_iconSize / 2);
            int yIcono = (yCirculo + (MNM_circleSize / 2)) - (MNM_iconSize / 2);
            if (i < currentIndex) {
                g2d.drawImage(iconCheck.getImage(), xIcono, yIcono, null);
            } else if (i == currentIndex) {
                g2d.drawImage(steps.get(i).getImageIcon().getImage(), xIcono, yIcono, null);
            } else {
                g2d.drawImage(steps.get(i).getImageIcon2().getImage(), xIcono, yIcono, null);
            }
            // Líneas de separación
            if (i < (steps.size() - 1)) {
                int width = 2;
                int height = MNM_distanceBetweenStep - (MNM_distanceBetweenStep / 2);
                int xLinea = xCirculo + (MNM_circleSize / 2) - (width / 2);
                int yLinea = yCirculo + MNM_circleSize + ((MNM_distanceBetweenStep / 2) / 2);
                if (i < currentIndex) {
                    // checkColor
                    g2d.setColor(checkColor);
                } else if (i < (steps.size() - 1)) {
                    g2d.setColor(inactiveColor);
                }
                g2d.fillRoundRect(xLinea, yLinea, width, height, width, width);
            }
            // Título
            int xTitulo = xCirculo + MNM_circleSize + (MNM_circleOutsideMargin * 2);
            int yTitulo = ((yCirculo) + g2d.getFontMetrics().getAscent() - g2d.getFontMetrics().getDescent()) + (MNM_circleSize / 6);
            g2d.setFont(titleFont);
            if (i <= currentIndex) {
                g2d.setColor(MNM_titleForegrundColor);
            } else {
                g2d.setColor(inactiveColor.darker());
            }
            g2d.drawString(steps.get(i).getTitle(), xTitulo, yTitulo);
            // Descripción
            int xDescripcion = xCirculo + MNM_circleSize + (MNM_circleOutsideMargin * 2);
            int yDescripcion = ((yCirculo) + g2d.getFontMetrics().getAscent() - g2d.getFontMetrics().getDescent()) + (MNM_circleSize / 2) + (MNM_circleSize / 3) - (MNM_circleSize / 6);
            g2d.setFont(descriptionFont);
            if (i <= currentIndex) {
                g2d.setColor(MNM_titleForegrundColor);
            } else {
                g2d.setColor(inactiveColor.darker());
            }
            g2d.drawString(steps.get(i).getDescription(), xDescripcion, yDescripcion);
            
        }
    }
    
    private void checkHeightSize() {
        heightSize = (MNM_circleSize * steps.size()) + (MNM_distanceBetweenStep * (steps.size() - 1));
    }
    
    public void checkIconsSize() {
        iconCheck = new ImageIcon(new ImageIcon(getClass().getResource(iconCheckPath)).getImage().getScaledInstance(MNM_iconSize, MNM_iconSize, Image.SCALE_SMOOTH));
        for (Step step : steps) {
            step.setImageIcon(new ImageIcon(new ImageIcon(getClass().getResource(step.getIconPath())).getImage().getScaledInstance(MNM_iconSize, MNM_iconSize, Image.SCALE_SMOOTH)));
            step.setImageIcon2(new ImageIcon(new ImageIcon(getClass().getResource(step.getIconPath2())).getImage().getScaledInstance(MNM_iconSize, MNM_iconSize, Image.SCALE_SMOOTH)));
        }
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
        titleFont = font.deriveFont(Font.BOLD, 10);
        descriptionFont = font.deriveFont(Font.BOLD, 14);
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
    
    public int getStepsSize() {
        return steps.size();
    }
    
    public int getCurrentIndex() {
        return currentIndex;
    }
    
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
        checkHeightSize();
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
        checkHeightSize();
    }

    public int getMNM_iconSize() {
        return MNM_iconSize;
    }

    public void setMNM_iconSize(int MNM_iconSize) {
        this.MNM_iconSize = MNM_iconSize;
        checkIconsSize();
    }

    public int getMNM_circleOutsideMargin() {
        return MNM_circleOutsideMargin;
    }

    public void setMNM_circleOutsideMargin(int MNM_circleOutsideMargin) {
        this.MNM_circleOutsideMargin = MNM_circleOutsideMargin;
    }

    public Color getMNM_titleForegrundColor() {
        return MNM_titleForegrundColor;
    }

    public void setMNM_titleForegrundColor(Color MNM_titleForegrundColor) {
        this.MNM_titleForegrundColor = MNM_titleForegrundColor;
    }

    public Color getMNM_descriptionForegrundColor() {
        return MNM_descriptionForegrundColor;
    }

    public void setMNM_descriptionForegrundColor(Color MNM_descriptionForegrundColor) {
        this.MNM_descriptionForegrundColor = MNM_descriptionForegrundColor;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
