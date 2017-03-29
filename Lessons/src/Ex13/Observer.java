package Ex13;

import Ex13.events.Event;

public interface Observer<T> {
    void notify(T event);
}
