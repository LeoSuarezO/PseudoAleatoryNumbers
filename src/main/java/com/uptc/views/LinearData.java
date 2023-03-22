package com.uptc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LinearData extends Header{

    private JTextField x;
    private JTextField k;
    private JTextField c;
    private JTextField g;
    private JSpinner max;
    private JSpinner min;
    private JTextField quantity;
    private JButton generate;

    public LinearData(ActionListener listener) {
        this.x = new JTextField();
        this.k = new JTextField();
        this.c = new JTextField();
        this.g = new JTextField();
        this.max = new JSpinner();
        this.min = new JSpinner();
        this.quantity = new JTextField();
        this.generate = new JButton("Generar Numeros");
        this.setLayout(new GridLayout(8, 1, 5, 2));
        // this.setPreferredSize(new Dimension(80,120));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {

        x.setBorder(BorderFactory.createTitledBorder("Valor de X"));
        this.add(x);

        c.setBorder(BorderFactory.createTitledBorder("Valor de C"));
        this.add(c);

        k.setBorder(BorderFactory.createTitledBorder("Valor de K"));
        this.add(k);

        g.setBorder(BorderFactory.createTitledBorder("Valor de G"));
        g.setBackground(Color.WHITE);
        this.add(g);

        max.setBorder(BorderFactory.createTitledBorder("Maximo"));
        max.setBackground(Color.WHITE);
        max.setValue(1);
        this.add(max);

        min.setBorder(BorderFactory.createTitledBorder("Minimo"));
        min.setBackground(Color.WHITE);
        this.add(min);

        quantity.setBorder(BorderFactory.createTitledBorder("Cantidad de numeros a generar"));
        this.add(quantity);

        generate.addActionListener(listener);
        generate.setActionCommand(Command.GENERATE_LINEAS.name());
        generate.setBackground(Color.RED);
        generate.setForeground(Color.WHITE);
        this.add(generate);
    }

    @Override
    public int getXi() {
        return Integer.valueOf(x.getText());
    }

    @Override
    public int getK() {
        return Integer.valueOf(k.getText());
    }

    @Override
    public int getC() {
        return Integer.valueOf(c.getText());
    }

    @Override
    public int getG() {
        return Integer.valueOf(g.getText());
    }

    @Override
    public int getQuantity() {
        return Integer.valueOf(quantity.getText());
    }

    @Override
    public int getMax() {
        return Integer.valueOf(max.getValue().toString());
    }

    @Override
    public int getMin() {
        return Integer.valueOf(min.getValue().toString());
    }

}
