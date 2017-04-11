package Ex17.ObserverPattern.staff;


import Ex17.ObserverPattern.Event;

public class Groomer extends Worker {
    public Groomer(int id, String name) {
        super(id, name, "Groomer");
    }

    @Override
    public void notifyObserver(Event event) {
        if (event.getEventType().equals(Event.EventType.EVENT_GROOM)){
            System.out.println(this + " react on event " + event );
        }
    }
}
