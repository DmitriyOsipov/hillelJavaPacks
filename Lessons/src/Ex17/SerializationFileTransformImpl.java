package Ex17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationFileTransformImpl implements FileTransformInterface {
    private String filesPath;
    private String dataFile;

    public SerializationFileTransformImpl(String filesPath) {
        this.setFilesPath(filesPath);
    }

    @Override
    public Zoo loadAll() throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(dataFile));
        return (Zoo)inputStream.readObject();
    }

    @Override
    public void saveAll(Zoo zoo) throws Exception {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(dataFile));
        outputStream.writeObject(zoo);
    }

    @Override
    public void setFilesPath(String path) {
        this.filesPath = path;
        this.dataFile = filesPath + "data.dat";
    }

    public String getFilesPath() {
        return filesPath;
    }
}
