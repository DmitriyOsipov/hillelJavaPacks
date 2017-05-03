package com.lessons.Ex13_Observer;

import com.lessons.Ex13_Observer.events.Event;

public class Animal {
    private final int id;
    private final boolean isWild;
    private EventGenerator stateGenerator;

    public Animal(int id, boolean isWild) {
        this.id = id;
        this.isWild = isWild;
    }

    public void setStateGenerator(EventGenerator stateGenerator) {
        this.stateGenerator = stateGenerator;
    }

    public int getId() {
        return id;
    }

    public boolean isWild() {
        return isWild;
    }

    public Event getState(){
        return stateGenerator.getState(this);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", isWild=" + isWild +
                '}';
    }
}
