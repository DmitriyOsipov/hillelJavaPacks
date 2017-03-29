package Ex13.events;


import java.util.Date;

public abstract class Event {

    private int animalId;
    private Date time;
    private String message;

    public Event(int animalId, Date time, String message) {
        this.animalId = animalId;
        this.time = time;
        this.message = message;
    }

    public abstract String giveMessage();

    @Override
    public String toString() {
        return "{" +
                "animalId=" + animalId +
                ", time=" + time +
                ", message='" + message + '\'' +
                '}';
    }
}
