package Ex6;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Cat extends Pet {
    public Cat(int id, int age, double weight, String color, String name, boolean isVacinated) {
        super(id, age, weight, color, name, isVacinated);
    }

    public String makeVoice(){
        return super.makeVoice() + "\n" + "Meow!";
    }
}
