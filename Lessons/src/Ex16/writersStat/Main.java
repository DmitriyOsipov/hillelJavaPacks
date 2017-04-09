package Ex16.writersStat;


import Ex16.Saver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        String inFile = "Lessons\\src\\Ex16\\genText.txt";
        String outFile = "Lessons\\src\\Ex16\\out.txt";
        String statResultFile = "Lessons\\src\\Ex16\\statResult.csv";

        generateTextFile(inFile);
        Map<String, StatInterface> writers = generateWriters();
        StatCollector statCollector = getStatistic(inFile, outFile, writers);

        String fileData = getFileData(inFile);
        System.out.println("Input file:");
        System.out.println(fileData);
        System.out.println("-----------");

        String writersFilesInfo = getWriterFilesData(writers, outFile);
        System.out.println(writersFilesInfo);
        System.out.println(statCollector.getStatTab());

        Saver saver = new Saver();
        saver.appendText(fileData);
        saver.appendText(statCollector.getStatSplitted(';'));
        saver.SaveToFile(statResultFile);

        Saver saver2 = new Saver();
        saver2.appendText(fileData);
        saver2.appendText(writersFilesInfo);
        saver2.appendText(statCollector.getStatTab());
        saver2.SaveToFile(outFile);
    }

    private static void generateTextFile(String filename){
        TextGenerator textGenerator = new TextGenerator();
        textGenerator.generate(filename,
                "Fifteen men on the dead man's chest—\n  ...Yo-ho-ho, and a bottle of rum!\nDrink and the devil had done for the rest—\n  ...Yo-ho-ho, and a bottle of rum!\n\n",
                500_000);
    }

    private static String getFileData(String filename) throws IOException{
        File file = new File(filename);
        boolean isExist = file.exists();
        StringBuilder fileData = new StringBuilder();
        if (isExist){
            fileData.append("Out file exists\n");
            fileData.append(String.format("Full path:%s\n", file.getCanonicalPath()));
            fileData.append(String.format("Size: %d bytes\n", file.getTotalSpace()));
        }
        else {
            fileData.append("Out file doesn't exist");
        }

        return fileData.toString();
    }

    private static String getWriterFilesData(Map<String, StatInterface> writers, String outFile) throws IOException{
        FilenamesGenerator filenamesGenerator = new FilenamesGenerator();
        StringBuilder builder = new StringBuilder("Result files:");
        for(String writerType : writers.keySet()){
            builder.append(String.format("\n--------\n%s\n%s", writerType,
                    getFileData(filenamesGenerator.generateConcreteOutFilename(writerType, outFile))));
        }
        return builder.toString();
    }

    private static Map<String, StatInterface> generateWriters(){
        Map<String, StatInterface> writers = new HashMap<>();
        writers.put("FileReader", new StatInterfFileReader());
        writers.put("BufferedReader", new StatInterfImplBufferedReader());
        writers.put("FileWriter", new StatInterfImplFileWriter());
        writers.put("BufferedWriter", new StatInterfImplBufferedWriter());
        writers.put("PrintWriter", new StatInterfImplPrintWriter());
        return writers;
    }

    private static StatCollector getStatistic(String inFile, String outFile, Map<String, StatInterface> writers){
        StatCollector statCollector = new StatCollector(inFile, outFile);
        for (Map.Entry<String, StatInterface> entry : writers.entrySet()){
            try {
                statCollector.setStatInterfaceImpl(entry.getValue());
                statCollector.collectStat(entry.getKey());
            }
            catch (Exception e){
                System.out.println(String.format("Exception in %s.\n\t%s",entry.getKey(), e.getMessage()));
            }
        }
        return statCollector;
    }
}
