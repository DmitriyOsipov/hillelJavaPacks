package com.lessons.Ex16.writersStat;

import java.io.FileReader;
import java.io.IOException;


public class StatInterfFileReader implements StatInterface {
    @Override
    public void doOperation(String inFile, String outFile) throws IOException {
        FileReader reader = null;
        try {
            reader = new FileReader(inFile);
            while (reader.read()!=-1){}
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (reader!=null){
                reader.close();
            }
        }
    }
}
