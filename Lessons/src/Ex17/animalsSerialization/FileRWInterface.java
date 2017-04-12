package Ex17.animalsSerialization;

import Ex17.animalsSerialization.animalsClasses.Animal;

import java.util.List;

public interface FileRWInterface {
    public void saveToFile(String filename, Object object) throws Exception;
    //public void saveAll(List<Animal> zoo) throws Exception;
    public Object loadFromFile(String filename) throws Exception;
    public List<Animal> loadAll(String filename) throws Exception;
}
