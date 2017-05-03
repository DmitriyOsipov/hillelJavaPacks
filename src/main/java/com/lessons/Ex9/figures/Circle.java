package com.lessons.Ex9.figures;


public class Circle extends Figure {
    private final double radius;

    public Circle(FigureColor color, double radius) {
        super("Circle", color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color=" + getColor() +
                '}';
    }
}
