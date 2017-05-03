package com.lessons.Ex9.figures;

/**
 * Created by Dreamer on 05.03.2017.
 */
public class Rectangle extends Figure {
    private final double height;
    private final double width;

    public Rectangle(FigureColor color, double height, double width) {
        super("Rectangle", color);
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return height*width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                ", color=" + getColor() +
                '}';
    }
}
