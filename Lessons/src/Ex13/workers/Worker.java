package Ex13.workers;

import Ex13.Observer;
import Ex13.events.Event;

public abstract class Worker implements Observer{
    private final int id;
    private String name;

    public Worker(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void notify(Event event);
}
