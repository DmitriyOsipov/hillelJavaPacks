package com.lessons.Ex9.figures;

/**
 * Created by Dreamer on 05.03.2017.
 */
public class Triangle extends Figure {
    private final double height;
    private final double base;

    public Triangle(FigureColor color, double height, double base) {
        super("Triangle", color);
        this.height = height;
        this.base = base;
    }

    @Override
    public double area() {
        return height*base/2;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "height=" + height +
                ", base=" + base +
                ", color=" + this.getColor() +
                '}';
    }
}
