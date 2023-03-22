package com.uptc.views;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DialogResult extends JDialog {

    public JPanel mainPanel;
    private NumbersTable table;
    private PanelGraphic graphic;
    public DialogResult(MainWindow parent, NumbersTable table, PanelGraphic graphic){
        super(parent);
        initComponents(table, graphic);
        this.setContentPane(mainPanel);
        this.setMinimumSize(new Dimension(1200, 580));
        setLocationRelativeTo(parent);
    }

    public void initComponents(NumbersTable table, PanelGraphic graphic){
        mainPanel = new JPanel();
        this.table = table;
        this.graphic = graphic;
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(table, BorderLayout.WEST);
        mainPanel.add(graphic, BorderLayout.CENTER);
    }
    public void initDialog(String methodName){
        this.setVisible(true);
        this.setTitle(methodName);
    }
    public void setTableRow(Object[] row) {
        table.addRow(row);
    }

    public void resetTable() {
        table.deleteTable();
    }

    public void setGraphicData(List<Double> data) {
        graphic.setData(data);
    }

    public void resetGraphic() {
        graphic.resetGraphic();
    }

    public void setTableHeader(String[] header) {
        table.setHeader(header);
    }

}
