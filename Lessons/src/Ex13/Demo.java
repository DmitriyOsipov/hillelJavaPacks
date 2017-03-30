package Ex13;


import Ex13.animals.Animal;
import Ex13.animals.Domestic;
import Ex13.animals.Wild;
import Ex13.events.Event;
import Ex13.events.EventHunger;
import Ex13.events.EventHungerDomestic;
import Ex13.events.EventHungerWild;
import Ex13.workers.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        List<Animal> animals = fillAnimals();
        List<Worker> workers = fillWorkers();
        List<EventHungerWild> list = new LinkedList<>();

        for (int i = 0; i<10; i++) {
            System.out.println("--------------");
            Event event = sendEvent(animals);
            System.out.println(event.giveMessage());
            for (int j=0; j<workers.size(); j++) {
                try {
                    workers.get(j).notifyObserver(event);
                   // workers.get(4).notifyObserver(new EventHungerDomestic(4, new Date(), "test"));
                    Thread.sleep(1000);
                }
                catch (Exception e){

                }
            }
        }


    }

    public static List<Worker> fillWorkers(){
        List<Worker> workers = new LinkedList<>();
        workers.add(new Director(0, "Director"));
        workers.add(new Vet(1, "Vet"));
        workers.add(new Groomer(2, "Groomer"));
        workers.add(new Feeder(3, "Feeder", "All"));
        workers.add(new Feeder<EventHungerWild>(4, "Feeder - wild", "Wild"));
        workers.add(new Feeder<EventHungerDomestic>(5, "Feeder - domestic", "Domestic"));
        return workers;
    }

    public static List<Animal> fillAnimals(){
        List<Animal> animalList = new LinkedList<>();
        Random random = new Random();
        int wildQ = random.nextInt(10);
        int domQ = random.nextInt(10);
        for (int i=0; i<wildQ; i++){
            animalList.add(new Wild(i));
        }
        for (int i=0; i<domQ;i++){
            animalList.add(new Domestic(i+wildQ));
        }

        return animalList;
    }

    public static Event sendEvent(List<Animal> animals){
        Random random = new Random();
        int num = Math.abs(random.nextInt(animals.size()));
        return animals.get(num).sendEvent();
    }
}
