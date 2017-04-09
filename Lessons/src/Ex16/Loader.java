package Ex16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Loader {
    public List<String> load(String filename) throws IOException{
        BufferedReader reader = null;
        List<String> result = new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(filename));
            String s;
            while ((s =reader.readLine())!=null){
                result.add(s);
            }
        }
        catch (IOException e){
            e.printStackTrace();
            throw e;
        }
        finally {
            if (reader!=null){
                reader.close();
            }
        }
        return result;
    }
}
