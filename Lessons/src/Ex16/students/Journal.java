package Ex16.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Journal implements CsvPrepared{
    private char csvSeparator = ';';
    private final int studentId;

    private Map<String, List<Integer>> journal;

    public Journal(int studentId) {
        this.studentId = studentId;
        this. journal = new TreeMap<>();
    }

    public int getStudentId() {
        return studentId;
    }


    public Map<String, List<Integer>> getJournal() {
        return journal;
    }

    public Map<String, Double> getAverageMarks(){
        Map<String, Double> avgMarks = new TreeMap<>();
        for (Map.Entry<String, List<Integer>> subject: journal.entrySet()){
            avgMarks.put(subject.getKey(), getAverage(subject.getValue()));
        }
        return avgMarks;
    }

    private double getAverage(List<Integer> list){
        double total = 0;
        for (Integer num : list){
            total+=num;
        }
        return total/list.size();
    }

    public void putMark(String subject, int mark){
        if (!journal.containsKey(subject)){
            journal.put(subject, new ArrayList<>());
        }
        journal.get(subject).add(mark);
    }

    public List<Integer> getMarks(String subject){
        return journal.get(subject);
    }

    @Override
    public String getCsvString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s%c%s", "studentId", csvSeparator, "Subject"));
        for (Map.Entry<String, List<Integer>> subject : journal.entrySet()){
            builder.append(String.format("\n%s%c%s", this.studentId, csvSeparator, subject.getKey(), csvSeparator));
            for (Integer mark : subject.getValue()){
                builder.append(String.format("%c%s", csvSeparator, mark));
            }
        }

        return builder.toString();
    }

    @Override
    public void setCsvSeparator(char newSeparator) {
        this.csvSeparator = newSeparator;
    }
}
