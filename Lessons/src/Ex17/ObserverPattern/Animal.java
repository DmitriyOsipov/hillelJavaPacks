package Ex17.ObserverPattern;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Animal implements Observable, Serializable {
    public static final long serialVersionUID = 201704111702L;
    private final int id;
    private final String type;
    private Set<Observer> observers = new HashSet<>();
    private EventGeneratorInterface eventGenerator;

    public Animal(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public void setEventGenerator(EventGeneratorInterface eventGenerator) {
        this.eventGenerator = eventGenerator;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public void subscribe(Observer observer) {
        if (observer!=null) {
            observers.add(observer);
        }
        else {
            throw new NullPointerException("Observer can't be null");
        }
    }

    @Override
    public void unsubscribe(Observer observer) {
        if (observer!=null) {
            observers.remove(observer);
        }
        else {
            throw new NullPointerException("Observer can't be null");
        }
    }

    @Override
    public void notifySubscribers(Event event) {
        for (Observer observer: observers){
            try {
                observer.notifyObserver(event);
            }
            catch (RuntimeException e){
                observers.remove(observer);
                System.out.println("There was an exception in reaction. Observer " + observer + " was unsubscribed.");
            }
        }
    }

    public void generateEvent(){
        Event event = eventGenerator.generateEvent(this);
        notifySubscribers(event);
    }

    public void generateHunger(){
        Event event = eventGenerator.generateHunger(this);
        notifySubscribers(event);
    }


    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                " type=" + type +
                '}';
    }
}
