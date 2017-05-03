package com.lessons.Ex17.animalsSerialization;

import com.lessons.Ex17.animalsSerialization.animalsClasses.Animal;
import com.lessons.Ex17.animalsSerialization.animalsClasses.Pet;
import com.lessons.Ex17.animalsSerialization.animalsClasses.WildAnimal;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mtzadmin on 13.04.2017.
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public class Zoo implements Serializable{
    public static final long serialVersionUID = 2017041300L;
    private List<Animal> zoo;

    public Zoo() {
    }

    public Zoo(List<Animal> zoo) {
        this.zoo = zoo;
    }

    public void setZoo(List<Animal> zoo) {
        this.zoo = zoo;
    }

    public List<Animal> getZoo() {
        return zoo;
    }

    public void addAnimal(Animal animal){
        zoo.add(animal);
    }

    public void removeAnimal(Animal animal){
        zoo.remove(animal);
    }

    public static String printAnimal(Animal animal){
        boolean isWild = (animal instanceof WildAnimal);
        String type = (isWild) ? "wild animal" : "domestic animal";
        String formatString = "This animal is a %s. It is a %s. ID: %d, Age: %d, Weight: %5.3f, Color: %s.";
        String result = String.format(formatString, animal.getClass().getSimpleName(), type, animal.getId(), animal.getAge(), animal.getWeight(),
                animal.getColor());
        if (!isWild){
            result = result.concat(String.format(" Its' name is %s.", ((Pet)animal).getName()));
        }
        return result;
    }

    public String printAnimals(){
        StringBuilder builder = new StringBuilder("Animals in zoo:");
        for (Animal animal : zoo){
            builder.append("\n");
            builder.append(Zoo.printAnimal(animal));
        }
        return builder.toString();
    }


}
