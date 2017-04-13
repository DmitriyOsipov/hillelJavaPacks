package Ex17.animalsSerialization;


public interface FileRWInterface {
    public String getImplementationName();
    public void saveToFile(String filename, Object object) throws Exception;
    //public void saveAll(List<Animal> zoo) throws Exception;
    public Object loadFromFile(String filename, Class objectClass) throws Exception;
    //public List<Animal> loadAll(String filename) throws Exception;
    public Zoo loadAll(String filename) throws Exception;
}
