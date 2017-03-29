package Ex13.animals;

import Ex13.events.Event;
import Ex13.events.EventGroom;

import java.util.Date;
import java.util.Random;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Domestic extends Animal {
    private final String name;
    private boolean isVacinated;

    public Domestic(int id) {
        super(id, false);
        this.name = "Unnamed";
    }

    public Domestic(int id, int age, double weight, String color, String name, boolean isVacinated) {
        super(id, age, weight, color);
        this.name = name;
        this.isVacinated = isVacinated;
    }

    public Domestic(int id, int age, double weight, String color, String name) {
        super(id, age, weight, color);
        this.name = name;
        this.isVacinated = false;
    }

    public void setVacinated(boolean vacinated) {
        isVacinated = vacinated;
    }

    public String getName() {
        return name;
    }

    public boolean isVacinated() {
        return isVacinated;
    }

    public String makeVoice(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.makeVoice());
        if ((this.name!=null)&&(name.length()>0)){
            builder.append(" my name is ");
            builder.append(name);
        }
        return builder.toString();
    }

    @Override
    public Event sendEvent() {
        Random random = new Random();
        switch (random.nextInt(2)){
            case 1:{
                return new EventGroom(this.getId(), new Date());
            }
            default:{
                return super.sendEvent();
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " I'm a domestic animal";
    }
}
