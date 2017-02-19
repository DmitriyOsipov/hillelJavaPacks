package Ex6;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class AnimalsDemo {
    public static void main(String[] args){
        Dog dog = new Dog(1, 3, 5, "Black", "Jack", true);
        System.out.println("Dog");
        System.out.println(dog.makeVoice());
        System.out.println();

        System.out.println("Fish");
        Fish fish = new Fish(0, 1, 0.5, "Silver", false);
        System.out.println(fish.makeVoice());
        System.out.println();

        System.out.println("Lion");
        Lion lion = new Lion(2, 10, 100, "Yellow");
        System.out.println(lion.makeVoice());
        System.out.println();

        System.out.println("Giraffe");
        Giraffe giraffe = new Giraffe(3, 5, 95, "Yellow");
        System.out.println(giraffe.makeVoice());
        System.out.println();

        System.out.println("Cat");
        Cat cat = new Cat(5, 2, 3.5, "White", null, false);
        System.out.println(cat.makeVoice());
        System.out.println();

        System.out.println("GuideDog");
        GuideDog guideDog = new GuideDog(10, 5, 35, "Golden", "Rex", true, false);
        System.out.println(guideDog.makeVoice());
        guideDog.takeHome();
        System.out.println();
        System.out.println("Train him");
        System.out.println();
        guideDog.setTrained(true);
        System.out.println(guideDog.makeVoice());
        guideDog.takeHome();
    }
}
