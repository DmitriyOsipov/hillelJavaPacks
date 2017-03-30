package Ex13;

import Ex13.events.Event;

public interface Observer<T extends Event> {
    void notifyObserver(T event);
}
