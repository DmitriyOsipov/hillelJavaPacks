package com.lessons.Ex5_redone.StudentsAccounting;

import com.lessons.Ex5_redone.ContainerInt;

import java.util.ArrayList;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Student extends Person {
    ArrayList<Subject> journal = new ArrayList<>();

    public Student(int id, String name, String surname) {
        super(id, name, surname);
    }

    public void addSubject(String newSubjectName){
        Subject newSubject = new Subject(newSubjectName);
        if (!this.journal.contains(newSubject)) {
            this.journal.add(newSubject);
        }
    }

    private int searchSubject(String subjectName){
        int id = -1;
        for (int i=0; ((i<journal.size())&&(id==-1)); i++){
            if (journal.get(i).getName().equals(subjectName)){
                id=i;
            }
        }
        return id;
    }

    public void addMark(String subject, int mark) throws Exception{
        int id = this.searchSubject(subject);
        if(id!=-1){
            this.journal.get(id).addMark(mark);
        }
        else {
            throw new Exception("Subject not found");
        }
    }

    public ContainerInt getMarks(String subject) throws Exception{
        int id = this.getId();
        ContainerInt marks = new ContainerInt();
        if(id!=-1){
            marks = this.journal.get(id).getMarks();
        }
        else {
            throw new Exception("Subject not found");
        }
        return marks;
    }

    public double getAverageMark(){
        double avg = 0;
        for (Subject subject:journal){
            avg+=subject.getAverageMark();
        }
        avg = avg/journal.size();
        return avg;
    }

    public void addSkip(String subject, String skip) throws Exception{
        int id = this.searchSubject(subject);
        if(id!=-1){
            this.journal.get(id).addSkip(skip);
        }
        else {
            throw new Exception("Subject not found");
        }
    }

    public String showSkips(String subject) throws Exception{
        int id = this.getId();
        String skips;
        if(id!=-1){
            skips = this.journal.get(id).showSkips();
        }
        else {
            skips = "";
            throw new Exception("Subject not found");
        }
        return skips;
    }
    public double getTotalSkips(){
        double result = 0;
        for (Subject subject: journal){
            result+=subject.countSkips();
        }
        return result;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("\nAverage mark: " + this.getAverageMark());
        builder.append("\nTotal skips: " + this.getTotalSkips());
        builder.append("\nSubjects:");
        for (Subject subject:journal){
            //builder.append("\n-----------------------\n");
            builder.append("\n" + subject.toString());
        }
        return builder.toString();
    }

}
