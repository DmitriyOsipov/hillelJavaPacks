package Ex13.events;

import java.util.Date;


public class EventHungerDomestic extends EventHunger{
    public EventHungerDomestic(int animalId, Date time, String message) {
        super(animalId, time, message);
    }

    @Override
    public String giveMessage() {
        return super.giveMessage();
    }
}
