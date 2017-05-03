package com.lessons.Ex17.animalsSerialization.animalsClasses;


/**
 * Created by Dreamer on 19.02.2017.
 */

public class WildAnimal extends Animal {
    public static final long serialVersionUID = 2017041302L;
    private boolean predator;

    public WildAnimal() {
    }

    public WildAnimal(int id, int age, double weight, String color, boolean predator) {
        super(id, age, weight, color);
        this.predator = predator;
    }

    public boolean isPredator() {
        return predator;
    }

    public String makeVoice(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.makeVoice());
        builder.append(" I am a wild animal");
        if (predator){
            builder.append(" and I am hungry");
        }
        return builder.toString();
    }
}
