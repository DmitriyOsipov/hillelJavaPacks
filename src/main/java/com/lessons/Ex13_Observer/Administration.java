package com.lessons.Ex13_Observer;

import com.lessons.Ex13_Observer.events.*;

import java.util.HashMap;
import java.util.Map;

public class Administration {

    private Subscription<EventHunger> hungerSubscription = new Subscription<>();
    private Subscription<EventSick> sickSubscription = new Subscription<>();
    private Subscription<EventGroom> groomSubscription = new Subscription<>();
    private Subscription<EventHungerD> hungerDSubscription = new Subscription<>();

    Map<String, Subscription> subscriptions = new HashMap<>();

    public Administration() {
        fillSubscriprions();
    }

    private void fillSubscriprions(){
        subscriptions.put(EventHunger.class.getName(), hungerSubscription);
        subscriptions.put(EventSick.class.getName(), sickSubscription);
        subscriptions.put(EventGroom.class.getName(), groomSubscription);
        subscriptions.put(EventHungerD.class.getName(), hungerDSubscription);
    }

    public void subscribe(Class event, Observer subscriber){
        String eventName = event.getName();
        if (eventName.equals(Event.class.getName())){
            subscribeAll(subscriber);
        }
        else {
            subscriptions.get(eventName).subscribe(subscriber);
        }
    }

    public void unsubscribe(Class event, Observer subscriber){
        String eventName = event.getName();
        if (eventName.equals(Event.class.getName())){
            unsubscribeAll(subscriber);
        }
        else {
            subscriptions.get(eventName).unsubscribe(subscriber);
        }
    }

    public void reactEvent(Event event, Animal animal){
        String eventType = event.getClass().getName();
        subscriptions.get(eventType).notifySubscribers(animal, event);
    }

    private void subscribeAll(Observer observer){
        for (Subscription subscription: subscriptions.values()){
            subscription.subscribe(observer);
        }
    }

    private void unsubscribeAll(Observer observer){
        for (Subscription subscription: subscriptions.values()){
            subscription.unsubscribe(observer);
        }
    }
}
