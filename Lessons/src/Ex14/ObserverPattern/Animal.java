package Ex14.ObserverPattern;

import Ex14.ObserverPattern.events.EventHunger;
import Ex14.ObserverPattern.events.EventSick;

import java.util.HashSet;
import java.util.Set;

public class Animal implements Observable<EventHunger>{
    private final int id;

    public Animal(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    Set<Observer<EventSick>> subscribersIllness = new HashSet<>();
    Set<Observer<EventHunger>> subscribersHunger = new HashSet<>();

    @Override
    public void subscribe(Observer<EventHunger> observer) {
        subscribersHunger.add(observer);
    }

    @Override
    public void unsubscribe(Observer<EventHunger> observer) {
        subscribersHunger.remove(observer);
    }

    @Override
    public void notifySubscribers(Object actor, EventHunger event) {
        for(Observer<EventHunger> observer: subscribersHunger){
            observer.notifyObserver(actor, event);
        }
    }
}
