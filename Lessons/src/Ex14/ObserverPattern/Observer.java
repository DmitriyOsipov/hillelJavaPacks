package Ex14.ObserverPattern;

import Ex14.ObserverPattern.events.Event;

public interface Observer<T extends Event>{
    public void notifyObserver(Object actor, T event);
}
