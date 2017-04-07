package Ex16.writersStat;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StatInterfImplFileReader implements StatInterface{
    @Override
    public void copy(String inFile, String outFile) throws IOException{
        FileReader reader = null;
        FileWriter writer = null;

        try{
            reader = new FileReader(inFile);
            writer = new FileWriter(outFile);
            int character;
            while ((character=reader.read())!=-1){
                writer.write(character);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (reader!=null){
                reader.close();
            }
            if (writer!=null){
                writer.close();
            }
        }
    }
}
