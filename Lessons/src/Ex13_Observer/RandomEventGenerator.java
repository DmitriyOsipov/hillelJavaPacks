package Ex13_Observer;

import Ex13_Observer.events.Event;
import Ex13_Observer.events.EventGroom;
import Ex13_Observer.events.EventHunger;
import Ex13_Observer.events.EventSick;

import java.util.Random;

public class RandomEventGenerator implements EventGenerator{
    @Override
    public Event getState(Animal animal) {
        if (animal.isWild()){
            return generateWild(animal);
        }
        return generateDomestic(animal);
    }

    private Event generateWild(Animal animal){
        Random random = new Random();
        int generatedValue = Math.abs(random.nextInt());
        Event event = null;

        switch (generatedValue){
            case 0:{
                event = new EventSick(animal.getId(), "I'm feeling badly");
            }break;
            default:{
                event = new EventHunger(animal.getId(), "I'm feeling hungry");
            }break;
        }

        return event;
    }

    private Event generateDomestic(Animal animal){
        Random random = new Random();
        if (Math.abs(random.nextInt(100))>75){
            return new EventGroom(animal.getId(), "I need groom");
        }
        else {
            return generateWild(animal);
        }
    }


}
