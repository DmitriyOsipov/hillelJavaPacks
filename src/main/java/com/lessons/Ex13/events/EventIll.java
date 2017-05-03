package com.lessons.Ex13.events;


import java.util.Date;

public class EventIll extends Event {
    public EventIll(int animalId, Date time) {
        super(animalId, time, "I'm ill");
    }

    @Override
    public String giveMessage() {
        return "I'm ill " + super.toString();
    }
}
