package Ex14.ObserverPattern;


public interface Observable {
    public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);
    public void notifySubscribers(Event event);
}
