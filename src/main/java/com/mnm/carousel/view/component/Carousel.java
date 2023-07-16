/*
 * Proyecto M&M
 */
package com.mnm.carousel.view.component;

import com.mnm.view.component.RoundedJPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

public final class Carousel extends RoundedJPanel {
    
    private int MNM_widthPerPanel = 300;
    private int MNM_dotSeparation = 10;
    private int MNM_dotSize = 10;
    
    private List<RoundedJPanel> panels = new ArrayList<>();
    private int currentIndex = 0;
    private int totalPanels = 0;
    // Drag event
    boolean isDragging = false;
    int dragInitialPointX;
    int dragCurrentPointX;

    public Carousel() {
        initComponents();
        setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        addRoundedJPanel(new CarouselPanel1());
        addRoundedJPanel(new CarouselPanel2());
        addRoundedJPanel(new CarouselPanel3());
        addRoundedJPanel(new CarouselPanel4());
        addEvents();
    }
    
    private void addEvents() {
        MouseAdapter mouseListenerEvent = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                    int xLocationPerPanel = 0;
                    if (currentIndex > 0) {
                        xLocationPerPanel = -(currentIndex * MNM_widthPerPanel);
                    }
                    for (int i = 0; i < totalPanels; i++) {
                        if (i != currentIndex) {
                            add(panels.get(i), new AbsoluteConstraints(xLocationPerPanel, 0, getWidth(), getHeight()), i);
                            getTopLevelAncestor().revalidate();
                            getTopLevelAncestor().repaint();
                        }
                        xLocationPerPanel += MNM_widthPerPanel;
                    }
                    isDragging = true;
                    dragInitialPointX = e.getLocationOnScreen().x;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    RoundedJPanel currentPanel = panels.get(currentIndex);
                    currentIndex -= (currentPanel.getLocation().x / getWidth());
                    if (currentIndex < 0) {currentIndex = 0;}
                    if (currentIndex >= totalPanels) {currentIndex = totalPanels - 1;}
                    int removedPanelsCount = 0;
                    for (int i = 0; i < totalPanels; i++) {
                        if (i != currentIndex) {
                            remove(i - removedPanelsCount);
                            removedPanelsCount++;
                        }
                    }
                    panels.get(currentIndex).setLocation(0, 0);
                    setLayout(new javax.swing.BoxLayout(Carousel.this, javax.swing.BoxLayout.LINE_AXIS));
                    getTopLevelAncestor().revalidate();
                    getTopLevelAncestor().repaint();
                    isDragging = false;
                }
            }
        };
        MouseMotionAdapter mouseMotionListener = new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int xLocationPerPanel = 0;
                    int x = 0;
                    dragCurrentPointX = e.getXOnScreen();
                    if (currentIndex > 0) {
                        xLocationPerPanel = -(currentIndex * MNM_widthPerPanel);
                    }
                    for (int i = 0; i < totalPanels; i++) {
                        RoundedJPanel currentPanel = panels.get(i);
                        if (i == currentIndex) {
                            x = dragCurrentPointX - dragInitialPointX;
                        } else {
                            x = xLocationPerPanel + (dragCurrentPointX - dragInitialPointX);
                        }
                        if ((i == 0 && currentIndex == i) || (i == 0)) {
                            // Es el primer elemento y es el actual
                            if (x > 0) {
                                x = 0;
                                currentPanel.setLocation(x, 0);
                            } else if (x < 0){
                                currentPanel.setLocation(x, 0);
                            }
                        } else if ((i == (totalPanels - 1) && currentIndex == i) || (i == (totalPanels - 1))) {
                            // Es el último elemento y es el actual
                            if (x < 0) {
                                x = 0;
                                currentPanel.setLocation(x, 0);
                            } else if (x > 0){
                                currentPanel.setLocation(x, 0);
                            }
                        } else {
                            currentPanel.setLocation(x, 0);
                        }
                        xLocationPerPanel += MNM_widthPerPanel;
                    }
                    getTopLevelAncestor().repaint();
                }
            }
        };
        MouseWheelListener mouseWheelListener = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (!isDragging) {
                    boolean cambiarPanel = false;
                    if (e.getWheelRotation() < 0) {
                        // Arriba <- Izquierda
                        if (currentIndex > 0) {
                            currentIndex--;
                            cambiarPanel = true;
                        }
                    } else {
                        // Abajo -> Derecha
                        if (currentIndex < (totalPanels - 1)) {
                            currentIndex++;
                            cambiarPanel = true;
                        }
                    }
                    if (cambiarPanel) {
                        removeAll();
                        add(panels.get(currentIndex));
                        getTopLevelAncestor().revalidate();
                        getTopLevelAncestor().repaint();
                    }
                }
            }
        };
        addMouseListener(mouseListenerEvent);
        addMouseMotionListener(mouseMotionListener);
        addMouseWheelListener(mouseWheelListener);
        for (Component comp : panels) {
            addEventsInside(((JPanel) comp).getComponents(), mouseListenerEvent, mouseMotionListener, mouseWheelListener);
        }
    }
    
    private void addEventsInside(Component comps[], MouseAdapter mouseListenerEvent, MouseMotionAdapter mouseMotionListener, MouseWheelListener mouseWheelListener) {
        for (Component comp : comps) {
            if (comp.getClass().getSuperclass() == RoundedJPanel.class || comp.getClass().getSuperclass() == JPanel.class) {
                addEventsInside(((JPanel) comp).getComponents(), mouseListenerEvent, mouseMotionListener, mouseWheelListener);
            } else if (comp.getClass() == JScrollPane.class) {
                Component view = ((JScrollPane) comp).getViewport().getView();
                view.addMouseListener(mouseListenerEvent);
                view.addMouseMotionListener(mouseMotionListener);
                view.addMouseWheelListener(mouseWheelListener);
            }
        }
    }
    
    public void addRoundedJPanel(RoundedJPanel panel) {
        panels.add(panel);
        totalPanels = panels.size();
        if (totalPanels == 1) {
            removeAll();
            add(panel);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (totalPanels > 1) {
            for (int i = 0; i < totalPanels; i++) {
                if (i == currentIndex) {
                    g2d.setColor(Color.white);
                } else {
                    g2d.setColor(Color.white.darker());
                }
                int centro = (getWidth() / 2);
                int totalWidth = (MNM_dotSize * totalPanels) + (MNM_dotSeparation * (totalPanels - 1));
                int x = (centro - (totalWidth / 2)) + ((i * (MNM_dotSize)) + (i * (MNM_dotSeparation)));
                g2d.fillRoundRect(x, getHeight() - 50, MNM_dotSize, 5, 5, 5);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMNM_shadowPixelsApply(false);
        setMaximumSize(new java.awt.Dimension(300, 500));
        setMinimumSize(new java.awt.Dimension(300, 500));
        setPreferredSize(new java.awt.Dimension(300, 500));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
    }// </editor-fold>//GEN-END:initComponents

    public int getMNM_widthPerPanel() {
        return MNM_widthPerPanel;
    }

    public void setMNM_widthPerPanel(int MNM_widthPerPanel) {
        this.MNM_widthPerPanel = MNM_widthPerPanel;
    }

    public int getMNM_dotSeparation() {
        return MNM_dotSeparation;
    }

    public void setMNM_dotSeparation(int MNM_dotSeparation) {
        this.MNM_dotSeparation = MNM_dotSeparation;
    }

    public int getMNM_dotSize() {
        return MNM_dotSize;
    }

    public void setMNM_dotSize(int MNM_dotSize) {
        this.MNM_dotSize = MNM_dotSize;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
