package com.lessons.Ex17.animalsSerialization.animalsClasses;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Wolf extends WildAnimal {
    public static final long serialVersionUID = 2017041312L;
    public Wolf() {
    }

    public Wolf(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }
}
