package Ex17;

import Ex16.students.Group;

import java.util.List;

/**
 * Created by mtzadmin on 11.04.2017.
 */
public interface FileTransformInterface {
    public Zoo loadAll() throws Exception;
    public void saveAll(Zoo zoo) throws Exception;
    public void setFilesPath(String path);
}
