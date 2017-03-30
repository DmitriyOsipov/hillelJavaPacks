package Ex13;


import Ex13.events.Event;

import java.util.LinkedList;
import java.util.List;

public class Registrator implements Observable{
    List<Observer> subs = new LinkedList<>();
    @Override
    public void subscribe(Observer observer) {
        if(observer!=null){
            subs.add(observer);
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
        subs.remove(observer);
    }

    @Override
    public void notifySubscribers(Event event) {
        for (Observer observer : subs){
            observer.notify(event);
        }
    }
}
