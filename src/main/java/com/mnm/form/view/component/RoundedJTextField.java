/*
 * Proyecto M&M
 */
package com.mnm.form.view.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import javax.swing.Timer;

public class RoundedJTextField extends JTextField {
    
    private int MNM_timerMilSec = 250;
    private int MNM_arc = 10;
    private int MNM_margin = 10;
    private Color MNM_borderActiveColor = new Color(64, 64, 250);
    private Color MNM_borderInactiveColor = new Color(215, 221, 230);
    
    private Timer timer;
    private double timerTick = 50;
    private Color borderCurrentColor = new Color(215, 221, 230);

    public RoundedJTextField() {
        setOpaque(true);
        super.setBackground(getParent().getBackground());
        initEvents();
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
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(getParent().getBackground());
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
    
}
