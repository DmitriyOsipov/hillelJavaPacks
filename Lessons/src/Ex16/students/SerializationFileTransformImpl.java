package Ex16.students;


import java.io.*;
import java.util.List;

/**
 * Created by mtzadmin on 11.04.2017.
 */
public class SerializationFileTransformImpl implements FileTransformInterface{
    private String filesPath;

    private String dataFile;

    public SerializationFileTransformImpl(String filesPath) {
        this.setFilesPath(filesPath);
    }

    @Override
    public List<Group> loadAll() throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(dataFile));
        List<Group> groups = (List<Group>)inputStream.readObject();;
        return groups;
    }

    @Override
    public void saveAll(List<Group> groupsList) throws Exception {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(dataFile));
        outputStream.writeObject(groupsList);
    }

    @Override
    public void setFilesPath(String path) {
        this.filesPath = path;
        this.dataFile = filesPath + "zoo.xml";
    }

    public String getFilesPath() {
        return filesPath;
    }
}
