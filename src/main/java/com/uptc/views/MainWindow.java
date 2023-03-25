package com.uptc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class MainWindow extends JFrame {

    private static final int WIDTH = 605;
    private static final int HEIGHT = 420;
    private PanelOption option;
    public MainWindow(ActionListener listener){
        this.setTitle("Generador de numeros Pseudo-Aleatorios");
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.option = new PanelOption(listener, this);
        this.setContentPane(option);
    }

    public Header getMidSrtHeader() {
        return option.getMidSrtHeader();
    }

    public Header getLinearHeader() {
        return option.getLinHeader();
    }

    public Header getMultHeader() {
        return option.getMultHeader();
    }

    public Header getNormalHeader() {
        return option.getNormHeader();
    }

    public Header getUniformHeader() {
        return option.getUniHeader();
    }

    public void setMiddTableRow(Object[] element) {
        option.setMiddSTableRow(element);
    }

    public void resetMiddleTable() {
        option.resetMiddleTable();
    }

    public void setGraphicData(java.util.List<Double> ri) {
        option.setGraphicData(ri);
    }

    public void resetMiddleGraphic() {
        option.resetMiddleGraphic();
    }

    // Linear
    public void resetLinearGraphic() {
        option.resetLinearGraphic();
    }

    public void resetLinearTable() {
        option.resetLinearTable();
    }

    public void setLinearGraphicData(java.util.List<Double> interval) {
        option.setLinearGraphicData(interval);
    }

    public void setLinearTableRow(Object[] element) {
        option.setLinearTableRow(element);
    }

    // Multiplicative
    public void resetMultiplicativeTable() {
        option.resetMultiplicativeTable();
    }

    public void resetMultiplicativeGraphic() {
        option.resetMultiplicativeGraphic();
    }

    public void setMultiplicativeGraphicData(java.util.List<Double> interval) {
        option.setMultiplicativeGraphicData(interval);
    }

    public void setMultiplicativeTableRow(Object[] element) {
        option.setMultiplicativeTableRow(element);
    }

    // Uniform
    public void resetUniformTable() {
        option.resetUniformTable();
    }

    public void resetUniformGraphic() {
        option.resetUniformGraphic();
    }

    public void setUniformGraphicData(java.util.List<Double> interval) {
        option.setUniformGraphicData(interval);
    }

    public void setUniformTableRow(Object[] element) {
        option.setUniformTableRow(element);
    }


    //Normal
    public void setNormalTableRow(Object[] element) {
        option.setNormalTableRow(element);
    }

    public void resetNormalTable() {
        option.resetNormalTable();
    }

    public void resetNormalGraphic() {
        option.resetNormalGraphic();
    }

    public void setNormalGraphicData(List<Double> interval) {
        option.setNormalGraphicData(interval);
    }

    public void middleDialog(){
        option.middleDialog();
    }
    public void multipDialog(){
        option.multipDialog();
    }
    public void linearDialog(){
        option.linearDialog();
    }
    public void uniformDialog(){
        option.uniformDialog();
    }
    public void normalDialog(){
        option.normalDialog();
    }
}
