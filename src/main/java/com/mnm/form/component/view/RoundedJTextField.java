/*
 * Proyecto M&M
 */
package com.mnm.form.component.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;

public class RoundedJTextField extends JTextField {
    
    private Icon MNM_icon = null;
    private int MNM_iconBoxSize = 30;
    private int MNM_iconSize = 20;
    private int MNM_timerFocusMilSec = 250;
    private int MNM_arc = 10;
    private int MNM_margin = 10;
    private Color MNM_borderActiveColor = new Color(64, 64, 250);
    private Color MNM_borderInactiveColor = new Color(215, 221, 230);
    private String MNM_placeholder = "Placeholder";
    private Color MNM_placeholderForeground = new Color(215, 221, 230);
    private Color MNM_foreground = new Color(51, 51, 51);
    
    private Timer timerFocus;
    private Color borderCurrentColor = new Color(215, 221, 230);
    private Color foregroundCurrentColor = getForeground();
    private ImageIcon icon;

    public RoundedJTextField() {
        setOpaque(false);
        initEvents();
        setBorder();
    }
    
    private void setBorder() {
        setBorder(BorderFactory.createEmptyBorder(MNM_margin, MNM_iconBoxSize, MNM_margin, MNM_margin));
    }
    
    private void initEvents() {
        focusEvent();
        timerEvent();
    }
    
    private void focusEvent() {
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isEnabled() && isEditable()) {
                    if (timerFocus.isRunning()) {
                        timerFocus.stop();
                    }
                    timerFocus.start();
                    if (getForeground() == MNM_placeholderForeground) {
                        setText("");
                        setForeground(MNM_foreground);
                    }
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (isEnabled() && isEditable()) {
                    if (timerFocus.isRunning()) {
                        timerFocus.stop();
                    }
                    timerFocus.start();
                    if (getText().isEmpty()) {
                        setText(MNM_placeholder);
                        setForeground(MNM_placeholderForeground);
                    }
                }
            }
        });
    }
    
    private void timerEvent() {
        timerFocus = new Timer((int) (MNM_timerFocusMilSec / 10), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hasFocus()) {
                    borderCurrentColor = extractColor(borderCurrentColor, MNM_borderActiveColor, MNM_timerFocusMilSec, false);
                    if (borderCurrentColor.getRed() <= MNM_borderActiveColor.getRed()) {
                        borderCurrentColor = MNM_borderActiveColor;
                        repaint();
                        timerFocus.stop();
                        return;
                    }
                } else {
                    borderCurrentColor = extractColor(borderCurrentColor, MNM_borderInactiveColor, MNM_timerFocusMilSec, true);
                    if (borderCurrentColor.getRed() >= MNM_borderInactiveColor.getRed()) {
                        borderCurrentColor = MNM_borderInactiveColor;
                        repaint();
                        timerFocus.stop();
                        return;
                    }
                }
                repaint();
            }
        });
    }
    
    private Color extractColor(Color fromColor, Color toColor, int timerMilSec, boolean increase) {
        double timerTick = timerMilSec / 10;
        if (!increase) {
            double rBorder = fromColor.getRed() - Math.ceil(((fromColor.getRed() - toColor.getRed()) * (timerTick / (double) timerMilSec)));
            double gBorder = fromColor.getGreen() - Math.ceil(((fromColor.getGreen() - toColor.getGreen()) * (timerTick / (double) timerMilSec)));
            double bBorder = fromColor.getBlue() - Math.ceil(((fromColor.getBlue() - toColor.getBlue()) * (timerTick / (double) timerMilSec)));
            return new Color((int) rBorder, (int) gBorder, (int) bBorder);
        } else {
            double rBorder = fromColor.getRed() + Math.ceil(((toColor.getRed() - fromColor.getRed()) * (timerTick / (double) timerMilSec)));
            double gBorder = fromColor.getGreen() + Math.ceil(((toColor.getGreen() - fromColor.getGreen()) * (timerTick / (double) timerMilSec)));
            double bBorder = fromColor.getBlue() + Math.ceil(((toColor.getBlue() - fromColor.getBlue()) * (timerTick / (double) timerMilSec)));
            return new Color((int) rBorder, (int) gBorder, (int) bBorder);
        }
    }
    
    private void setNewIcon() {
        if (MNM_icon != null) {
            icon = new ImageIcon(((ImageIcon) MNM_icon).getImage().getScaledInstance(MNM_iconSize, MNM_iconSize, Image.SCALE_SMOOTH));
        } else {
            icon = null;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Background
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), MNM_arc, MNM_arc);        
        // Border
        g2d.setColor(borderCurrentColor);
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, MNM_arc, MNM_arc);
        // Icono
        if (icon != null) {
            //g2d.fillRoundRect(0, 0, MNM_iconBoxSize, getHeight(), MNM_arc, MNM_arc);
            g2d.drawImage(icon.getImage(), (MNM_iconBoxSize / 2) - (MNM_iconSize / 2), (getHeight() / 2) - (MNM_iconSize / 2), null);
        }
        super.paintComponent(g);
    }

    @Override
    public void setForeground(Color fg) {
        
        super.setForeground(fg);
    }
    
    @Override
    public void setCaretColor(Color c) {
        super.setCaretColor(new Color(0, 0, 0));
    }
    
    @Override
    public void setBorder(Border border) {
        if (icon != null) {
            super.setBorder(BorderFactory.createEmptyBorder(MNM_margin, MNM_iconBoxSize, MNM_margin, MNM_margin));
        } else {
            super.setBorder(BorderFactory.createEmptyBorder(MNM_margin, MNM_margin, MNM_margin, MNM_margin));
        }
    }
    
    public int getMNM_timerFocusMilSec() {
        return MNM_timerFocusMilSec;
    }
    
    public void setMNM_timerFocusMilSec(int MNM_timerFocusMilSec) {
        this.MNM_timerFocusMilSec = MNM_timerFocusMilSec;
        timerEvent();
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
        this.MNM_margin = MNM_margin;
        setBorder();
    }
    
    public Color getMNM_borderActiveColor() {
        return MNM_borderActiveColor;
    }
    
    public void setMNM_borderActiveColor(Color MNM_borderActiveColor) {
        this.MNM_borderActiveColor = MNM_borderActiveColor;
    }
    
    public Color getMNM_borderInactiveColor() {
        return MNM_borderInactiveColor;
    }
    
    public void setMNM_borderInactiveColor(Color MNM_borderInactiveColor) {
        this.MNM_borderInactiveColor = MNM_borderInactiveColor;
        borderCurrentColor = MNM_borderInactiveColor;
    }

    public Icon getMNM_icon() {
        return MNM_icon;
    }

    public void setMNM_icon(Icon MNM_icon) {
        this.MNM_icon = MNM_icon;
        setNewIcon();
        setBorder();
    }

    public int getMNM_iconBoxSize() {
        return MNM_iconBoxSize;
    }

    public void setMNM_iconBoxSize(int MNM_iconBoxSize) {
        this.MNM_iconBoxSize = MNM_iconBoxSize;
        setBorder();
    }

    public int getMNM_iconSize() {
        return MNM_iconSize;
    }

    public void setMNM_iconSize(int MNM_iconSize) {
        this.MNM_iconSize = MNM_iconSize;
        setNewIcon();
        setBorder();
    }

    public String getMNM_placeholder() {
        return MNM_placeholder;
    }

    public void setMNM_placeholder(String MNM_placeholder) {
        this.MNM_placeholder = MNM_placeholder;
    }

    public Color getMNM_placeholderForeground() {
        return MNM_placeholderForeground;
    }

    public void setMNM_placeholderForeground(Color MNM_placeholderForeground) {
        this.MNM_placeholderForeground = MNM_placeholderForeground;
    }

    public Color getMNM_foreground() {
        return MNM_foreground;
    }

    public void setMNM_foreground(Color MNM_foreground) {
        this.MNM_foreground = MNM_foreground;
    }
    
}
