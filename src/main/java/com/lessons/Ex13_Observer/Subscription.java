package com.lessons.Ex13_Observer;


import com.lessons.Ex13_Observer.events.Event;

import java.util.LinkedList;
import java.util.List;

public class Subscription<T extends Event> implements Observable<T> {

    private List<Observer<T>> subscribers;

    public Subscription() {
        this.subscribers = new LinkedList<>();
    }

    @Override
    public void subscribe(Observer<T> observer) {
        if (observer!=null){
            this.subscribers.add(observer);
        }
    }

    @Override
    public void unsubscribe(Observer<T> observer) {
        if (observer!=null){
            this.subscribers.remove(observer);
        }
    }

    @Override
    public void notifySubscribers(Object actor, T event) {
        for (Observer<T> subscriber : subscribers){
            subscriber.notifyObserver(actor, event);
        }
    }
}
