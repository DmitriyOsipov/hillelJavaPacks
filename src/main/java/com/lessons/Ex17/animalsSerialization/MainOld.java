package com.lessons.Ex17.animalsSerialization;

import com.lessons.Ex17.animalsSerialization.animalsClasses.Animal;
import com.lessons.Ex17.animalsSerialization.animalsClasses.Cat;
import com.lessons.Ex17.animalsSerialization.animalsClasses.Pet;
import com.lessons.Ex17.animalsSerialization.animalsClasses.WildAnimal;

import java.io.PrintStream;
import java.util.List;

public class MainOld {
    public static void main(String[] args) throws Exception{
        String filesPath = "com\\Lessons\\Ex17\\animalsSerialization\\files\\";
        setOutStream(filesPath);
        DataLayer dataLayer = new DataLayer(filesPath);
        dataLayer.setRwImplemetation(setRWImplement());

        AnimalsGenerator animalsGenerator = new AnimalsGenerator();
        List<Animal> zoo = animalsGenerator.generateAnimals();
        System.out.println("Generated animals:");
        printAnimals(zoo);

        System.out.println("-------------------");

        dataLayer.saveAll(zoo);
        zoo = null;
/*
        zoo = dataLayer.loadAll();
        System.out.println("Loaded animals:");
        printAnimals(zoo);
        System.out.println("---------------");//*/

        Cat testAnimal = new Cat(123, 155, 50, "Black", "Behemoth", false);
        String filename = String.format("%s.dat", testAnimal.getClass().getSimpleName());
        System.out.println("Test animal");
        printAnimal(testAnimal);
        dataLayer.setFile(filename);
        dataLayer.saveToFile(testAnimal);

        System.out.println("Load test animal:");
        Animal testAnimal2 = dataLayer.loadFromFile();
        printAnimal(testAnimal2);
    }

    private static void printAnimals(List<Animal> animals){
        System.out.println("Animals in list:");
        for (Animal animal : animals){
            printAnimal(animal);
        }
    }

    private static void printAnimal(Animal animal){
        boolean isWild = (animal instanceof WildAnimal);
        String type = (isWild) ? "wild animal" : "domestic animal";
        String formatString = "This animal is a %s. It is a %s. ID: %d, Age: %d, Weight: %5.3f, Color: %s.";
        String result = String.format(formatString, animal.getClass().getSimpleName(), type, animal.getId(), animal.getAge(), animal.getWeight(),
                animal.getColor());
        if (!isWild){
            result = result.concat(String.format(" Its' name is %s.", ((Pet)animal).getName()));
        }
        System.out.println(result);
    }

    private static void setOutStream(String path) throws Exception{
        String filename = String.format("%s%s",path, "console.txt");
        PrintStream outputStream = new PrintStream(filename);
        System.setOut(outputStream);
    }

    private static FileRWInterface setRWImplement(){
        //return new SerializationImpl();
        return new JacksonSerialization();
    }
}
