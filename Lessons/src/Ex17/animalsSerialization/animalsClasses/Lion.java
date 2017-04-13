package Ex17.animalsSerialization.animalsClasses;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Lion extends WildAnimal {
    public Lion() {
    }

    public Lion(int id, int age, double weight, String color) {
        super(id, age, weight, color, true);
    }
}
