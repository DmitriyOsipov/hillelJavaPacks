package Ex5_redone.StudentsAccounting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Group {
    private final String name;
    ArrayList<Student> group = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void add(Student newStudent){
        group.add(newStudent);
    }

    public void delete(Student student){
        group.remove(student);
    }

    public void delete(String surname){
        for (int i = 0; i< group.size(); i++){
            if (group.get(i).getSurname().equals(surname)){
                group.remove(i);
            }
        }
    }

    public ArrayList<Student> getStudents() {
        return group;
    }

    public boolean contains(Student student){
        boolean result = false;
        result = group.contains(student);
        return result;
    }

    public boolean contains(String surname){
        boolean result = false;
        for (int i = 0; ((i< group.size())&&(!result)); i++){
            if (group.get(i).getSurname().equals(surname)){
                result = true;
            }
        }
        return result;
    }

    public void clear(){
        this.group = new ArrayList<>();
    }

    public void sort(){
        boolean changed = false;
        int opInd=0;
        do{
            for (int i = 1; i< group.size()-opInd; i++){
                if (group.get(i-1).getSurname().compareToIgnoreCase(group.get(i).getSurname())<0){
                    Student tmp = group.get(i-1);
                    group.set(i-1, group.get(i));
                    group.set(i, tmp);
                    changed = true;
                }
            }
            opInd++;
        }while (changed);
    }

    public void join(Group secondGroup){
        for (Student student:secondGroup.getStudents()){
            this.group.add(student);
        }
    }

    public boolean containsAll(Group secondGroup){
        boolean result = false;
        int secondGroupSize = secondGroup.getStudents().size();

        if (this.group.size() >= secondGroupSize){
            result = true;
            List<Student> tmp = secondGroup.getStudents();
            for (int i = 0; ((i<secondGroupSize)&&(result)); i++){
                if (!this.group.contains(tmp.get(i))){
                    result = false;
                }
            }
        }

        return result;
    }

    public boolean equals(Group secondGroup){
        boolean result = false;
        int secondGroupSize = secondGroup.getStudents().size();
        if (this.group.size() == secondGroupSize){
            result = true;
            List<Student> tmp = secondGroup.getStudents();
            for (int i = 0; ((i<secondGroupSize)&&(result)); i++){
                if (!this.group.get(i).equals(tmp.get(i))){
                    result = false;
                }
            }
        }

        return result;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Group: " + this.name);
        builder.append("\nStudents:");
        if (group.size()==0){
            builder.append(" none.");
        }
        for (Student student:group){
            builder.append("\n====================================\n");
            builder.append(student.toString());
        }
        return builder.toString();
    }
}
