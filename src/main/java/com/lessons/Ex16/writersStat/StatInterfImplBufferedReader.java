package com.lessons.Ex16.writersStat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StatInterfImplBufferedReader implements StatInterface {
    @Override
    public void doOperation(String inFile, String outFile) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inFile));
            while (reader.readLine()!=null){
            }
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
