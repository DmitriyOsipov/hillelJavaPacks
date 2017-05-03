package com.lessons.Ex16;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Saver {
    private StringBuilder builder;

    public Saver() {
        builder = new StringBuilder();
    }

    public void appendText(String text){
        builder.append(text);
    }

    public void appendLine(String text){
        builder.append(text);
        builder.append("\n\r");
    }

    public String getText(){
        return builder.toString();
    }

    public void SaveToFile(String filename) throws IOException{
        this.SaveToFile(filename, builder.toString());
    }

    public void SaveToFile(String filename, String data) throws IOException{
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(filename));
            writer.write(data);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        finally {
            if (writer!=null){
                writer.close();
            }
        }
    }

}
