package com.lessons.Ex17.ObserverPattern.utils;

import com.lessons.Ex17.ObserverPattern.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalGenerator {
    /*
    public List<Animal> generateAnimals(int count){
        ArrayList<Animal> animals = new ArrayList<>(count);
        Random random = new Random();
        int wildCount = Math.abs(random.nextInt(count/2));
        int id=0;
        for (int i=0; i<wildCount; i++){
            AnimalWild newWild = new AnimalWild(id++);
            newWild.setEventGenerator(new EventGenerator());
            animals.add(newWild);
        }
        for (int i=0; i<count-wildCount; i++){
            AnimalDomestic newPet = new AnimalDomestic(id++);
            newPet.setEventGenerator(new EventGeneratorDomestic());
            animals.add(newPet);
        }
        return animals;
    }//*/
    public List<Animal> generateAnimals(int count){
        ArrayList<Animal> animals = new ArrayList<>(count);
        Random random = new Random();
        //int id=0;
        for (int i=0; i<count; i++){
            Animal newAnimal;
            if (random.nextInt(2)==1) {
                newAnimal = new AnimalWild(i);
                newAnimal.setEventGenerator(new EventGenerator());
            }
            else {
                newAnimal = new AnimalDomestic(i);
                newAnimal.setEventGenerator(new EventGeneratorDomestic());
            }
            animals.add(newAnimal);
        }

        return animals;
    }
}
