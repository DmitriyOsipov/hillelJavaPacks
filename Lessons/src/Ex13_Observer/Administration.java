package Ex13_Observer;

import Ex13_Observer.events.Event;
import Ex13_Observer.events.EventGroom;
import Ex13_Observer.events.EventHunger;
import Ex13_Observer.events.EventSick;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Administration {

    private Subscription<EventHunger> hungerSubscription = new Subscription<>();
    private Subscription<EventSick> sickSubscription = new Subscription<>();
    private Subscription<EventGroom> groomSubscription = new Subscription<>();

    Map<String, Subscription> subscriptions = new HashMap<>();

    public Administration() {
        fillSubscriprions();
    }

    private void fillSubscriprions(){
        subscriptions.put(EventHunger.class.getName(), hungerSubscription);
        subscriptions.put(EventSick.class.getName(), sickSubscription);
        subscriptions.put(EventGroom.class.getName(), groomSubscription);
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
        System.out.println("\t\t"+eventType);
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
