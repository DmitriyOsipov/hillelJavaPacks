package Ex17.animalsSerialization.animalsClasses;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Giraffe extends WildAnimal {
    public static final long serialVersionUID = 2017041308L;
    public Giraffe() {
    }

    public Giraffe(int id, int age, double weight, String color) {
        super(id, age, weight, color, false);
    }
}
