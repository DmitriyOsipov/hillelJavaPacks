package com.lessons.Ex16.students;

import java.io.Serializable;
import java.util.*;

public class Group implements CsvPrepared, Serializable{
    public static final long serialVersionUID = 2017041101L;
    private char csvSeparator = ';';
    private int id;
    private String name;
    private Map<Integer, Student> students;
    private List<String> subjects;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        this.students = new TreeMap<>();
        this.subjects = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void setStudents(Map<Integer, Student> students) {
        this.students = students;
    }

    @Override
    public void setCsvSeparator(char csvSeparator) {
        this.csvSeparator = csvSeparator;
    }

    public void add(Student student){
        if (!students.containsKey(student.getId())){
            students.put(student.getId(), student);
            student.setGroup(this.getId());
        }
    }

    public void remove(int studentId){
        if (students.containsKey(studentId)){
            students.get(studentId).setGroup(-1);
            students.remove(studentId);
        }
    }

    public int size(){
        return students.size();
    }

    public Collection<Student> getStudents() {
        return students.values();
    }

    @Override
    public String getCsvString() {
        StringBuilder builder = new StringBuilder();
        String format = "%s%c%s%c";
        //builder.append(String.format(format, "id", csvSeparator, "name", csvSeparator));
        builder.append(String.format(format, this.id, csvSeparator, this.name, csvSeparator));
        return builder.toString();
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(String.format("\nID: %d  Name: %s", id, name));
        for (Student student: students.values()){
            builder.append("\n");
            builder.append(student);
            builder.append("\n");
        }
        return builder.toString();
    }
}
