package com.uptc.views;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MethodOption extends JPanel {

    private final Header header;
    public DialogResult result;
    public MethodOption(Header header, MainWindow parent) {
        this.header = header;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        initComponents(parent);

    }

    private void initComponents(MainWindow parent) {
        this.add(header, BorderLayout.NORTH);
        NumbersTable table = new NumbersTable();
        PanelGraphic graphic = new PanelGraphic();
        result = new DialogResult(parent, table, graphic);
    }

    public Header getHeader() {
        return header;
    }

    public void setTableRow(Object[] row) {
        result.setTableRow(row);
    }

    public void resetTable() {
        result.resetTable();
    }

    public void setGraphicData(List<Double> data) {
        result.setGraphicData(data);
    }

    public void resetGraphic() {
        result.resetGraphic();
    }

    public void setTableHeader(String[] header) {
        result.setTableHeader(header);
    }

    public void setDialogVisible(String methodName){
        result.initDialog(methodName);
    }
}
