package com.uptc.controller;

import com.uptc.models.*;
import com.uptc.utils.FileManager;
import com.uptc.utils.Interval;
import com.uptc.utils.Utilities;
import com.uptc.views.Command;
import com.uptc.views.Header;
import com.uptc.views.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class Controller implements ActionListener {

    private MainWindow mainWindow;

    public Controller(){
        mainWindow = new MainWindow(this);
        mainWindow.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Header header;
        switch (Command.valueOf(e.getActionCommand())) {
            case GENERATE_MIDD -> {
                header = mainWindow.getMidSrtHeader();
                try {
                    manageMiddleSqr(header);
                    mainWindow.middleDialog();
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            case GENERATE_LINEAS -> {
                header = mainWindow.getLinearHeader();
                try {
                    manageLinear(header);
                    mainWindow.linearDialog();
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            case GENERATE_MULT -> {
                header = mainWindow.getMultHeader();
                try {
                    manageMultiplicative(header);
                    mainWindow.multipDialog();
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            case GENERATE_NORMAL -> {
                header = mainWindow.getNormalHeader();
                try {
                    manageNormal(header);
                    mainWindow.normalDialog();
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            case GENERATE_UNIFORM -> {
                header = mainWindow.getUniformHeader();
                try {
                    manageUniform(header);
                    mainWindow.uniformDialog();
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "App Failure!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void manageUniform(Header header) throws IOException {
        Uniform uniform = new Uniform(header.getQuantity());
        List<Double> aleatory = uniform.getAleatory();
        List<Double> interval = new Interval(header.getMin(), header.getMax(), aleatory).getInterval();
        FileManager.writeToArchive(aleatory, "files/uniform.num");
        manageUniformTable(aleatory, interval);
    }

    private void manageUniformTable(List<Double> aleatory, List<Double> interval) {
        mainWindow.resetUniformTable();
        mainWindow.resetUniformGraphic();
        mainWindow.setUniformGraphicData(interval);
        List<Object[]> elements = Utilities.toObjectArrayList(aleatory, interval);
        for (Object[] element : elements) {
            mainWindow.setUniformTableRow(element);
        }
    }

    // Normal
    private void manageNormal(Header header) throws IOException {
        List<Double> aleatory = new Uniform(header.getXi()).getAleatory();
        List<Double> seeds = new Uniform(header.getQuantity()).getAleatory();
        Normal normal = new Normal(header.getQuantity(), new Interval(header.getMin(), header.getMax(), aleatory),
                seeds);
        FileManager.writeToArchive(normal.getAleatory(), "files/normal.num");
        manageNormalTable(seeds, normal.getAleatory());
    }

    private void manageNormalTable(List<Double> seeds, List<Double> normList) {
        mainWindow.resetNormalTable();
        mainWindow.resetNormalGraphic();
        mainWindow.setNormalGraphicData(normList);
        List<Object[]> elements = Utilities.toObjectArrayList(seeds, normList);
        for (Object[] element : elements) {
            mainWindow.setNormalTableRow(element);
        }
    }

    // Multiplicative
    private void manageMultiplicative(Header header) throws IOException {
        MultCong multiplicative = new MultCong(header.getXi(), header.getT(), header.getG(),
                header.getQuantity());
        List<Double> aleatory = multiplicative.getAleatory();
        System.out.println(aleatory);
        List<Double> interval = new Interval(header.getMin(), header.getMax(), aleatory).getInterval();

        FileManager.writeToArchive(aleatory, "files/multiplicative.num");
        manageMultiplicativeTable(multiplicative.getSeeds(), aleatory, interval);
    }

    private void manageMultiplicativeTable(List<Integer> seeds, List<Double> aleatory, List<Double> interval) {
        mainWindow.resetMultiplicativeTable();
        mainWindow.resetMultiplicativeGraphic();
        mainWindow.setMultiplicativeGraphicData(interval);
        List<Object[]> elements = Utilities.toObjectArrayList(seeds, aleatory, interval);
        for (Object[] element : elements) {
            mainWindow.setMultiplicativeTableRow(element);
        }
    }

    // Linear
    private void manageLinear(Header header) throws IOException {
        Linear linear = new Linear(header.getXi(), header.getK(), header.getC(), header.getG(), header.getQuantity());
        List<Double> aleatory = linear.getAleatory();
        List<Double> interval = new Interval(header.getMin(), header.getMax(), aleatory).getInterval();

        FileManager.writeToArchive(aleatory, "files/linear.num");
        manageLinearTable(linear.getSeeds(), aleatory, interval);
    }

    private void manageLinearTable(List<Integer> seeds, List<Double> aleatory, List<Double> interval) {
        mainWindow.resetLinearTable();
        mainWindow.resetLinearGraphic();
        mainWindow.setLinearGraphicData(interval);
        List<Object[]> elements = Utilities.toObjectArrayList(seeds, aleatory, interval);
        for (Object[] element : elements) {
            mainWindow.setLinearTableRow(element);
        }
    }

    // Middle
    private void manageMiddleSqr(Header header) throws IOException {
        MiddleSquare middleSquare = new MiddleSquare(header.getSeed(), header.getDigits(), header.getQuantity());
        List<Double> aleatory = middleSquare.getAleatory();
        List<Double> interval = new Interval(header.getMin(), header.getMax(), aleatory).getInterval();

        FileManager.writeToArchive(aleatory, "files/middle-sqr.num");
        manageMiddleTable(middleSquare.getCenters(), aleatory, interval);
    }

    private void manageMiddleTable(List<Integer> xi, List<Double> ri, List<Double> ni) {
        mainWindow.resetMiddleTable();
        mainWindow.resetMiddleGraphic();
        mainWindow.setGraphicData(ni);
        List<Object[]> elements = Utilities.toObjectArrayList(xi, ri, ni);
        for (Object[] element : elements) {
            mainWindow.setMiddTableRow(element);
        }
    }
}
