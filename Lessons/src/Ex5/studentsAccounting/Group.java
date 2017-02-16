package Ex5.studentsAccounting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mtzadmin on 16.02.2017.
 */
public class Group {
    private ArrayList<Student> students;

    public Group(){
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents(){
        return (ArrayList<Student>)students.clone();
    }

    public String toString(){
         StringBuilder builder = new StringBuilder();
         for (Student student:this.students){
             builder.append(student.getSurname() + " " + student.getName() + "\n");
         }
         return builder.toString().trim();
    }

    public void sortStudents(){
        boolean change;
        do{
            change = false;
            for (int i=1; i<this.students.size(); i++){
                if(students.get(i-1).getSurname().compareToIgnoreCase(students.get(i).getSurname())>0){
                    Student tmp = students.get(i);
                    students.set(i, students.get(i-1));
                    students.set(i-1, tmp);
                    change = true;
                }
            }
        }while (change);

    }
    public void addStudent(Student newStudent){
        this.students.add(newStudent);
    }

    public void deleteStudent(int id){
        for (int i=0; i<this.getSize(); i++){
            if (this.students.get(i).getId() == id){
                this.students.remove(i);
                return;
            }
        }
    }

    public boolean contains(Student student){
        if (this.students.contains(student)){
            return true;
        }
        else{
            return false;
        }
    }

    public void join(Group anotherGroup){
        for (Student anotherGroupStudent: anotherGroup.students){
            this.students.add(anotherGroupStudent);
        }
    }

    public int getSize(){
        return this.students.size();
    }

    public boolean equals(Group anotherGroup){
        if (this.getSize()!=anotherGroup.getSize()){
            return false;
        }
        for (int i = 0; i < this.getSize(); i++){
            if (!this.students.get(i).equals(anotherGroup.students.get(i))){
                return false;
            }
        }
        return true;
    }

    public double getAverageMark(){
        double result=0;
        for (Student student: students){
            result+=student.getAverageMark();
        }
        return result/this.getSize();
    }

    public Student getBestStudent(){
        double[] marks = new double[this.getSize()];
        int maxInd = 0;
        for(int i=0; i<this.getSize(); i++){
            marks[i] = this.students.get(i).getAverageMark();
        }
        for (int i=1; i<this.getSize(); i++){
            if (marks[i]>marks[maxInd]){
                maxInd = i;
            }
        }
        return this.students.get(maxInd);
    }
}
