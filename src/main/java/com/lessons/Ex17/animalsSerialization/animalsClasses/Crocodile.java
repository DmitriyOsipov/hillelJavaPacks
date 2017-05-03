package com.lessons.Ex17.animalsSerialization.animalsClasses;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Crocodile extends WildAnimal {
    public static final long serialVersionUID = 2017041305L;
    public Crocodile() {
    }

    public Crocodile(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }
}
