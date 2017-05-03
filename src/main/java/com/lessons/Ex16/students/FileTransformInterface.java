package com.lessons.Ex16.students;

import java.util.List;

/**
 * Created by mtzadmin on 11.04.2017.
 */
public interface FileTransformInterface {
    public List<Group> loadAll() throws Exception;
    public void saveAll(List<Group> groupsList) throws Exception;
    public void setFilesPath(String path);
}
