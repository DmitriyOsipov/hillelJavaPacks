package com.lessons.Ex13.workers;


import com.lessons.Ex13.events.EventIll;

public class Vet extends Worker<EventIll> {
    public Vet(int id, String name) {
        super(id, name);
    }

    @Override
    public void notifyObserver(EventIll event) {
        System.out.println("I'm vet and I'll cure that animal!");
    }
}
