package com.uptc.models;

import com.uptc.utils.Interval;
import org.apache.commons.math3.distribution.NormalDistribution;
import java.util.ArrayList;
import java.util.List;

public class Normal {
    private double average;
    private double desviation;
    private List<Double> aleatory;
    private List<Double> seeds;

    /**
     *
     * @param quantity   Cantidad de Numeros a Generar
     * @param inte       Intervalo Aleatorio para Muestra y Desvicion
     * @param aleatoryXi Semillas para Generar Numeros
     */
    public Normal(int quantity, Interval inte, List<Double> aleatoryXi) {
        this.average = inte.getAverage();
        System.out.println(average);
        this.desviation = inte.getDeviation();
        System.out.println(desviation);
        this.seeds = aleatoryXi;
    }

    /**
     *
     * @return Lista de Numeros Aleatorios
     */
    public List<Double> getAleatory() {
        aleatory = new ArrayList<>();
        generateRandom();
        return aleatory;
    }

    private void generateRandom() {
        for (Double x : seeds) {
            aleatory.add(new NormalDistribution(average, desviation).inverseCumulativeProbability(x));
        }
    }
}