package com.lessons.Ex17;

import com.lessons.Ex17.ObserverPattern.Animal;
import com.lessons.Ex17.ObserverPattern.staff.Worker;
import com.lessons.Ex17.ObserverPattern.utils.AnimalGenerator;
import com.lessons.Ex17.ObserverPattern.utils.StaffGenerator;

import java.io.PrintStream;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args)throws Exception{
        StaffGenerator staffGenerator = new StaffGenerator();
        AnimalGenerator animalGenerator = new AnimalGenerator();
        List<Animal> animals = animalGenerator.generateAnimals(10);
        List<Worker> workers = staffGenerator.generateStaff(animals);

        DataLayer dataLayer = new DataLayer();
        dataLayer.setFileTransformImpl(new SerializationFileTransformImpl(dataLayer.getFilesPath()));
        setOutStream(dataLayer.getFilesPath());

        Zoo zoo;
        //zoo = new Zoo(workers, animals);
        //printZoo(zoo);
        //DropEvent(zoo, 3);

        //dataLayer.saveAll(zoo);

        zoo = null;
        zoo = dataLayer.loadAll();

        printZoo(zoo);
        DropEvent(zoo, 3);
    }

    private static void printZoo(Zoo zoo){
        System.out.println("========================================");
        System.out.println(zoo.getStringStaff());
        System.out.println("----------------------------------------");
        System.out.println(zoo.getStringAnimals());
        System.out.println("========================================");
    }

    private static void DropEvent(Zoo zoo, int count){
        System.out.println(String.format("Generate %d events for random animals:", count));
        Random random = new Random();
        List<Animal> animals = zoo.getAnimals();
        for (int i=0; i<count; i++) {
            System.out.println(String.format("--Event %d", i+1));
            int index = Math.abs(random.nextInt()) % animals.size();
            animals.get(index).generateEvent();
            System.out.println("------");
        }
        System.out.println();
    }

    private static void setOutStream(String path) throws Exception{
        String filename = String.format("%s%s",path, "console.txt");
        PrintStream outputStream = new PrintStream(filename);
        System.setOut(outputStream);
    }
}
