package Ex16.students;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Student implements CsvPrepared{
    private char csvSeparator = ';';
    private final int id;
    private String name;
    private int groupId;

    private Journal journal;


    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.journal = new Journal(this.id);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public Map<String, Double> getAverageMarks(){
        return journal.getAverageMarks();
    }

    public int getGroup() {
        return groupId;
    }

    public void setGroup(int groupId) {
        this.groupId = groupId;
    }

    public void putMark(String subject, Integer mark){
        journal.putMark(subject, mark);
    }

    public List<Integer> getMarks(String subject){
        return journal.getMarks(subject);
    }

    public Set<String> getSubjects(){
        return journal.getSubjects();
    }

    @Override
    public String getCsvString() {
        StringBuilder builder = new StringBuilder();
        String format = "%s%c%s%c%s";
        //builder.append(String.format(format, "id", csvSeparator, "name", csvSeparator, "groupId"));
        builder.append(String.format(format, this.id, csvSeparator, this.name, csvSeparator, this.groupId));
        return builder.toString();
    }

    @Override
    public void setCsvSeparator(char newSeparator) {
        this.csvSeparator = newSeparator;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("\t--Student id: %d, name: %s", id, name));
        builder.append(journal);
        return builder.toString();
    }
}
