/*
 * Proyecto M&M
 */
package com.mnm.view.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RoundedJLabel extends JLabel {
    
    private int MNM_arc = 10;
    private Icon MNM_icon = null;
    private Color MNM_backgroundColor = new Color(255, 255, 255);
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(MNM_backgroundColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), MNM_arc, MNM_arc);
        if (MNM_icon != null) {
            BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2_img = img.createGraphics();
            g2_img.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2_img.fillRoundRect(0, 0, getWidth(), getHeight(), MNM_arc, MNM_arc);
            Composite composite = g2_img.getComposite();
            g2_img.setComposite(AlphaComposite.SrcIn);
            g2_img.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2_img.drawImage(new ImageIcon(((ImageIcon) MNM_icon).getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH)).getImage(), 0, 0, getWidth(), getHeight(), null);
            g2_img.setComposite(composite);
            g2_img.dispose();
            g2d.drawImage(img, 0, 0, null);
        }
    }
    
    @Override
    public void setIcon(Icon icon) {
        super.setIcon(null);
    }
    
    public int getMNM_arc() {
        return MNM_arc;
    }
    
    public void setMNM_arc(int MNM_arc) {
        this.MNM_arc = MNM_arc;
    }
    
    public Icon getMNM_icon() {
        return MNM_icon;
    }
    
    public void setMNM_icon(Icon MNM_icon) {
        this.MNM_icon = MNM_icon;
    }

    public Color getMNM_backgroundColor() {
        return MNM_backgroundColor;
    }

    public void setMNM_backgroundColor(Color MNM_backgroundColor) {
        this.MNM_backgroundColor = MNM_backgroundColor;
    }
    
}
