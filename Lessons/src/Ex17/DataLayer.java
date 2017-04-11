package Ex17;

public class DataLayer implements FileTransformInterface {
    private String filesPath = "Lessons\\src\\Ex17\\files\\";
    FileTransformInterface fileTransformImpl;

    public DataLayer() {
    }

    public DataLayer(FileTransformInterface fileTransformImpl) {
        this.fileTransformImpl = fileTransformImpl;
    }

    public FileTransformInterface getFileTransformImpl() {
        return fileTransformImpl;
    }

    public void setFileTransformImpl(FileTransformInterface fileTransformImpl) {
        this.fileTransformImpl = fileTransformImpl;
    }

    public String getFilesPath() {
        return filesPath;
    }

    @Override
    public void setFilesPath(String path) {
        this.filesPath = path;
    }

    @Override
    public Zoo loadAll() throws Exception {
        fileTransformImpl.setFilesPath(filesPath);
        return fileTransformImpl.loadAll();
    }

    @Override
    public void saveAll(Zoo zoo) throws Exception {
        fileTransformImpl.setFilesPath(filesPath);
        fileTransformImpl.saveAll(zoo);
    }
}
