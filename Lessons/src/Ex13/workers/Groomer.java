package Ex13.workers;

import Ex13.events.Event;
import Ex13.events.EventGroom;

public class Groomer extends Worker<EventGroom>{
    public Groomer(int id, String name) {
        super(id, name);
    }

    @Override
    public void notifyObserver(EventGroom event) {
        System.out.println("I'm groomer. And I'll groom that animal");
    }
}
