package Ex16.writersStat;

import java.io.*;

public class StatInterfImplPrintWriter implements StatInterface{
    @Override
    public void copy(String inFile, String outFile) throws IOException {
        BufferedReader reader = null;
        PrintWriter writer = null;

        try{
            reader = new BufferedReader(new FileReader(inFile));
            writer = new PrintWriter(new FileWriter(outFile));
            String s;
            while ((s = reader.readLine())!=null){
                writer.println(s);
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
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
