package Ex16.writersStat;

import java.io.*;

public class StatInterfImplBufferedReader implements StatInterface {
    @Override
    public void copy(String inFile, String outFile) throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inFile));
            writer = new BufferedWriter(new FileWriter(outFile));
            String s;
            while ((s = reader.readLine())!=null){
                writer.write(s);
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
