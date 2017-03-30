package Ex13_Observer;

import Ex13_Observer.events.Event;

public interface EventGenerator {
    public Event getState(Animal animal);
}
