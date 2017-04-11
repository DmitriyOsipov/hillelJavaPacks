package Ex17;

import Ex17.ObserverPattern.Animal;
import Ex17.ObserverPattern.staff.Worker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Zoo implements Serializable{
    public static final long serialVersionUID = 201704111703L;

    private List<Worker> staff;
    private List<Animal> animals;

    public Zoo() {
        staff = new ArrayList<>();
        animals = new ArrayList<>();
    }

    public Zoo(List<Worker> staff, List<Animal> animals) {
        this.staff = staff;
        this.animals = animals;
    }

    public void addWorker(Worker worker){
        this.subscribeNewWorker(worker);
        staff.add(worker);
    }
    public void removeWorker(Worker worker){
        this.unSubscribeWorker(worker);
        staff.remove(worker);
    }

    private void subscribeNewWorker(Worker worker){
        for (Animal animal:animals){
            animal.subscribe(worker);
        }
    }

    private void unSubscribeWorker(Worker worker){
        for (Animal animal: animals){
            animal.unsubscribe(worker);
        }
    }

    public List<Worker> getStaff(){
        return staff;
    }

    public void addAnimal(Animal animal){
        this.subscribeForNewAnimal(animal);
        animals.add(animal);
    }

    public void removeAnimal(Animal animal){
        this.unSubscribeForAnimal(animal);
        animals.remove(animal);
    }

    private void subscribeForNewAnimal(Animal animal){
        for (Worker worker : staff){
            animal.subscribe(worker);
        }
    }

    private void unSubscribeForAnimal(Animal animal){
        for (Worker worker : staff){
            animal.unsubscribe(worker);
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public String getStringStaff(){
        StringBuilder builder = new StringBuilder("Our personnel:");
        builder.append(String.format("\n%13s%17s%8s", "Post", "Name", "ID"));
        builder.append(String.format("\n%40s","").replace(" ", "-"));
        for (Worker worker:staff){
            builder.append(String.format("\n%10s - %15s (id:%4d)", worker.getPost(), worker.getName(), worker.getId()));
        }
        return builder.toString();
    }

    public String getStringAnimals(){
        StringBuilder builder = new StringBuilder("Our animals:");
        builder.append(String.format("\n%4s%15s", "ID", "Type"));
        builder.append(String.format("\n%20s","").replace(" ", "-"));
        for (Animal animal:animals){
            builder.append(String.format("\n%4d %15s", animal.getId(), animal.getType()));
        }
        return builder.toString();
    }

}
