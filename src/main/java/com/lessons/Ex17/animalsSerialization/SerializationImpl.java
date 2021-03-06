package com.lessons.Ex17.animalsSerialization;

import java.io.*;

public class SerializationImpl implements FileRWInterface {
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

    @Override
    public Zoo loadAll(String filename) throws Exception {
        return (Zoo)(this.loadFromFile(filename, Zoo.class));
    }
}
