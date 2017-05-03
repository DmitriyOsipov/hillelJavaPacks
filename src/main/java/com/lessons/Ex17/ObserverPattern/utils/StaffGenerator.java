package com.lessons.Ex17.ObserverPattern.utils;

import com.lessons.Ex17.ObserverPattern.Animal;
import com.lessons.Ex17.ObserverPattern.staff.*;

import java.util.ArrayList;
import java.util.List;

public class StaffGenerator {
    public List<Worker> generateStaff(){
        List<Worker> staff = new ArrayList<>();
        Director director = new Director(0, "Ivanov");
        staff.add(director);
        Vet vet = new Vet(1, "Petrov");
        staff.add(vet);
        Groomer groomer = new Groomer(2, "Sidorov");
        staff.add(groomer);
        Feeder feeder = new Feeder(3, "Alekseev");
        staff.add(feeder);
        return staff;
    }

    public List<Worker> generateStaff(List<Animal> animals){
        List<Worker> staff = this.generateStaff();
        for (Animal animal:animals){
            for (Worker worker : staff){
                animal.subscribe(worker);
            }
        }
        return staff;
    }
}
