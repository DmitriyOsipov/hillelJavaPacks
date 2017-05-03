package com.lessons.Ex13;

import com.lessons.Ex13.events.Event;

public interface Observer<T extends Event> {
    void notifyObserver(T event);
}
