package Ex13_Observer;
import Ex13_Observer.events.Event;

public interface Observer<T extends Event>{
    public void notifyObserver(Object actor, T event);
}
