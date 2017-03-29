package Ex13;


import java.util.LinkedList;
import java.util.List;

public class Registrator<T> implements Observable<T>{
    List<Observer<T>> subs = new LinkedList<>();
    @Override
    public void subscribe(Observer<T> observer) {
        if(observer!=null){
            subs.add(observer);
        }
    }

    @Override
    public void unsubscribe(Observer<T> observer) {
        subs.remove(observer);
    }

    @Override
    public void notifySubscribers(T event) {
        for (Observer<T> observer : subs){
            observer.notify(event);
        }
    }
}
