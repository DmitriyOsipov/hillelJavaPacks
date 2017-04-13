package Ex17.animalsSerialization.animalsClasses;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Dog extends Pet {
    public static final long serialVersionUID = 2017041306L;
    public Dog() {
    }

    public Dog(int id, int age, double weight, String color, String name, boolean isVacinated) {
        super(id, age, weight, color, name, isVacinated);
    }

    public String makeVoice(){
        return super.makeVoice() + "\n" + "Woof!";
    }
}
