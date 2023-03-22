package com.uptc.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class NumbersTable extends JPanel {

    private DefaultTableModel dtmElements;
    private JTable table;
    private JScrollPane scroll;

    public NumbersTable(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setPreferredSize(new Dimension(500, 570));
        initComponents();
    }

    public void initComponents(){
        dtmElements = new DefaultTableModel() {
            /**
             *
             */
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dtmElements.setColumnIdentifiers(new String[] { "Xi", "Ri", "Ni" });

        table = new JTable();
        table.setGridColor(Color.RED);
        table.setModel(dtmElements);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setBackground(Color.RED);
        table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(50);
        table.setBackground(Color.WHITE);
        table.setFillsViewportHeight(true);
        scroll = new JScrollPane(table);
        scroll.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(scroll, BorderLayout.PAGE_END);
        this.setBorder(null);
    }

    public void addRow(Object[] row) {
        dtmElements.addRow(row);
    }

    public void changeTableHeader(String[] header) {
        dtmElements.setColumnIdentifiers(header);
    }

    public void deleteTable() {
        dtmElements.setRowCount(0);
    }

    public void setHeader(String[] header) {
        dtmElements.setColumnIdentifiers(header);
    }


}
