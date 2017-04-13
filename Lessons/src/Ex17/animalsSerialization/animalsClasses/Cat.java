package Ex17.animalsSerialization.animalsClasses;


/**
 * Created by Dreamer on 19.02.2017.
 */
public class Cat extends Pet {
    public static final long serialVersionUID = 2017041304L;
    public Cat() {
    }

    public Cat(int id, int age, double weight, String color, String name, boolean isVacinated) {
        super(id, age, weight, color, name, isVacinated);
    }

    public String makeVoice(){
        return super.makeVoice() + "\n" + "Meow!";
    }
}
