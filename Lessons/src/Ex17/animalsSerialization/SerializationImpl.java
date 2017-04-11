package Ex17.animalsSerialization;

import Ex17.animalsSerialization.animalsClasses.Animal;

import java.io.*;
import java.util.List;

public class SerializationImpl {
    private String filesPath;
    private String dataFile;

    public SerializationImpl(String filesPath) {
            this.setFilesPath(filesPath);
        }

    public List<Animal> loadAll() throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(dataFile));
        return (List<Animal>)inputStream.readObject();
    }

    public void saveAll(List<Animal> zoo) throws Exception {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(dataFile));
        outputStream.writeObject(zoo);
    }

    public Object loadFromFile(String filename) throws Exception{
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
        return inputStream.readObject();
    }

    public void saveToFile(String filename, Serializable object) throws Exception{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
        outputStream.writeObject(object);
    }

    public void setFilesPath(String path) {
        this.filesPath = path;
        this.dataFile = filesPath + "data.dat";
    }

        public String getFilesPath() {
            return filesPath;
        }
}
