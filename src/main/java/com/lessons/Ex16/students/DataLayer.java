package com.lessons.Ex16.students;


import java.util.List;


public class DataLayer implements FileTransformInterface{
    private String filesPath = "Lessons\\src\\Ex16\\students\\files\\";
    FileTransformInterface fileTransformImpl;

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
    public List<Group> loadAll() throws Exception {
        fileTransformImpl.setFilesPath(filesPath);
        return fileTransformImpl.loadAll();
    }

    @Override
    public void saveAll(List<Group> groupsList) throws Exception {
        fileTransformImpl.setFilesPath(filesPath);
        fileTransformImpl.saveAll(groupsList);
    }
}
