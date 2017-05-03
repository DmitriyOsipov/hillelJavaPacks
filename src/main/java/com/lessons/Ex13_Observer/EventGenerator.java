package com.lessons.Ex13_Observer;

import com.lessons.Ex13_Observer.events.Event;

public interface EventGenerator {
    public Event getState(Animal animal);
}
