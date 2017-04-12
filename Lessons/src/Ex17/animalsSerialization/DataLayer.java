package Ex17.animalsSerialization;

import Ex17.animalsSerialization.animalsClasses.Animal;

import java.io.*;
import java.util.List;

public class DataLayer {
    private String filesPath = "Lessons\\src\\Ex17\\animalsSerialization\\files\\";
    private String file = "data.dat";
    private String dataFile;

    private FileRWInterface rwImplemetation;

    public DataLayer(String filesPath) {
        this.setFilesPath(filesPath);
    }

    public void setRwImplemetation(FileRWInterface rwImplemetation) {
        this.rwImplemetation = rwImplemetation;
    }

    public List<Animal> loadAll() throws Exception {
        return rwImplemetation.loadAll(dataFile);
    }

    public void saveAll(List<Animal> zoo) throws Exception {
        rwImplemetation.saveToFile(dataFile, zoo);
    }

    public Animal loadFromFile(String filename, Class<? extends Animal> animalType) throws Exception{
        Animal loaded = animalType.cast(rwImplemetation.loadFromFile(filename));
        return loaded;
    }

    public void saveToFile(String filename, Animal object) throws Exception{
        rwImplemetation.saveToFile(filename, object);
    }

    public void setFilesPath(String path) {
        this.filesPath = path;
        this.dataFile = String.format("%s%s", filesPath, file);
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
        this.dataFile = String.format("%s%s", filesPath, dataFile);
    }

    public String getFilesPath() {
        return filesPath;
    }
}
