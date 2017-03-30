package Ex13.workers;


import Ex13.events.Event;
import Ex13.events.EventHunger;

public class Feeder<T extends EventHunger> extends Worker<T>{
    private String forAnimals;

    public Feeder(int id, String name, String forAnimals) {
        super(id, name);
        this.forAnimals = forAnimals;
    }

    @Override
    public void notifyObserver(T event) {
        System.out.println("I'm a feeder for " + forAnimals + " I'll feed that animal ");
    }
}
