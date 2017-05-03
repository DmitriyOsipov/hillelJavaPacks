package com.lessons.Ex17.animalsSerialization;

import com.lessons.Ex17.animalsSerialization.animalsClasses.Animal;

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

    public String getRwImplemetation() {
        return rwImplemetation.getImplementationName();
    }

    public Zoo loadAll() throws Exception{
        return rwImplemetation.loadAll(dataFile);
    }

    public void saveAll(List<Animal> zoo) throws Exception {
        rwImplemetation.saveToFile(dataFile, zoo);
    }

    public Object loadFromFile(String filename, Class objectType) throws Exception{
        return rwImplemetation.loadFromFile(filename, objectType);
    }
    public Animal loadFromFile() throws Exception{
        return (Animal)rwImplemetation.loadFromFile(dataFile, Animal.class);
    }

    public void saveToFile(String filename, Animal object) throws Exception{
        rwImplemetation.saveToFile(filename, object);
    }

    public void saveToFile(Object object) throws Exception{
        rwImplemetation.saveToFile(dataFile, object);
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
        this.dataFile = String.format("%s%s", filesPath, file);
    }

    public String getFilesPath() {
        return filesPath;
    }
}
