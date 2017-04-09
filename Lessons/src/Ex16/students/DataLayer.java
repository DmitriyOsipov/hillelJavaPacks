package Ex16.students;

import Ex16.Loader;
import Ex16.Saver;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataLayer {
    public void saveToCsv(String filename, CsvPrepared object) throws IOException{
        Saver saver = new Saver();
        saver.SaveToFile(filename, object.getCsvString());
    }

    private Map<Integer, Journal> loadJournal(String filename, char csvSeparator) throws IOException{
        Loader loader = new Loader();
        List<String> strings = loader.load(filename);

        Map<Integer, Journal> journals = new TreeMap<>();
        for (int i=1; i<strings.size(); i++){
            String[] line = strings.get(i).split(String.valueOf(csvSeparator));
            if (line.length>2){
                Integer studentId = Integer.valueOf(line[0]);
                if (!journals.containsKey(studentId))
                {
                    journals.put(studentId, new Journal(studentId));
                }
                String subject = line[1];
                for (int j = 2; j<line.length; j++) {
                    journals.get(studentId).putMark(subject, Integer.valueOf(line[j]));
                }
            }
        }
        return journals;
    }

    private Map<Integer, List<Student>> loadStudents(String filename, char csvSeparator) throws IOException{
        Map<Integer, List<Student>> studentsMap = new TreeMap<>();
        Loader loader = new Loader();
        List<String> strings =  loader.load(filename);

        for (int i=1; i<strings.size(); i++){
            String[] line = strings.get(i).split(String.valueOf(csvSeparator));
            int groupId = (line.length>=3) ? Integer.valueOf(line[2]): -1;
            if (line.length>=2){
                Student student = new Student(Integer.valueOf(line[0]), line[1]);
                student.setGroup(groupId);
                if (!studentsMap.containsKey(groupId)){
                    studentsMap.put(groupId, new LinkedList<>());
                }
                studentsMap.get(groupId).add(student);
            }
        }
        return studentsMap;
    }

    private List<Group> loadGroup(String filename, char csvSeparator) throws IOException{
        List<Group> groups = new LinkedList<>();
        Loader loader = new Loader();
        List<String> strings = loader.load(filename);

        for (int i=1; i<strings.size(); i++){
            String[] line = strings.get(i).split(String.valueOf(csvSeparator));
            if (line.length>=2){
                Group group = new Group(Integer.valueOf(line[0]), line[1]);
                groups.add(group);
            }
        }
        return groups;
    }

    public List<Group> loadAll(String groupFile, String studentsFile, String journalFile, char csvSeparator) throws IOException{
        List<Group> groups = this.loadGroup(groupFile, csvSeparator);
        Map<Integer, List<Student>> students = this.loadStudents(studentsFile, csvSeparator);
        Map<Integer, Journal> journals = this.loadJournal(journalFile, csvSeparator);

        students = this.inserJournals(students, journals);
        groups = this.insertStuds(groups, students);

        return groups;
    }

    private List<Group> insertStuds(List<Group> groups, Map<Integer, List<Student>> students){
        for (Group group: groups){
            List<Student> studentsInGroup = students.get(group.getId());
            Map<Integer, Student> studs = new TreeMap<>();
            for (Student student: studentsInGroup){
                studs.put(student.getId(), student);
            }
            group.setStudents(studs);
        }

        return groups;
    }

    private Map<Integer, List<Student>> inserJournals(Map<Integer, List<Student>> students, Map<Integer, Journal> journals){
        for(List<Student> studentsList : students.values()){
            for(Student student: studentsList){
                student.setJournal(journals.get(student.getId()));
            }
        }
        return students;
    }
}
