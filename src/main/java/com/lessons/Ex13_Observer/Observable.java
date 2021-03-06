package com.lessons.Ex13_Observer;


import com.lessons.Ex13_Observer.events.Event;

public interface Observable<T extends Event> {
    public void subscribe(Observer<T> observer);
    public void unsubscribe(Observer<T> observer);
    public void notifySubscribers(Object actor, T event);
}
