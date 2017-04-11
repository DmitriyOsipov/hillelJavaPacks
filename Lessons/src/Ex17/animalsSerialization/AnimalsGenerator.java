package Ex17.animalsSerialization;

import Ex17.animalsSerialization.animalsClasses.*;

import java.util.ArrayList;
import java.util.List;

public class AnimalsGenerator {
    public List<Animal> generateAnimals(){
        List<Animal> animalList = new ArrayList<>();
        int i=0;
        Animal cat = new Cat(i++, 5, 3, "White", "Barsik", true);
        animalList.add(cat);
        Animal croc = new Crocodile(i++, 15, 305, "Green");
        animalList.add(croc);
        Animal dog = new Dog(i++, 7, 25, "Red", "Rex", true);
        animalList.add(dog);
        Animal fish = new Fish(i++, 1, 0.1, "Gold", false);
        animalList.add(fish);
        Animal giraffe = new Giraffe(i++, 10, 200, "Dotted");
        animalList.add(giraffe);
        Animal guideDog = new GuideDog(i++, 5, 45, "White", "Sam", true, true);
        animalList.add(guideDog);
        Animal hamster = new Hamster(i++, 1, 0.3, "Black", "Jerry", false);
        animalList.add(hamster);
        Animal lion = new Lion(i++, 3, 150, "Yellow");
        animalList.add(lion);
        Animal wolf = new Wolf(i++, 2, 30, "Grey");
        animalList.add(wolf);

        return animalList;
    }
}
