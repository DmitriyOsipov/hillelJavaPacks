package Ex16.writersStat;

import java.io.IOException;

import java.util.Map;
import java.util.TreeMap;

public class StatCollector {
    private String inFile;
    private String outFile;
    private Map<String, Long> stat;
    private StatInterface statInterfaceImpl;

    public StatCollector(String inFile, String outFile){
        this.inFile = inFile;
        this.outFile = outFile;
        this.stat = new TreeMap<>();
    }

    public void setStatInterfaceImpl(StatInterface statInterfaceImpl) {
        this.statInterfaceImpl = statInterfaceImpl;
    }

    public void collectStat(String type) throws IOException{
        long start;
        long end;
        FilenamesGenerator filenamesGenerator = new FilenamesGenerator();
        String concreteOutFile = filenamesGenerator.generateConcreteOutFilename(type, outFile);

        start = System.currentTimeMillis();
        statInterfaceImpl.copy(inFile, concreteOutFile);
        end = System.currentTimeMillis();

        stat.put(type, (end-start));
    }

    public String getStatSplitted(char splitter){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s%c%s", "Writer name", splitter, "time, ms"));
        for (Map.Entry<String, Long> entry : stat.entrySet()){
            builder.append(String.format("\n%s%c%d", entry.getKey(), splitter, entry.getValue()));
        }
        return builder.toString();
    }

    public String getStatTab(){
        String borderLine = "\n"+String.format("+%15s+%15s+","","").replace(' ','-');
        StringBuilder builder = new StringBuilder(borderLine);
        builder.append(String.format("\n|%s|%s|", addLeft("Writer name"), addLeft("time, ms")));
        for (Map.Entry<String, Long> entry : stat.entrySet()){
            builder.append(borderLine);
            builder.append(String.format("\n|%s|%s|", addLeft(entry.getKey()), addLeft(entry.getValue())));
        }
        builder.append(borderLine);
        return builder.toString();
    }

    private static String addLeft(Object str){
        return String.format("%15s", str.toString());
    }
}
