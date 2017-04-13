package Ex17.animalsSerialization.animalsClasses;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Hamster extends Pet {
    public static final long serialVersionUID = 2017041310L;
    public Hamster() {
    }

    public Hamster(int id, int age, double weight, String color, String name, boolean isVacinated) {
        super(id, age, weight, color, name, isVacinated);
    }
}
