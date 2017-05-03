package com.lessons.Ex17.animalsSerialization.animalsClasses;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;

/**
 * Created by Dreamer on 19.02.2017.
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public class Animal implements Serializable{
    public static final long serialVersionUID = 2017041301L;
    private int id;
    private int age;
    private double weight;
    private String color;

    public Animal() {}

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
}
