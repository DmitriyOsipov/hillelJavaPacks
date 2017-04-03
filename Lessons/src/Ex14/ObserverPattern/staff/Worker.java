package Ex14.ObserverPattern.staff;

import Ex14.ObserverPattern.Event;
import Ex14.ObserverPattern.Observer;

public class Worker implements Observer{
    private int id;
    private String name;
    private String post;

    public Worker(int id, String name, String post) {
        this.id = id;
        this.name = name;
        this.post = post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public void notifyObserver(Event event) {
        System.out.println(this + " react on event " + event );
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
