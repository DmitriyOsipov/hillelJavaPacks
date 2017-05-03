package com.lessons.Ex17.ObserverPattern;

public class Event {

    public static enum EventType {EVENT_HUNGER, EVENT_SICK, EVENT_GROOM};

    private String message;
    private Animal animal;
    private EventType eventType;

    public Event(Animal animal) {
        this.animal = animal;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getMessage() {
        return message;
    }

    public Animal getAnimal() {
        return animal;
    }

    public EventType getEventType() {
        return eventType;
    }

    @Override
    public String toString() {
        return "Event{" +
                "message='" + message + '\'' +
                ", animal=" + animal +
                ", eventType=" + eventType +
                '}';
    }
}
