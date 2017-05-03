package com.lessons.Ex16.writersStat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StatInterfImplFileWriter implements StatInterface {
    @Override
    public void doOperation(String inFile, String outFile) throws IOException{
        BufferedReader reader = null;
        FileWriter writer = null;

        try{
            reader = new BufferedReader(new FileReader(inFile));
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
