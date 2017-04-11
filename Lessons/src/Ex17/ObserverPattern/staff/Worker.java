package Ex17.ObserverPattern.staff;

import Ex17.ObserverPattern.Event;
import Ex17.ObserverPattern.Observer;

import java.io.Serializable;

public class Worker implements Observer, Serializable {
    public static final long serialVersionUID = 201704111701L;
    private int id;
    private String name;
    private String post;

    public Worker(int id, String name, String post) {
        this.id = id;
        this.name = name;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
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
