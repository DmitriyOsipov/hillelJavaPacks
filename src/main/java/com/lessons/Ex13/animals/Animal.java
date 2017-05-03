package com.lessons.Ex13.animals;

import com.lessons.Ex13.events.*;

import java.util.Date;
import java.util.Random;

/**
 * Created by Dreamer on 19.02.2017.
 */
public abstract class Animal {
    private final int id;
    private int age;
    private double weight;
    private String color;
    private boolean isWild;

    public Animal(int id, boolean isWild){
        this.id = id;
        this.isWild = isWild;
    }

    public Animal(int id, int age, double weight, String color) {
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {

        return id;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String makeVoice(){
        return "Hello,";
    }

    public Event sendEvent(){
        Random random = new Random();
        switch (random.nextInt(2)){
            case 0:{
                String message = (isWild) ? "I'm wild" : "I'm domestic";
                return (isWild) ? new EventHungerWild(this.id, new Date(), message):new EventHungerDomestic(this.id, new Date(), message);
            }
            default:
                return new EventIll(this.id, new Date());
        }
    }

}
