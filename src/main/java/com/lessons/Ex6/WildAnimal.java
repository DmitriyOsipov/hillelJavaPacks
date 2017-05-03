package com.lessons.Ex6;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class WildAnimal extends Animal {
    private final boolean isPredator;

    public WildAnimal(int id, int age, double weight, String color, boolean isPredator) {
        super(id, age, weight, color);
        this.isPredator = isPredator;
    }

    public boolean isPredator() {
        return isPredator;
    }

    public String makeVoice(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.makeVoice());
        builder.append(" I am a wild animal");
        if (isPredator){
            builder.append(" and I am hungry");
        }
        return builder.toString();
    }
}
