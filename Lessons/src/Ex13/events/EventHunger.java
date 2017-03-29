package Ex13.events;


import java.util.Date;

public class EventHunger extends Event{
    public EventHunger(int animalId, Date time, String message) {
        super(animalId, time, message);
    }

    @Override
    public String giveMessage() {
        return "I'm hunger! " + super.toString();
    }


}
