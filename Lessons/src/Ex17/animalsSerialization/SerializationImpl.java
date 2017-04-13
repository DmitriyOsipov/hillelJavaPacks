package Ex17.animalsSerialization;

import Ex17.animalsSerialization.animalsClasses.Animal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationImpl implements FileRWInterface{
    @Override
    public String getImplementationName() {
        return "Standard java object serialization (ObjectOutputStream)";
    }

    @Override
    public void saveToFile(String filename, Object object) throws Exception {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
        outputStream.writeObject(object);
    }

    @Override
    public Object loadFromFile(String filename, Class object) throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
        return inputStream.readObject();
    }

    /*
    @Override
    public List<Animal> loadAll(String filename) throws Exception {
        return (List<Animal>)this.loadFromFile(filename, new ArrayList<Animal>().getClass());
    }
//*/
    @Override
    public Zoo loadAll(String filename) throws Exception {
        return (Zoo)(this.loadFromFile(filename, new ArrayList<Animal>().getClass()));
    }
}
