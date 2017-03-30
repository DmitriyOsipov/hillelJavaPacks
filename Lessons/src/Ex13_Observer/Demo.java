package Ex13_Observer;

import Ex13_Observer.events.Event;
import Ex13_Observer.events.EventGroom;
import Ex13_Observer.events.EventHunger;
import Ex13_Observer.events.EventSick;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Demo {

    public static void main(String[] args) {
        Administration admin = new Administration();

        List<Animal> animals = generateAnimals(10);
        List<Worker> workers = generateWorkers(admin);

        printList(animals);
        printList(workers);

        for (Animal animal: animals){
            try {
                System.out.println("++++++++++++");
                admin.reactEvent(animal.getState(), animal);
                Thread.sleep(1000);
            }
            catch (Exception e){}
        }

    }

    private static void printList(List objects){
        System.out.println();
        for (Object object:objects){
            System.out.println("--------");
            System.out.println(object);
        }
    }

    private static List<Animal> generateAnimals(int count){
        Random random = new Random();
        EventGenerator eventGenerator = new RandomEventGenerator();

        List<Animal> animals = new ArrayList<>(count);
        for (int i=0; i<count; i++){
            boolean isWild = (Math.abs(random.nextInt(2))==1);
            Animal newAnimal = new Animal(i, isWild);
            newAnimal.setStateGenerator(eventGenerator);
            animals.add(newAnimal);
        }

        return animals;
    }


    private static List<Worker> generateWorkers(Administration administration){
        List<Worker> workers = new LinkedList<>();

        Worker<Event> director =new Worker<Event>(0, "Director");
        administration.subscribe(Event.class, director);
        workers.add(director);

        Worker<EventSick> vet = new Worker<EventSick>(1, "Vet");
        administration.subscribe(EventSick.class, vet);
        workers.add(vet);

        Worker<EventGroom> groomer = new Worker<EventGroom>(2, "Groomer");
        administration.subscribe(EventGroom.class, groomer);
        workers.add(groomer);

        Worker<EventHunger> feeder = new Worker<EventHunger>(3, "Feeder");
        administration.subscribe(EventHunger.class, feeder);
        workers.add(feeder);

        return workers;
    }
}
