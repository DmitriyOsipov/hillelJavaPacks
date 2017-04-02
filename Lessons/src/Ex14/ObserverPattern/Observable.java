package Ex14.ObserverPattern;


import Ex14.ObserverPattern.events.Event;

public interface Observable<T extends Event> {
    public void subscribe(Observer<T> observer);
    public void unsubscribe(Observer<T> observer);
    public void notifySubscribers(Object actor, T event);
}
