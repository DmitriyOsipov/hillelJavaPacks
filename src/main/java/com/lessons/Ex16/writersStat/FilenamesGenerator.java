package com.lessons.Ex16.writersStat;

public class FilenamesGenerator {
    public String generateConcreteOutFilename(String writerType, String outFile){
        return String.format("%s_%s%s",
                outFile.substring(0, outFile.lastIndexOf('.')),
                writerType,
                outFile.substring(outFile.lastIndexOf('.')));
    }
}
