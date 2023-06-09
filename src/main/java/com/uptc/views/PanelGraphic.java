package com.uptc.views;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelGraphic extends JPanel {

    private XYSeriesCollection dataset;
    private XYSeries series;
    private JFreeChart chart;
    private int index;

    public PanelGraphic() {
        this.setBackground(Color.WHITE);
    }

    public void setData(List<Double> ri) {
        dataset = new XYSeriesCollection();
        series = new XYSeries("Ri");
        index = 0;
        for (Double data : ri) {
            series.add(index++, data);
        }
        dataset.addSeries(series);
        chart = ChartFactory.createScatterPlot("Diagrama de Dispersion", "", "Ni", dataset, PlotOrientation.VERTICAL,
                false, true, false);
        ChartPanel panel = new ChartPanel(chart);
        this.add(panel);
        panel.updateUI();
    }

    public void resetGraphic() {
        this.removeAll();
    }
}
