package Ex14.ObserverPattern;

import java.util.Random;

public class EventGeneratorDomestic extends EventGenerator{
    @Override
    public Event generateEvent(Animal animal) {
        Random random = new Random();
        int generatedValue = Math.abs(random.nextInt(100));
        if (generatedValue>75){
            return generateGroom(animal);
        }
        else {
            return super.generateEvent(animal);
        }
    }

    private Event generateGroom(Animal animal){
        Event event = new Event(animal);
        event.setEventType(Event.EventType.EVENT_GROOM);
        event.setMessage("Animal " + animal + " need a groomer.");
        return event;
    }
}
