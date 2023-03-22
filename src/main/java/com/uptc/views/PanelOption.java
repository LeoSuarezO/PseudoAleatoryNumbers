package com.uptc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelOption extends JTabbedPane {

    private MethodOption midSquare;
    private MethodOption multiplicative;
    private MethodOption linear;
    private MethodOption uniform;
    private MethodOption normal;

    public PanelOption(ActionListener listener, MainWindow parent) {
        this.setBackground(Color.RED);
        this.setForeground(Color.WHITE);
        this.setFocusable(false);
        initComponents(listener, parent);
    }

    private void initComponents(ActionListener listener, MainWindow parent) {
        midSquare = new MethodOption(new MiddleSquareData(listener), parent);
        this.add("Cuadrados Medios", midSquare);

        multiplicative = new MethodOption(new MultiplicativeData(listener), parent);
        this.add("Congruencial Multiplicativa", multiplicative);

        linear = new MethodOption(new LinearData(listener), parent);
        this.add("Congruencial Lineal", linear);

        uniform = new MethodOption(new UniformData(listener), parent);
        uniform.setTableHeader(new String[] { "Ri", "Ni" });
        this.add("D. Uniforme", uniform);

        normal = new MethodOption(new NormalData(listener), parent);
        normal.setTableHeader(new String[] { "Xi", "Ri" });
        this.add("D. Normal", normal);
    }

    public Header getMidSrtHeader() {
        return midSquare.getHeader();
    }

    public Header getMultHeader() {
        return multiplicative.getHeader();
    }

    public Header getLinHeader() {
        return linear.getHeader();
    }

    public Header getUniHeader() {
        return uniform.getHeader();
    }

    public Header getNormHeader() {
        return normal.getHeader();
    }

    // Middle
    public void setMiddSTableRow(Object[] element) {
        midSquare.setTableRow(element);
    }

    public void resetMiddleTable() {
        midSquare.resetTable();
    }

    public void setGraphicData(java.util.List<Double> data) {
        midSquare.setGraphicData(data);
    }

    public void resetMiddleGraphic() {
        midSquare.resetGraphic();
    }

    // Linear
    public void resetLinearGraphic() {
        linear.resetGraphic();
    }

    public void setLinearGraphicData(java.util.List<Double> interval) {
        linear.setGraphicData(interval);
    }

    public void setLinearTableRow(Object[] element) {
        linear.setTableRow(element);
    }

    public void resetLinearTable() {
        linear.resetTable();
    }

    // Multiplicative

    public void resetMultiplicativeTable() {
        multiplicative.resetTable();
    }

    public void resetMultiplicativeGraphic() {
        multiplicative.resetGraphic();
    }

    public void setMultiplicativeGraphicData(java.util.List<Double> interval) {
        multiplicative.setGraphicData(interval);
    }

    public void setMultiplicativeTableRow(Object[] element) {
        multiplicative.setTableRow(element);
    }

    // Uniform
    public void resetUniformTable() {
        uniform.resetTable();
    }

    public void resetUniformGraphic() {
        uniform.resetGraphic();
    }

    public void setUniformGraphicData(java.util.List<Double> interval) {
        uniform.setGraphicData(interval);
    }

    public void setUniformTableRow(Object[] element) {
        uniform.setTableRow(element);
    }

    // Normal
    public void setNormalTableRow(Object[] element) {
        normal.setTableRow(element);
    }

    public void resetNormalTable() {
        normal.resetTable();
    }

    public void resetNormalGraphic() {
        normal.resetGraphic();
    }

    public void setNormalGraphicData(List<Double> interval) {
        normal.setGraphicData(interval);
    }

    public void middleDialog( ){
        midSquare.setDialogVisible("Cuadrados Medios");
    }
    public void multipDialog( ){
        multiplicative.setDialogVisible("Congruencia Multiplicativa");
    }
    public void linearDialog( ){
        linear.setDialogVisible("Congruencia Lineal");
    }
    public void uniformDialog(){
        uniform.setDialogVisible("Distribucion Uniforme");
    }
    public void normalDialog(){
        normal.setDialogVisible("Distribucion Normal");
    }
}
