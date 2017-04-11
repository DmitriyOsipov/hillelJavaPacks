package Ex17.ObserverPattern;

public interface EventGeneratorInterface {
    public Event generateEvent(Animal animal);
    public Event generateHunger(Animal animal);
}
