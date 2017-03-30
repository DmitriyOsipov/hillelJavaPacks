package Ex13.workers;

import Ex13.events.Event;

public class Director extends Worker{
    public Director(int id, String name) {
        super(id, name);
    }

    @Override
    public void notifyObserver(Event event) {
        System.out.println("I'm a Director. I'll track this.");
    }

}
