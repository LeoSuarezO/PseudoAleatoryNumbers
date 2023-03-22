package com.uptc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UniformData extends Header{

    private JTextField quantity;
    private JSpinner max;
    private JSpinner min;
    private JButton generate;

    public UniformData(ActionListener listener) {
        this.quantity = new JTextField();
        this.max = new JSpinner();
        this.min = new JSpinner();
        this.generate = new JButton("Generar Numeros");
        this.setLayout(new GridLayout(4, 1, 5, 2));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
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
        generate.setActionCommand(Command.GENERATE_UNIFORM.name());
        generate.setBackground(Color.RED);
        generate.setForeground(Color.WHITE);
        this.add(generate);

    }

    @Override
    public int getQuantity() {
        return Integer.parseInt(quantity.getText());
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
