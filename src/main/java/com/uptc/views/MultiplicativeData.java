package com.uptc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MultiplicativeData extends Header{

    private JTextField x;
    private JTextField t;
    private JTextField g;
    private JSpinner max;
    private JSpinner min;
    private JTextField quantity;
    private JButton generate;

    public MultiplicativeData(ActionListener listener) {
        this.x = new JTextField();
        this.t = new JTextField();
        this.g = new JTextField();
        this.max = new JSpinner();
        this.min = new JSpinner();
        this.quantity = new JTextField();
        this.generate = new JButton("Generar Numeros");
        this.setLayout(new GridLayout(7, 1, 5, 2));
        // this.setPreferredSize(new Dimension(80,120));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {

        x.setBorder(BorderFactory.createTitledBorder("Valor de X"));
        this.add(x);

        t.setBorder(BorderFactory.createTitledBorder("Valor de T"));
        this.add(t);

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
        generate.setActionCommand(Command.GENERATE_MULT.name());
        generate.setBackground(Color.RED);
        generate.setForeground(Color.WHITE);
        this.add(generate);
    }

    @Override
    public int getXi() {
        return Integer.valueOf(x.getText());
    }

    @Override
    public int getT() {
        return Integer.valueOf(t.getText());
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
