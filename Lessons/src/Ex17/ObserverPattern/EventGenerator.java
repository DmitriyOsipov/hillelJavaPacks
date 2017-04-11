package Ex17.ObserverPattern;

import java.io.Serializable;
import java.util.Random;

public class EventGenerator implements EventGeneratorInterface, Serializable {
    @Override
    public Event generateEvent(Animal animal) {
        Event event = null;
        Random random = new Random();
        int generatedValue = Math.abs(random.nextInt(2));
        switch (generatedValue){
            case 0:{
                event = generateHunger(animal);
            }break;
            case 1:{
                event = generateSick(animal);
            }break;
            default:{
                event = generateSick(animal);
            }
        }
        return event;
    }

    private Event generateSick(Animal animal){
        Event sick = new Event(animal);
        sick.setEventType(Event.EventType.EVENT_SICK);
        sick.setMessage("Animal " + animal + " is sick");
        return sick;
    }

    public Event generateHunger(Animal animal){
        Event hunger = new Event(animal);
        hunger.setEventType(Event.EventType.EVENT_HUNGER);
        hunger.setMessage("Animal " + animal + " feels hunger.");
        return hunger;
    }
}
