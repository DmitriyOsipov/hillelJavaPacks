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
        Object res =  mapper.readValue(new File(filename), Animal.class);
        return res;
    }

    @Override
    public Zoo loadAll(String filename) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Zoo loaded = mapper.readValue(new File(filename), Zoo.class);
        return loaded;
    }

    /*
    @Override
    public List<Animal> loadAll(String filename) throws Exception {
        List<Animal> animalList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        animalList = mapper.readValue(new File(filename), animalList.getClass());
        return animalList;
    }
/*
    private String jsonListWrite(List<Animal> animalList) throws Exception{
        StringBuilder builder = new StringBuilder("[");
        for (Animal animal : animalList){
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writerFor(animal.getClass());
            builder.append(String.format("\n%s,",writer.writeValueAsString(animal)));
        }
        builder.append("]");
        return builder.toString().replace(",]", "\n]");
    }

    private void saveJson(String filename, String data) throws IOException{
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            writer.write(data);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (writer!=null){
                writer.close();
            }
        }
    }
//*/

}
