package Ex16.students;


import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.Map;

public class ReportsBuilder {
    public String getAverageMarks(Group group){
        StringBuilder result = new StringBuilder(String.format("Average marks in group %s\n\n", group.getId()));

        //ArrayList<StringBuilder> studentsLines = new ArrayList<>();
        ArrayList<String> studentsLines = new ArrayList<>();
        HashSet<String> subjects = new HashSet<>();
        ArrayList<Map<String, Double>> avgMarks = new ArrayList<>();
        for (Student student : group.getStudents()){
            subjects.addAll(student.getSubjects());
            avgMarks.add(student.getAverageMarks());
            //studentsLines.add(new StringBuilder(String.format("|%3d-%12s", student.getId(), student.getName())));
            studentsLines.add(String.format("|%3d-%12s|", student.getId(), student.getName()));
        }

        result.append(String.format("|%16s|", "Student Name"));
        for (String subject : subjects){
            result.append(String.format("%15s|", subject));
            for (int i=0; i<studentsLines.size(); i++){
                //Double avgMark = (avgMarks.get(i).containsKey(subject)) ? avgMarks.get(i).get(subject):Double.valueof(0);
                //String mark = String.format("%5.5f", avgMark);
                String mark = (avgMarks.get(i).containsKey(subject)) ? String.format("%5.5f",avgMarks.get(i).get(subject)):"";
                studentsLines.set(i, studentsLines.get(i).concat(String.format("%15s|",mark)));
                //studentsLines.get(i).append(mark);//concat(String.format("", mark));
            }
        }
        int symbCount = (subjects.size()+1)*16;
        String borderLine = String.format("\n|%"+symbCount+"s|","").replace(' ','-');

        for (String line : studentsLines){
            result.append(borderLine);
            result.append("\n");
            result.append(line);
        }

        return result.toString();
    }
}
