package com.lessons.Ex14.ObserverPattern.staff;

import com.lessons.Ex14.ObserverPattern.Event;

public class Feeder extends Worker {
    public Feeder(int id, String name) {
        super(id, name, "Feeder");
    }

    @Override
    public void notifyObserver(Event event) {
        if (event.getEventType().equals(Event.EventType.EVENT_HUNGER)){
            System.out.println(this + " react on event " + event );
        }
    }
}
