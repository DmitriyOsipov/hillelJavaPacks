package Ex14.ObserverPattern;

public interface EventGeneratorInterface {
    public Event generateEvent(Animal animal);
    public Event generateHunger(Animal animal);
}
