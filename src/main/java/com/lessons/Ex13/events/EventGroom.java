package com.lessons.Ex13.events;

import java.util.Date;

public class EventGroom extends Event {
    public EventGroom(int animalId, Date time) {
        super(animalId, time, "I need a groomer! ");
    }

    @Override
    public String giveMessage() {
        return "I need a groomer! " + super.toString();
    }
}
