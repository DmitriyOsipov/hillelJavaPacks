package Ex13.workers;

import Ex13.events.Event;

public class Groomer extends Worker{
    public Groomer(int id, String name) {
        super(id, name);
    }

    @Override
    public void notify(Event event) {
        System.out.println("I'm groomer. And I'll groom that animal");
    }
}
