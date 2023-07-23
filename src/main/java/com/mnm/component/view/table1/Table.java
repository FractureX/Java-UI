/*
 * Proyecto M&M
 */
package com.mnm.component.view.table1;

import com.mnm.component.table1.view.PanelJCheckBox;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.AbstractCellEditor;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class Table extends JTable {
    
    private JPanel[] tableHeaderPanel;
    private Class[] clases;
    private Color borderColor = new Color(215, 221, 230);
    
    // Constructor
    public Table() {
        init();
    }
    
    private void init() {
        getTableHeader().setDefaultRenderer(new CustomTableHeaderCellRenderer());
        initEvents();
    }
    
    private void initEvents() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed");
            }
            
            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println("mouseMoved");
                if (getModel().isCellEditable(rowAtPoint(e.getPoint()), columnAtPoint(e.getPoint()))) {
                    editCellAt(rowAtPoint(e.getPoint()), columnAtPoint(e.getPoint()));
                }
            }
        });
    }
    
    // Header
    private class CustomTableHeaderCellRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return tableHeaderPanel[column];
        }
    }
    
    // Body renderer
    private class CustomTableBodyCellRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = null;
            if (value.getClass() == Boolean.class) {
                // Crear el container
                comp = new PanelJCheckBox((boolean) value);
            } else {
                comp = (Component) value;
            }
            return comp;
        }
    }
    
    // Body editor
    private class CustomTableBodyCellEditor extends AbstractCellEditor implements TableCellEditor {
        
        Component comp;
        
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value.getClass() == Boolean.class) {
                // Crear el container
                comp = new PanelJCheckBox((boolean) value);
            } else {
                comp = (Component) value;
            }
            return comp;
        }
        
        @Override
        public Object getCellEditorValue() {
            return comp;
        }
        
    }
    
    private void initHeaderPanels() {
        tableHeaderPanel = new TableHeaderPanel[dataModel.getColumnCount()];
        for (int i = 0; i < tableHeaderPanel.length; i++) {
            tableHeaderPanel[i] = new TableHeaderPanel(getModel().getColumnName(i), i);
        }
    }
    
    public void setColumnClasses(Class clases[]) {
        this.clases = clases;
        for (int i = 0; i < clases.length; i++) {
            getColumnModel().getColumn(i).setCellRenderer(new CustomTableBodyCellRenderer());
            getColumnModel().getColumn(i).setCellEditor(new CustomTableBodyCellEditor());
        }
    }
    
    @Override
    public void setModel(TableModel dataModel) {
        super.setModel(dataModel);
        initHeaderPanels();
    }
    
    @Override
    public Class<?> getColumnClass(int column) {
        for (int row = 0; row < getRowCount(); row++) {
            Object value = getValueAt(row, column);
            if (value != null) {
                return value.getClass();
            }
        }
        return Object.class;
    }
    
}


