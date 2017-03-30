package Ex13;

import Ex13.events.Event;

public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifySubscribers(Event event);
}
