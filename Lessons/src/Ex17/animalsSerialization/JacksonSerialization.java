package Ex17.animalsSerialization;

import Ex17.animalsSerialization.animalsClasses.Animal;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;

public class JacksonSerialization implements FileRWInterface{
    @Override
    public String getImplementationName() {
        return "Jackson Serialization to JSON(com.fasterxml.jackson)";
    }

    @Override
    public void saveToFile(String filename, Object object) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        writer.writeValue(new File(filename), object);
    }

    @Override
    public Object loadFromFile(String filename, Class objectClass) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), Animal.class);
    }

    @Override
    public Zoo loadAll(String filename) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filename), Zoo.class);
    }

}
