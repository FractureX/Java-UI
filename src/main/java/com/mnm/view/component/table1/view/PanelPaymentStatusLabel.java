/*
 * Proyecto M&M
 */
package com.mnm.view.component.table1.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class PanelPaymentStatusLabel extends JLabel {
    
    public enum StatusType {
        unpaid,
        paid
    }
    
    private int MNM_margin = 10;
    private int MNM_arc = 10;
    private int MNM_circleSize = 8;
    private StatusType MNM_statusType = StatusType.unpaid;
    
    private int circleSizeHalf = (MNM_circleSize / 2);
    private Color paidBackgroundColor = new Color(215, 248, 232);
    private Color paidColor = new Color(32, 195, 117);
    private Color unpaidBackgroundColor = new Color(255, 245, 229);
    private Color unpaidColor = new Color(253, 198, 103);
    private Color currentStatusColor = unpaidColor;
    private Color currentBackgroundColor = unpaidBackgroundColor;

    public PanelPaymentStatusLabel() {
        setOpaque(false);
        setBorder();
        setText();
    }
    
    private void setBorder() {
        setBorder(BorderFactory.createEmptyBorder(0, (MNM_margin * 2) + MNM_circleSize, 0, MNM_margin));
    }
    
    private void setText() {
        if (MNM_statusType == StatusType.paid) {
            super.setText("Pago");
        } else {
            super.setText("No pago");
        }
    }
    
    private void setStatusColor() {
        if (MNM_statusType == StatusType.paid) {
            currentStatusColor = paidColor;
            currentBackgroundColor = paidBackgroundColor;
        } else {
            currentStatusColor = unpaidColor;
            currentBackgroundColor = unpaidBackgroundColor;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Background
        g2d.setColor(currentBackgroundColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), MNM_arc, MNM_arc);
        // Status
        g2d.setColor(currentStatusColor);
        g2d.fillOval(MNM_margin, (getHeight() / 2) - circleSizeHalf, MNM_circleSize, MNM_circleSize);
        super.paintComponent(g);
    }
    
    @Override
    public void setText(String text) {
        super.setText("");
        setText();
    }
    
    // Getters and setters
    public StatusType getMNM_statusType() {
        return MNM_statusType;
    }
    
    public void setMNM_statusType(StatusType MNM_statusType) {
        this.MNM_statusType = MNM_statusType;
        setStatusColor();
        setText();
    }
    
    public int getMNM_arc() {
        return MNM_arc;
    }

    public void setMNM_arc(int MNM_arc) {
        this.MNM_arc = MNM_arc;
    }
    
    public int getMNM_circleSize() {
        return MNM_circleSize;
    }

    public void setMNM_circleSize(int MNM_circleSize) {
        this.MNM_circleSize = MNM_circleSize;
        circleSizeHalf = (MNM_circleSize / 2);
    }
    
    public int getMNM_margin() {
        return MNM_margin;
    }

    public void setMNM_margin(int MNM_margin) {
        this.MNM_margin = MNM_margin;
        setBorder();
    }
    
}
