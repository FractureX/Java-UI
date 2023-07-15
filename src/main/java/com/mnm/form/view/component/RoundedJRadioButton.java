/*
 * Proyecto M&M
 */
package com.mnm.form.view.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.border.Border;

public class RoundedJRadioButton extends JRadioButton {
    
    private int MNM_timerMilSec = 250;
    private int MNM_arc = 10;
    private int MNM_margin = 10;
    private int MNM_circleSize = 10;
    private Color MNM_borderActiveColor = new Color(64, 64, 250);
    private Color MNM_borderInactiveColor = new Color(215, 221, 230);
    private Color MNM_backgroundActiveColor = new Color(242, 246, 254);
    private Color MNM_backgroundInactiveColor = new Color(255, 255, 255);
    
    private Timer timer;
    private double timerTick = 25;
    private int circleInternalSize = 5;
    private Color foregroundCurrentColor = new Color(0, 0, 0);
    private Color borderCurrentColor = new Color(215, 221, 230);
    private Color backgroundCurrentColor = new Color(255, 255, 255);
    
    public RoundedJRadioButton() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        initEvents();
        setBorder();
    }
    
    private void initEvents() {
        timerEvent();
        changeEvent();
    }
    
    private void setBorder() {
        setBorder(BorderFactory.createEmptyBorder(MNM_margin, MNM_margin + MNM_circleSize, MNM_margin, MNM_margin));
    }
    
    private void changeEvent() {
        addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (timer.isRunning()) {
                    timer.stop();
                }
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    setSelected(true);
                } else {
                    setSelected(false);
                }
                timer.start();
            }
        });
    }
    
    private void timerEvent() {
        timer = new Timer((int) (MNM_timerMilSec / 10), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color borderColor = null;
                Color backgroundColor = null;
                Color foregroundColor = null;
                if (isSelected()) {
                    // Busco cambiar a activo
                    // 215 -> 64
                    borderColor = extractColor(borderCurrentColor, MNM_borderActiveColor, false);
                    backgroundColor = extractColor(backgroundCurrentColor, MNM_backgroundActiveColor, false);
                    foregroundColor = extractColor(foregroundCurrentColor, MNM_borderActiveColor, true);
                    if (borderColor.getRed() <= MNM_borderActiveColor.getRed()) {
                        borderCurrentColor = MNM_borderActiveColor;
                        backgroundCurrentColor = MNM_backgroundActiveColor;
                        foregroundCurrentColor = MNM_borderActiveColor;
                        repaint();
                        timer.stop();
                        return;
                    }
                } else {
                    // Busco cambiar a inactivo
                    // 64 -> 215
                    borderColor = extractColor(borderCurrentColor, MNM_borderInactiveColor, true);
                    backgroundColor = extractColor(backgroundCurrentColor, MNM_backgroundInactiveColor, true);
                    foregroundColor = extractColor(foregroundCurrentColor, getForeground(), false);
                    if (borderColor.getRed() >= MNM_borderInactiveColor.getRed()) {
                        borderCurrentColor = MNM_borderInactiveColor;
                        backgroundCurrentColor = MNM_backgroundInactiveColor;
                        foregroundCurrentColor = getForeground();
                        repaint();
                        timer.stop();
                        return;
                    }
                }
                borderCurrentColor = borderColor;
                backgroundCurrentColor = backgroundColor;
                foregroundCurrentColor = foregroundColor;
                repaint();
            }
        });
    }
    
    private Color extractColor(Color fromColor, Color toColor, boolean increase) {
        if (!increase) {
            double rBorder = fromColor.getRed() - Math.ceil(((fromColor.getRed() - toColor.getRed()) * (timerTick / (double) MNM_timerMilSec)));
            double gBorder = fromColor.getGreen() - Math.ceil(((fromColor.getGreen() - toColor.getGreen()) * (timerTick / (double) MNM_timerMilSec)));
            double bBorder = fromColor.getBlue() - Math.ceil(((fromColor.getBlue() - toColor.getBlue()) * (timerTick / (double) MNM_timerMilSec)));
            return new Color((int) rBorder, (int) gBorder, (int) bBorder);
        } else {
            double rBorder = fromColor.getRed() + Math.ceil(((toColor.getRed() - fromColor.getRed()) * (timerTick / (double) MNM_timerMilSec)));
            double gBorder = fromColor.getGreen() + Math.ceil(((toColor.getGreen() - fromColor.getGreen()) * (timerTick / (double) MNM_timerMilSec)));
            double bBorder = fromColor.getBlue() + Math.ceil(((toColor.getBlue() - fromColor.getBlue()) * (timerTick / (double) MNM_timerMilSec)));
            return new Color((int) rBorder, (int) gBorder, (int) bBorder);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Background
        g2d.setColor(backgroundCurrentColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), MNM_arc, MNM_arc);
        // Border
        g2d.setColor(borderCurrentColor);
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, MNM_arc, MNM_arc);
        // Circle
        g2d.drawOval(MNM_margin, (getHeight() / 2) - (MNM_circleSize / 2), MNM_circleSize, MNM_circleSize);
        g2d.fillOval(MNM_margin + circleInternalSize - (circleInternalSize / 2), ((getHeight() / 2) - (MNM_circleSize / 2)) + circleInternalSize - (circleInternalSize / 2), circleInternalSize, circleInternalSize);
        // Texto
        g2d.setFont(getFont());
        g2d.setColor(foregroundCurrentColor);
        g2d.drawString(getText(), (MNM_margin + MNM_circleSize) + MNM_margin, (getHeight() + g2d.getFontMetrics().getAscent() - g2d.getFontMetrics().getDescent()) / 2);
    }

    @Override
    public void setBorder(Border border) {
        super.setBorder(BorderFactory.createEmptyBorder(MNM_margin, MNM_margin + MNM_circleSize, MNM_margin, MNM_margin));
    }
    
    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        if (isSelected()) {
            foregroundCurrentColor = MNM_borderActiveColor;
        } else {
            foregroundCurrentColor = fg;
        }
    }
    
    public int getMNM_arc() {
        return MNM_arc;
    }
    
    public void setMNM_arc(int MNM_arc) {
        this.MNM_arc = MNM_arc;
    }
    
    public int getMNM_margin() {
        return MNM_margin;
    }
    
    public void setMNM_margin(int MNM_margin) {
        if (MNM_margin < 10) {MNM_margin = 10;}
        this.MNM_margin = MNM_margin;
        setBorder();
    }
    
    public Color getMNM_borderActiveColor() {
        return MNM_borderActiveColor;
    }
    
    public void setMNM_borderActiveColor(Color MNM_borderActiveColor) {
        this.MNM_borderActiveColor = MNM_borderActiveColor;
        if (isSelected()) {
            borderCurrentColor = MNM_borderActiveColor;
        }
    }
    
    public Color getMNM_borderInactiveColor() {
        return MNM_borderInactiveColor;
    }

    public void setMNM_borderInactiveColor(Color MNM_borderInactiveColor) {
        this.MNM_borderInactiveColor = MNM_borderInactiveColor;
        if (!isSelected()) {
            borderCurrentColor = MNM_borderInactiveColor;
        }
    }
    
    public Color getMNM_backgroundActiveColor() {
        return MNM_backgroundActiveColor;
    }
    
    public void setMNM_backgroundActiveColor(Color MNM_backgroundActiveColor) {
        this.MNM_backgroundActiveColor = MNM_backgroundActiveColor;
        if (isSelected()) {
            backgroundCurrentColor = MNM_backgroundActiveColor;
        }
    }
    
    public Color getMNM_backgroundInactiveColor() {
        return MNM_backgroundInactiveColor;
    }
    
    public void setMNM_backgroundInactiveColor(Color MNM_backgroundInactiveColor) {
        this.MNM_backgroundInactiveColor = MNM_backgroundInactiveColor;
        if (!isSelected()) {
            backgroundCurrentColor = MNM_backgroundInactiveColor;
        }
    }

    public int getMNM_timerMilSec() {
        return MNM_timerMilSec;
    }

    public void setMNM_timerMilSec(int MNM_timerMilSec) {
        this.MNM_timerMilSec = MNM_timerMilSec;
        timerTick = MNM_timerMilSec / 10;
        timerEvent();
    }

    public int getMNM_circleSize() {
        return MNM_circleSize;
    }

    public void setMNM_circleSize(int MNM_circleSize) {
        if (MNM_circleSize < 10) {MNM_circleSize = 10;}
        this.MNM_circleSize = MNM_circleSize;
        circleInternalSize = (int) MNM_circleSize / 2;
        setBorder();
    }
    
}
