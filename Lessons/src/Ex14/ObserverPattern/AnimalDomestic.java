package Ex14.ObserverPattern;


import Ex14.ObserverPattern.events.EventGroom;

import java.util.ArrayList;
import java.util.List;

public class AnimalDomestic extends Animal{
    public AnimalDomestic(int id) {
        super(id);
    }
    List<Observer<EventGroom>> subscribersGroom = new ArrayList<>();
}
