package Ex16.writersStat;

import java.io.File;
import java.io.IOException;

import java.util.Map;
import java.util.TreeMap;

public class StatCollector {
    private String inFile;
    private String outFile;
    private Map<String, StatInfo> stat;
    private StatInterface statInterfaceImpl;
    private File inFileInfo;

    public StatCollector(String inFile, String outFile){
        this.inFile = inFile;
        this.outFile = outFile;
        this.stat = new TreeMap<>();
        inFileInfo = new File(inFile);
    }

    public void setStatInterfaceImpl(StatInterface statInterfaceImpl) {
        this.statInterfaceImpl = statInterfaceImpl;
    }

    public void collectStat(String type) throws IOException{
        long start;
        long end;
        StatInfo statInfo;

        FilenamesGenerator filenamesGenerator = new FilenamesGenerator();
        String concreteOutFile = filenamesGenerator.generateConcreteOutFilename(type, outFile);

        start = System.currentTimeMillis();
        statInterfaceImpl.doOperation(inFile, concreteOutFile);
        end = System.currentTimeMillis();

        statInfo = new StatInfo(inFileInfo.getName(), inFileInfo.length(), end-start);
        stat.put(type, statInfo);
    }

    public String getStatSplitted(char splitter){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s%c%s%c%s%c%s%c%s", "Writer name", splitter, "fileName", splitter,"fileSize, Mb",
                splitter, "Remained Time, s", splitter, "Speed, Mb/s"));
        for (Map.Entry<String, StatInfo> entry : stat.entrySet()){
            StatInfo sI = entry.getValue();
            builder.append(String.format("\n%s%c%s%c%5.5f%c%5.5f%c%5.5f", entry.getKey(), splitter, sI.getFileName(),
                    splitter, sI.getFileSizeMBytes(), splitter, sI.getRemainedTimeSec(), splitter, sI.getSpeed()));
        }
        return builder.toString();
    }

    public String getStatTab(){
        String borderLine = "\n"+String.format("+%15s+%15s+%15s+%15s+%15s+","","","","","").replace(' ','-');
        StringBuilder builder = new StringBuilder(borderLine);
        builder.append(String.format("\n|%s|%s|%s|%s|%s|", addLeft("Writer name"),
                addLeft("fileName"),
                addLeft("fileSize, Mb"), addLeft("time, s"), addLeft("speed, Mb/s")));
        for (Map.Entry<String, StatInfo> entry : stat.entrySet()){
            StatInfo sI = entry.getValue();
            builder.append(borderLine);
            builder.append(String.format("\n|%s|%s|%s|%s|%s|", addLeft(entry.getKey()), addLeft(sI.getFileName()),
                    addLeft(String.format("%5.5f",sI.getFileSizeMBytes())),
                    addLeft(String.format("%5.5f", sI.getRemainedTimeSec())),
                    addLeft(String.format("%5.5f", sI.getSpeedMbPS()))));
           // builder.append(String.format("\n|%s|%s|", addLeft(entry.getKey()), addLeft(entry.getValue())));
        }
        builder.append(borderLine);
        return builder.toString();
    }

    private static String addLeft(Object str){
        return String.format("%15s", str.toString());
    }
    private static String addLeft(int num, Object str){
        return String.format("%" + num + "s", str.toString());
    }
}
