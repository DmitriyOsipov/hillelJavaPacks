package Ex13_Observer;

import Ex13_Observer.events.*;

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
        int generatedValue = Math.abs(random.nextInt(4));
        Event event = null;

        switch (generatedValue){
            case 0:{
                event = new EventHungerD(animal.getId(), "I'm feeling hungry. Dom");
            }break;
            case 1:{
                event = new EventGroom(animal.getId(), "I need a groomer");
            }
            default:{
                event = new EventSick(animal.getId(), "I'm feeling badly");
            }break;
        }

        return event;
    }


}
