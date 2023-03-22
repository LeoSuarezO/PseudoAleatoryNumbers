package com.uptc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MiddleSquareData extends Header{

    private JTextField seed;
    private JTextField digits;
    private JSpinner max;
    private JSpinner min;
    private JTextField quantity;
    private JButton generate;
    public MiddleSquareData(ActionListener listener) {
        this.seed = new JTextField();
        this.digits = new JTextField("4");
        this.max = new JSpinner();
        this.min = new JSpinner();
        this.quantity = new JTextField();
        this.generate = new JButton("Generar Numeros");
        this.setLayout(new GridLayout(6, 1, 5, 2));
        // this.setPreferredSize(new Dimension(80,120));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        seed.setBorder(BorderFactory.createTitledBorder("Semilla"));
        this.add(seed);

        max.setBorder(BorderFactory.createTitledBorder("Maximo"));
        max.setBackground(Color.WHITE);
        max.setValue(1);
        this.add(max);

        min.setBorder(BorderFactory.createTitledBorder("Minimo"));
        min.setBackground(Color.WHITE);
        this.add(min);

        digits.setBorder(BorderFactory.createTitledBorder("Digitos"));
        digits.setBackground(Color.WHITE);
        this.add(digits);


        quantity.setBorder(BorderFactory.createTitledBorder("Cantidad de numeros a generar"));
        this.add(quantity);

        generate.addActionListener(listener);
        generate.setActionCommand(Command.GENERATE_MIDD.name());
        generate.setBackground(Color.RED);
        generate.setForeground(Color.WHITE);
        this.add(generate);
    }

    @Override
    public int getSeed() {
        return Integer.valueOf(seed.getText());
    }

    @Override
    public int getQuantity() {
        return Integer.valueOf(quantity.getText());
    }

    @Override
    public int getDigits() {
        return Integer.valueOf(digits.getText());
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

