package com.lessons.Ex17.ObserverPattern.staff;

import com.lessons.Ex17.ObserverPattern.Event;

public class Vet extends Worker {
    public Vet(int id, String name) {
        super(id, name, "Vet");
    }

    @Override
    public void notifyObserver(Event event) {
        if (!event.getEventType().equals(Event.EventType.EVENT_GROOM)){
            System.out.println(this + " react on event " + event );
        }
    }
}
