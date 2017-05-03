package com.lessons.Ex9.figures;

/**
 * Created by Dreamer on 05.03.2017.
 */
public abstract class FigureColor {
    protected final String name;
    protected final double consumption;
    protected final double price;

    public FigureColor(String name, double consumption, double price) {
        this.name = name;
        this.consumption = consumption;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getPrice() {
        return price;
    }

}
