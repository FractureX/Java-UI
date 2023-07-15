/*
 * Proyecto M&M
 */
package com.mnm.form.view.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
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
    private int MNM_timerMilSec = 250;
    private int MNM_arc = 10;
    private int MNM_margin = 10;
    private Color MNM_borderActiveColor = new Color(64, 64, 250);
    private Color MNM_borderInactiveColor = new Color(215, 221, 230);
    
    private Timer timer;
    private double timerTick = 25;
    private Color borderCurrentColor = new Color(215, 221, 230);
    private ImageIcon icon;

    public RoundedJTextField() {
        setOpaque(false);
        initEvents();
        setBorder();
    }
    
    private void initEvents() {
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isEnabled() && isEditable()) {
                    
                }
            }
        });
    }
    
    private void setBorder() {
        setBorder(BorderFactory.createEmptyBorder(MNM_margin, MNM_iconBoxSize + MNM_margin, MNM_margin, MNM_margin));
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
            g2d.drawImage(icon.getImage(), (MNM_iconBoxSize / 2) - (MNM_iconSize / 2), (getHeight() / 2) - (MNM_iconSize / 2), null);
        }
    }
    
    @Override
    public void setBorder(Border border) {
        super.setBorder(BorderFactory.createEmptyBorder(MNM_margin, MNM_iconBoxSize + MNM_margin, MNM_margin, MNM_margin));
    }
    
    public int getMNM_timerMilSec() {
        return MNM_timerMilSec;
    }
    
    public void setMNM_timerMilSec(int MNM_timerMilSec) {
        this.MNM_timerMilSec = MNM_timerMilSec;
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
    }

    public Icon getMNM_icon() {
        return MNM_icon;
    }

    public void setMNM_icon(Icon MNM_icon) {
        this.MNM_icon = MNM_icon;
        setNewIcon();
    }

    public int getMNM_iconBoxSize() {
        return MNM_iconBoxSize;
    }

    public void setMNM_iconBoxSize(int MNM_iconBoxSize) {
        this.MNM_iconBoxSize = MNM_iconBoxSize;
    }

    public int getMNM_iconSize() {
        return MNM_iconSize;
    }

    public void setMNM_iconSize(int MNM_iconSize) {
        this.MNM_iconSize = MNM_iconSize;
        setNewIcon();
    }
    
}
