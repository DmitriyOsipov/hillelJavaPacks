package com.lessons.Ex13_Observer;
import com.lessons.Ex13_Observer.events.Event;

public interface Observer<T extends Event>{
    public void notifyObserver(Object actor, T event);
}
