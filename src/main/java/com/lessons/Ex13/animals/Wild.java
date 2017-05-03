package com.lessons.Ex13.animals;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Wild extends Animal {
    public Wild(int id) {
        super(id, true);
    }

    public Wild(int id, int age, double weight, String color) {
        super(id, age, weight, color);
    }


    public String makeVoice(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.makeVoice());
        builder.append(" I am a wild animal");

        return builder.toString();
    }

    @Override
    public String toString() {
        return super.toString() + "I'm a wild animal";
    }
}
