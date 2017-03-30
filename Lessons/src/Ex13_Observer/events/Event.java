package Ex13_Observer.events;

import java.util.Date;

public abstract class Event {
    private int actorId;
    private Date date;
    private String message;

    public Event(int actorId, String message) {
        this.actorId = actorId;
        this.date = new Date();
        this.message = message;
    }

    @Override
    public String toString() {
        return "Event{" +
                "actorId=" + actorId +
                ", date=" + date +
                ", message='" + message + '\'' +
                '}';
    }
}
