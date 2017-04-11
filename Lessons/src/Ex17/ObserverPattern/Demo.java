package Ex17.ObserverPattern;

import Ex17.ObserverPattern.staff.*;
import Ex17.ObserverPattern.utils.AnimalGenerator;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        //generate staff
        System.out.println("Generate staff\n");
        List<Worker> staff = new ArrayList<>();
        Director director = new Director(0, "Ivanov");
        staff.add(director);
        Vet vet = new Vet(1, "Petrov");
        staff.add(vet);
        Groomer groomer = new Groomer(2, "Sidorov");
        staff.add(groomer);
        Feeder feeder = new Feeder(3, "Alekseev");
        staff.add(feeder);

        for (Worker worker:staff){
            System.out.println(worker);
        }

        System.out.println();
        System.out.println("-------------------");

        //Generate Animals
        System.out.println("Generate animals\n");
        AnimalGenerator generator = new AnimalGenerator();
        List<Animal> zoo = generator.generateAnimals(15);

        for (Animal animal:zoo){
            System.out.println(animal);
        }
        System.out.println();
        System.out.println("-------------------");

        //subscribe workers
        System.out.println("Subscribe workers\n");
        for (Animal animal: zoo){
            for (Worker worker:staff){
                animal.subscribe(worker);
            }
        }
        System.out.println();
        System.out.println("-------------------");

        System.out.println("Generate events\n");
        System.out.println();
        //generate events
        for (Animal animal: zoo){
            animal.generateEvent();
        }
        System.out.println();
        System.out.println("-------------------");

        //add new feeder
        System.out.println("Add new feeder\n");
        Feeder feederPets = new Feeder(4, "Kuklachev");
        staff.add(feederPets);
        System.out.println(feederPets);
        System.out.println();
        System.out.println("-------------------");

        //subscribe new feeder for pets and unsubscribe old one
        //generate hunger
        System.out.println("Change subscription for feeders and generate hunger event\n");
        for (Animal animal:zoo){
            if (animal instanceof AnimalDomestic){
                animal.unsubscribe(feeder);
                animal.subscribe(feederPets);
            }
            animal.generateHunger();
        }
        System.out.println();
        System.out.println("-------------------");
    }


}
