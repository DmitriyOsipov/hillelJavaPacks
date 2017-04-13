package Ex17.animalsSerialization;

import Ex17.animalsSerialization.animalsClasses.Animal;
import Ex17.animalsSerialization.animalsClasses.Cat;
import Ex17.animalsSerialization.animalsClasses.Pet;
import Ex17.animalsSerialization.animalsClasses.WildAnimal;

import java.io.PrintStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        String filesPath = "Lessons\\src\\Ex17\\animalsSerialization\\files\\";
        setOutStream(filesPath);

        System.out.println("Demonstration with one animal");
        System.out.println("================================================");
        runAnimal(filesPath);
        System.out.println("================================================");

        System.out.println();

        System.out.println("Demonstration with Zoo");
        System.out.println("================================================");
        runZoo(filesPath);
        System.out.println("================================================");
    }

    private static void setOutStream(String path) throws Exception{
        String filename = String.format("%s%s",path, "console.txt");
        PrintStream outputStream = new PrintStream(filename);
        System.setOut(outputStream);
    }

    private static FileRWInterface setRWImplement(){
        //return new SerializationImpl();
        return new JacksonSerialization();
        //return new XmlSerialization();
    }

    private static void runZoo(String filesPath) throws Exception{
        DataLayer dataLayer = new DataLayer(filesPath);
        dataLayer.setRwImplemetation(setRWImplement());
        System.out.println(String.format("Serialization implementation: %s", dataLayer.getRwImplemetation()));
        System.out.println();

        AnimalsGenerator animalsGenerator = new AnimalsGenerator();
        Zoo zoo = new Zoo(animalsGenerator.generateAnimals());
        System.out.println("Generated animals:");
        System.out.println(zoo.printAnimals());

        System.out.println("-------------------");

        dataLayer.saveToFile(zoo);

        Zoo zoo2;
        zoo2 = dataLayer.loadAll();
        System.out.println("Loaded animals:");
        System.out.println(zoo2.printAnimals());
        System.out.println("---------------");
    }

    private static void runAnimal(String filesPath) throws Exception{
        DataLayer dataLayer = new DataLayer(filesPath);
        dataLayer.setRwImplemetation(setRWImplement());
        System.out.println(String.format("Serialization implementation: %s", dataLayer.getRwImplemetation()));
        System.out.println();

        Cat testAnimal = new Cat(123, 155, 50, "Black", "Behemoth", false);
        String filename = String.format("%s.dat", testAnimal.getClass().getSimpleName());
        System.out.println("Test animal");
        System.out.println(Zoo.printAnimal(testAnimal));
        dataLayer.setFile(filename);
        dataLayer.saveToFile(testAnimal);

        System.out.println("Load test animal:");
        Animal testAnimal2 = dataLayer.loadFromFile();
        System.out.println(Zoo.printAnimal(testAnimal2));
    }
}
