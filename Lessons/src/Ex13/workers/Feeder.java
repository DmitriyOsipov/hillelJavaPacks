package Ex13.workers;


import Ex13.events.Event;

public class Feeder extends Worker{
    private String forAnimals;

    public Feeder(int id, String name, String forAnimals) {
        super(id, name);
        this.forAnimals = forAnimals;
    }

    @Override
    public void notify(Event event) {
        System.out.println("I'm a feeder for " + forAnimals + " I'll feed that animal ");
    }
}
