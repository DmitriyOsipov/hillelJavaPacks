package com.lessons.Ex17.animalsSerialization.animalsClasses;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Fish extends WildAnimal {
    public static final long serialVersionUID = 2017041307L;
    public Fish() {
    }

    public Fish(int id, int age, double weight, String color, boolean isPredator) {
        super(id, age, weight, color, isPredator);
    }

    @Override
    public String makeVoice(){
        return "....";
    }
}
