package com.lessons.Ex16.writersStat;

import java.io.*;

public class TextGenerator {
    public void generate(String file, String phrase, int num){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(file));
            for (int i=0; i<num; i++){
                writer.println(phrase);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if (writer!=null){
                writer.close();
            }
        }
    }
}
