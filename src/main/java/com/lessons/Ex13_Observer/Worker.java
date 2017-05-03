package com.lessons.Ex13_Observer;


import com.lessons.Ex13_Observer.events.Event;

public class Worker<T extends Event> implements Observer<T> {
    private final int id;
    private final String name;

    public Worker(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void notifyObserver(Object actor, T event) {
        System.out.println(this.toString() + " Get " + event.toString() + " from " + actor.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker<?> worker = (Worker<?>) o;

        return id == worker.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
