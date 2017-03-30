package Ex13.events;

import java.util.Date;

public class EventHungerWild extends EventHunger {
    public EventHungerWild(int animalId, Date time, String message) {
        super(animalId, time, message);
    }

    @Override
    public String giveMessage() {
        return super.giveMessage();
    }
}
