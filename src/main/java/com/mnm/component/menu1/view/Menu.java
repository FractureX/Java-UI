package com.mnm.component.menu1.view;

import com.mnm.component.menu1.model.Menu_Item;
import com.mnm.easings.EasingsFunctions;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.Interpolator;

public class Menu extends javax.swing.JPanel {
    
    // Menu items
    JList<Menu_Item> listItems;
    DefaultListModel<Menu_Item> model;
    ArrayList<Menu_Item> menuItems;
    ArrayList<Menu_Item>[] subMenuItems;
    
    //1 - Al abrir el primer menú y luego el otro, al seleccionar items del segundo menú la flecha del primero se pone normal
    //2 - No dejar que el usuario cierre el menú si un item está seleccionado
    
    private int indexCurrentItem    = -1;   // Para el item que se selecciona
    private int indexCurrentNested  = -1;   // Para el item nested que se selecciona
    private int indexSelectedNested = -1;   // Para el item nested que se selecciona al momento
    private int hoverIndex = -1;
    Color whiteTransparent = new Color(255, 255, 255, 75);
    Color bgColor1 = Color.decode("#1CB5E0");
    Color bgColor2 = Color.decode("#000046");
    Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    
    Animator animatorClick;
    Animator animatorNested;
    Animator animatorHover;
    private float animateClick = 0f;
    private float animateHover = 0f;
    private ArrayList<Float> animateNested;
    private ArrayList<Boolean> indexBooleanNestedItems = new ArrayList();
    private ArrayList<Integer> indexNestedItems = new ArrayList();
    private ImageIcon imgArrow;

    public Menu() {
        initComponents();
        setOpaque(false);
        init();
    }
    
    private void menuItemClick() {
        animateClick = 0f;
        animatorClick.start();
        System.out.println("");
    }
    
    private void menuItemHover() {
        animateHover = 0f;
        if (animatorHover.isRunning()) {
            animatorHover.stop();
        }
        animatorHover.start();
    }
    
    private void menuItemNested() {
        if (animatorNested.isRunning()) {
            animatorNested.stop();
        }
        animatorNested.start();
    }
    
    private void initTimers() {
        TimingTarget targetClick = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                animateClick = fraction;
                repaint();
            }
        };
        TimingTarget targetHover = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                animateHover = fraction;
                repaint();
            }
        };
        TimingTarget targetNested = new TimingTargetAdapter(){
            @Override
            public void begin() {
                // Obtener valores
                int currentSubMenuIndex = calculateSubMenuIndex(indexSelectedNested);
                Boolean newValue = !indexBooleanNestedItems.get(indexNestedItems.indexOf(indexSelectedNested));
                int newValueIndex = indexNestedItems.indexOf(indexSelectedNested);
                // Setear nuevo valor
                indexBooleanNestedItems.set(newValueIndex, newValue);
                // Updatear el index actual
                if (newValue) {
                    if (indexCurrentItem > indexSelectedNested) {
                        indexCurrentItem += subMenuItems [currentSubMenuIndex].size();
                        indexCurrentNested += subMenuItems [currentSubMenuIndex].size();
                    }
                } else {
                    if (indexCurrentItem > indexSelectedNested) {
                        indexCurrentItem -= subMenuItems [currentSubMenuIndex].size();
                        indexCurrentNested -= subMenuItems [currentSubMenuIndex].size();
                    }
                }
                for (int i = 0; i < subMenuItems [currentSubMenuIndex].size(); i++) {
                    // + 1 Porque el item se encuentra un espacio después del actual
                    if (newValue) {
                        model.add(indexSelectedNested + i + 1, subMenuItems [currentSubMenuIndex].get(i));
                        menuItems.add(indexSelectedNested + i + 1, subMenuItems [currentSubMenuIndex].get(i));
                    } else {
                        model.remove(indexSelectedNested + 1);
                        menuItems.remove(indexSelectedNested + 1);
                    }
                }
                updateListIndex();
            }
            
            @Override
            public void timingEvent(float fraction) {
                animateNested.set(indexNestedItems.indexOf(indexSelectedNested), fraction);
                repaint();
            }

            @Override
            public void end() {
                indexSelectedNested = -1;
            }
            
        };
        animatorClick = new Animator(150, targetClick);
        animatorClick.setInterpolator(new Interpolator() {
            @Override
            public float interpolate(float f) {
                return EasingsFunctions.easeOutSine(f);
            }
        });
        
        animatorHover = new Animator(300, targetHover);
        animatorHover.setInterpolator(new Interpolator() {
            @Override
            public float interpolate(float f) {
                return EasingsFunctions.easeOutSine(f);
            }
        });
        
        animatorNested = new Animator(300, targetNested);
        animatorNested.setInterpolator(new Interpolator() {
            @Override
            public float interpolate(float f) {
                return EasingsFunctions.easeOutSine(f);
            }
        });
        
        animateNested = new ArrayList();
        for (int i = 0; i < subMenuItems.length; i++) {
            animateNested.add(1f);
        }
    }

    private void init() {
        // Arrow img
        imgArrow = new ImageIcon(new ImageIcon(getClass().getResource("/images/sm/arrowLeft.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
        // Init items
        initItems();
        // Timers
        initTimers();
        jScrollPane1.getViewport().setView(listItems = createListItems());
        jScrollPane1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                repaint();
            }
        });
    }
    
    private void initItems() {
        // Init items
        menuItems = new ArrayList();
        menuItems.add(new Menu_Item(0, "1", "Item #1", Menu_Item.MenuType.MENUITEM));
        menuItems.add(new Menu_Item(0, "2", "Item #2", Menu_Item.MenuType.MENUITEMNEST));
        menuItems.add(new Menu_Item(0, "", "", Menu_Item.MenuType.EMPTY));
        menuItems.add(new Menu_Item(0, "6", "Item #3", Menu_Item.MenuType.MENUITEM));
        menuItems.add(new Menu_Item(0, "7", "Item #4", Menu_Item.MenuType.MENUITEM));
        menuItems.add(new Menu_Item(0, "8", "Item #5", Menu_Item.MenuType.MENUITEM));
        menuItems.add(new Menu_Item(0, "9", "Item #6", Menu_Item.MenuType.MENUITEM));
        menuItems.add(new Menu_Item(0, "10", "Item #7", Menu_Item.MenuType.MENUITEM));
        menuItems.add(new Menu_Item(0, "", "", Menu_Item.MenuType.EMPTY));
        menuItems.add(new Menu_Item(0, "11", "Item #8", Menu_Item.MenuType.MENUITEMNEST));
        menuItems.add(new Menu_Item(0, "", "", Menu_Item.MenuType.EMPTY));
        menuItems.add(new Menu_Item(0, "14", "Item #9", Menu_Item.MenuType.MENUITEM));
        //menuItems.add(new Menu_Item(0, "", "", Menu_Item.MenuType.EMPTY));
        int nSubMenuItems = 0;
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getItemType() == Menu_Item.MenuType.MENUITEMNEST) {
                nSubMenuItems++;
            }
        }
        subMenuItems = new ArrayList [nSubMenuItems];
        // Init submenu items
        subMenuItems [0] = new ArrayList();
        subMenuItems [1] = new ArrayList();
        subMenuItems [0].add(new Menu_Item(0, "3", "Nested item #1", Menu_Item.MenuType.MENUITEMNEST_NESTED));
        subMenuItems [0].add(new Menu_Item(0, "4", "Nested item #2", Menu_Item.MenuType.MENUITEMNEST_NESTED));
        subMenuItems [0].add(new Menu_Item(0, "5", "Nested item #3", Menu_Item.MenuType.MENUITEMNEST_NESTED));
        subMenuItems [0].add(new Menu_Item(0, "3", "Nested item #4", Menu_Item.MenuType.MENUITEMNEST_NESTED));
        subMenuItems [0].add(new Menu_Item(0, "4", "Nested item #5", Menu_Item.MenuType.MENUITEMNEST_NESTED));
        subMenuItems [0].add(new Menu_Item(0, "5", "Nested item #6", Menu_Item.MenuType.MENUITEMNEST_NESTED));
        subMenuItems [1].add(new Menu_Item(0, "12", "Nested item #7", Menu_Item.MenuType.MENUITEMNEST_NESTED));
        subMenuItems [1].add(new Menu_Item(0, "13", "Nested item #8", Menu_Item.MenuType.MENUITEMNEST_NESTED));
        subMenuItems [1].add(new Menu_Item(0, "12", "Nested item #9", Menu_Item.MenuType.MENUITEMNEST_NESTED));
        subMenuItems [1].add(new Menu_Item(0, "13", "Nested item #10", Menu_Item.MenuType.MENUITEMNEST_NESTED));
        subMenuItems [1].add(new Menu_Item(0, "12", "Nested item #11", Menu_Item.MenuType.MENUITEMNEST_NESTED));
        subMenuItems [1].add(new Menu_Item(0, "13", "Nested item #12", Menu_Item.MenuType.MENUITEMNEST_NESTED));
        // Create model
        model = new DefaultListModel<>();
        // Add item to model
        for (int i = 0; i < menuItems.size(); i++) {
            model.addElement(menuItems.get(i));
            if (menuItems.get(i).getItemType() == Menu_Item.MenuType.MENUITEMNEST) {
                indexBooleanNestedItems.add(Boolean.FALSE);
                indexNestedItems.add(i);
            }
        }
        updateListIndex();
    }
    
    private void updateListIndex() {
        indexNestedItems = new ArrayList<Integer>();
        for (int i = 0; i < model.size(); i++) {
            model.get(i).setItemIndex(i);
            menuItems.get(i).setItemIndex(i);
            if (menuItems.get(i).getItemType() == Menu_Item.MenuType.MENUITEMNEST) {
                indexNestedItems.add(i); // Actualizo el index de los nested items
            }
        }
    }

    private JList<Menu_Item> createListItems() {
        // Create JList with model
        JList<Menu_Item> list = new JList<Menu_Item>(model) {
            @Override
            protected void paintComponent(Graphics g) {
                { // Background
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    GradientPaint gp = new GradientPaint(0, 0, bgColor1, 0, getHeight(), bgColor2);
                    g2d.setPaint(gp);
                    g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
                    g2d.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
                }
                { // Diseño de selección 1
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setColor(whiteTransparent);
                    if (indexCurrentItem != -1) {
                        g2d.fillRect(0, (indexCurrentItem * 35), (int) (animateClick * getWidth()), 35);
                        g2d.fillRect(0, (indexCurrentItem * 35), (int) (animateClick * 5), 35);
                    }
                }
                { // Diseño de hover
                    if (hoverIndex != -1 && hoverIndex != indexCurrentItem) {
                        Graphics2D g2d = (Graphics2D) g;
                        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        g2d.setColor(whiteTransparent);
                        g2d.fillRect(0, (hoverIndex * 35), (int) (animateHover * 5), 35);
                    }
                }
                { // Diseño del arrow
                    for (int i = 0; i < indexBooleanNestedItems.size(); i++) {
                        int nActiveItems = 0;
                        int nActiveNestedItems = 0;
                        for (int j = 0; j < menuItems.size(); j++) {
                            nActiveItems++;
                            if (menuItems.get(j).getItemType() == Menu_Item.MenuType.MENUITEMNEST) {
                                if (nActiveNestedItems != indexNestedItems.indexOf(indexNestedItems.get(i))) {
                                    nActiveNestedItems++;
                                } else {
                                    break;
                                }
                            }
                        }
                        int x = getWidth() - imgArrow.getIconWidth() - 10;
                        int y = ((nActiveItems * 35) - (35 / 2)) - (imgArrow.getIconHeight() / 2);
                        Graphics2D g2d = (Graphics2D) g.create();
                        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        if (!indexBooleanNestedItems.get(i)) {
                            g2d.rotate(Math.toRadians(90 - (90 * animateNested.get(i))), x + (imgArrow.getIconWidth() / 2), y + (imgArrow.getIconHeight() / 2));
                        } else {
                            g2d.rotate(Math.toRadians((90 * animateNested.get(i))), x + (imgArrow.getIconWidth() / 2), y + (imgArrow.getIconHeight() / 2));
                        }
                        g2d.drawImage(imgArrow.getImage(), x, y, this);
                    }
                }
                super.paintComponent(g);
            }
        };
        list.setOpaque(true);
        list.setBackground(new Color(0, 0, 0, 0));
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int index = list.locationToIndex(e.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof Menu_Item) {
                        Menu_Item item = (Menu_Item) o;
                        if (item.getItemType() == Menu_Item.MenuType.MENUITEM) {
                            // Menu_Item normal
                            if (indexCurrentItem != index) {
                                if (!animatorClick.isRunning()) {
                                    indexCurrentItem = index;
                                    indexCurrentNested = -1;
                                    menuItemClick();
                                    JOptionPane.showMessageDialog(null, "Clickedo un item MENUITEM\nindexCurrentItem: " + indexCurrentItem + "\nindexCurrentNested: " + indexCurrentNested);
                                    //repaint();
                                }
                            }
                                
                        } else if (item.getItemType() == Menu_Item.MenuType.MENUITEMNEST) {
                            // Menu_Item que contiene un submenu
                            if (!animatorNested.isRunning()) {
                                System.out.println(index + " != " + indexCurrentNested);
                                if (index != indexCurrentNested) {
                                    indexSelectedNested = index;
                                    menuItemNested();
                                    JOptionPane.showMessageDialog(null, "Clickedo un item MENUITEMNEST\nindexCurrentItem: " + indexCurrentItem + "\nindexCurrentNested: " + indexCurrentNested);
                                    //repaint();
                                }
                            }
                        } else if (item.getItemType() == Menu_Item.MenuType.MENUITEMNEST_NESTED) {
                            // Menu_Item que está adentro de un submenu
                            if (!animatorNested.isRunning()) {
                                if (indexCurrentItem != index) {
                                    indexCurrentItem = index;
                                    indexCurrentNested = calculateCurrentNestedIndex(index);
                                    JOptionPane.showMessageDialog(null, "Clickedo un item MENUITEMNEST_NESTED\nindexCurrentItem: " + indexCurrentItem + "\nindexCurrentNested: " + indexCurrentNested);
                                    menuItemClick();
                                    //repaint();
                                }
                            }
                        }
                    }
                            
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hoverIndex = -1;
                repaint();
            }
        });
        list.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int index = list.locationToIndex(e.getPoint());
                Menu_Item item = (Menu_Item) model.getElementAt(index);
                System.out.println(hoverIndex + " != " + index);
                if (hoverIndex != index) { // Para que no se repita
                    hoverIndex = -1;
                    if (item.getItemType() == Menu_Item.MenuType.MENUITEM || item.getItemType() == Menu_Item.MenuType.MENUITEMNEST || item.getItemType() == Menu_Item.MenuType.MENUITEMNEST_NESTED) {
                        hoverIndex = index;
                        list.setCursor(handCursor);
                    } else {
                        animateHover = 0f;
                        list.setCursor(defaultCursor);
                    }
                    menuItemHover();
                } /*else {
                    if (item.getItemType() == Menu_Item.MenuType.EMPTY) {
                        hoverIndex = -1;
                        list.setCursor(defaultCursor);
                        menuItemHover();
                    }
                }*/
            }
        });
        // Set cell renderer
        list.setCellRenderer(new Menu_ItemRenderer());
        return list;
    }
    
    private int calculateCurrentNestedIndex(int currentItemIndex) {
        // Calcula el valor del índice del item nested con respecto al total de items en el menú
        int returnValue = -1;
        for (int i = 0; i <= currentItemIndex; i++) {
            if (model.get(i).getItemType() == Menu_Item.MenuType.MENUITEMNEST) {
                returnValue = i;
            }
        }
        return returnValue;
    }
    
    private int calculateSubMenuIndex(int currentItemIndex) {
        // Calcula el valor del índice del item submenu 
        int returnValue = -1;
        for (int i = 0; i <= currentItemIndex; i++) {
            if (model.get(i).getItemType() == Menu_Item.MenuType.MENUITEMNEST) {
                returnValue++;
            }
        }
        return returnValue;
    }
    
    private int calculateItemSubMenuIndex(int currentItemIndex) {
        // Calcula el valor del índice del item adentro del submenu
        int returnValue = -1;
        for (int i = 0; i <= currentItemIndex; i++) {
            if (model.get(i).getItemType() == Menu_Item.MenuType.MENUITEMNEST) {
                for (int j = i; j <= currentItemIndex; j++) {
                    if (model.get(i).getItemType() == Menu_Item.MenuType.MENUITEMNEST_NESTED) {
                        if (j == currentItemIndex) {
                            return j;
                        }
                    }
                }
            }
        }
        return returnValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        panelMoving.setBackground(Color.decode("#1CB5E0"));
        panelMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sm/logo.png"))); // NOI18N
        jLabel1.setText("Aplicación");
        jLabel1.setIconTextGap(8);

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new Color(0, 0, 0, 0));
        jScrollPane1.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    protected void paintComponent(Graphics g) {
        { // Background
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Color bgFirst = bgColor1;
            Color bgSecond = bgColor2;
            ArrayList<Integer> newBg = new ArrayList();
            if (jScrollPane1.getVerticalScrollBar().getValue() == 0) {
                newBg.add(bgFirst.getRed());
                newBg.add(bgFirst.getGreen());
                newBg.add(bgFirst.getBlue());
            } else {
                int height = jScrollPane1.getViewport().getView().getHeight();
                int rate = jScrollPane1.getVerticalScrollBar().getValue();
                int intBgFirst [] = {bgFirst.getRed(), bgFirst.getGreen(), bgFirst.getBlue()};
                int intBgSecond [] = {bgSecond.getRed(), bgSecond.getGreen(), bgSecond.getBlue()};
                for (int i = 0; i < 3; i++) {
                    if (intBgFirst [i] >= intBgSecond [i]) {
                        newBg.add(intBgFirst [i] - (((intBgFirst [i] - intBgSecond [i]) * rate) / height));
                    } else {
                        newBg.add(intBgFirst [i] + (((intBgSecond [i] - intBgFirst [i]) * rate) / height));
                    }
                }
            }
            g2d.setColor(new Color(newBg.get(0), newBg.get(1), newBg.get(2)));
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(g);
    }
    
    private int x;
    private int y;

    public void initMoving(JFrame frame) {
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                frame.setOpacity(1f);
            }
        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setOpacity(0.5f);
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
