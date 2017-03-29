package Ex13.workers;


import Ex13.events.Event;

public class Vet extends Worker{
    public Vet(int id, String name) {
        super(id, name);
    }

    @Override
    public void notify(Event event) {
        System.out.println("I'm vet and I'll cure that animal!");
    }
}
