/*
 * Proyecto M&M
 */
package com.mnm.view.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RoundedJLabel extends JLabel {
    
    public static enum iconPosition {
        Top,
        Left,
        Bottom,
        Right,
        Center
    }
    
    private boolean MNM_borderShow = true;
    private Color MNM_borderActiveColor = new Color(255, 255, 255);
    private Color MNM_borderInactiveColor = new Color(255, 255, 255);
    private boolean MNM_backgroundShow = true;
    private Color MNM_backgroundActiveColor = new Color(255, 255, 255);
    private Color MNM_backgroundInactiveColor = new Color(255, 255, 255);
    private int MNM_labelArc = 10;
    private Icon MNM_icon = null;
    private int MNM_iconSize = 20;
    private int MNM_iconMargin = 10;
    private iconPosition MNM_iconPosition = iconPosition.Left;
    private ImageIcon imageIcon = null;

    public RoundedJLabel() {
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }
    
    private void verifyImageSize() {
        if (MNM_icon == null) {
            imageIcon = null;
        } else {
            imageIcon = new ImageIcon(((ImageIcon) MNM_icon).getImage().getScaledInstance(MNM_iconSize, MNM_iconSize, Image.SCALE_SMOOTH));
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (MNM_backgroundShow) {
            if (isEnabled()) {
                g2d.setColor(MNM_backgroundActiveColor);
            } else {
                g2d.setColor(MNM_backgroundInactiveColor);
            }
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), MNM_labelArc, MNM_labelArc);
        }
        if (MNM_borderShow) {
            if (isEnabled()) {
                g2d.setColor(MNM_borderActiveColor);
            } else {
                g2d.setColor(MNM_borderInactiveColor);
            }
            g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, MNM_labelArc, MNM_labelArc);
        }
        if (imageIcon != null) {
            int xIcon = 0;
            int yIcon = 0;
            if (MNM_iconPosition == iconPosition.Top) {
                xIcon = (getWidth() / 2) - (imageIcon.getIconWidth() / 2);
            } else if (MNM_iconPosition == iconPosition.Left) {
                xIcon = MNM_iconMargin;
                yIcon = (getHeight() / 2) - (imageIcon.getIconHeight() / 2);
            } else if (MNM_iconPosition == iconPosition.Bottom) {
                xIcon = (getWidth() / 2) - (imageIcon.getIconWidth() / 2);
                yIcon = getHeight() - imageIcon.getIconHeight() - MNM_iconMargin;
            } else if (MNM_iconPosition == iconPosition.Right) {
                xIcon = getWidth() - imageIcon.getIconWidth()- MNM_iconMargin;
                yIcon = (getHeight() / 2) - (imageIcon.getIconHeight() / 2);
            } else if (MNM_iconPosition == iconPosition.Center) {
                xIcon = (getWidth() / 2) - (imageIcon.getIconWidth() / 2);
                yIcon = (getHeight()/ 2) - (imageIcon.getIconHeight()/ 2);
            }
            g2d.drawImage(imageIcon.getImage(), xIcon, yIcon, null);
        }
        super.paintComponent(g);
    }
    
    @Override
    public void setIcon(Icon icon) {
        super.setIcon(null);
    }
    
    public Color getMNM_backgroundActiveColor() {
        return MNM_backgroundActiveColor;
    }
    
    public void setMNM_backgroundActiveColor(Color MNM_backgroundActiveColor) {
        this.MNM_backgroundActiveColor = MNM_backgroundActiveColor;
    }
    
    public Color getMNM_backgroundInactiveColor() {
        return MNM_backgroundInactiveColor;
    }
    
    public void setMNM_backgroundInactiveColor(Color MNM_backgroundInactiveColor) {
        this.MNM_backgroundInactiveColor = MNM_backgroundInactiveColor;
    }
    
    public int getMNM_iconSize() {
        return MNM_iconSize;
    }
    
    public void setMNM_iconSize(int MNM_iconSize) {
        this.MNM_iconSize = MNM_iconSize;
        verifyImageSize();
    }
    
    public int getMNM_labelArc() {
        return MNM_labelArc;
    }
    
    public void setMNM_labelArc(int MNM_labelArc) {
        this.MNM_labelArc = MNM_labelArc;
    }
    
    public int getMNM_iconMargin() {
        return MNM_iconMargin;
    }
    
    public void setMNM_iconMargin(int MNM_iconMargin) {
        this.MNM_iconMargin = MNM_iconMargin;
    }
    
    public iconPosition getMNM_iconPosition() {
        return MNM_iconPosition;
    }
    
    public void setMNM_iconPosition(iconPosition MNM_iconPosition) {
        this.MNM_iconPosition = MNM_iconPosition;
    }
    
    public Icon getMNM_icon() {
        return MNM_icon;
    }

    public void setMNM_icon(Icon MNM_icon) {
        this.MNM_icon = MNM_icon;
        verifyImageSize();
    }
    
    public boolean isMNM_backgroundShow() {
        return MNM_backgroundShow;
    }

    public void setMNM_backgroundShow(boolean MNM_backgroundShow) {
        this.MNM_backgroundShow = MNM_backgroundShow;
    }
    
    public boolean isMNM_borderShow() {
        return MNM_borderShow;
    }

    public void setMNM_borderShow(boolean MNM_borderShow) {
        this.MNM_borderShow = MNM_borderShow;
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
