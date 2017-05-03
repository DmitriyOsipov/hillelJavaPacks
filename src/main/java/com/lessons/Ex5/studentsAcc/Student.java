package com.lessons.Ex5.studentsAcc;

import java.util.HashMap;

/**
 * Created by mtzadmin on 15.02.2017.
 */
public class Student extends Person {
    private HashMap<String, Subject> disciplines;

    public Student(int id, String name, String surname, int year, int birthMonth, int birthDay){
        super(id, name, surname, year, birthMonth, birthDay);
        disciplines = new HashMap<>();
    }

    public void addDiscipline(String name){
        this.disciplines.put(name, new Subject(name, Subject.Status.STUDYING));
    }

    public double getAverageMark(String disciplineName){
        double result = 0;
        if ((disciplineName == null)||(disciplineName.length()==0)) {
            for (Subject subject: disciplines.values()){
                result+=subject.getAverageMark();
            }
            result = result/disciplines.values().size();
        }
        else {
            result = disciplines.get(disciplineName).getAverageMark();
        }
        return result;
    }

    public String getSkipsToString(){
        StringBuilder stringBuilder = new StringBuilder();

        for (Subject subject: disciplines.values()){
            if (subject.getStatus() == Subject.Status.STUDYING){
                stringBuilder.append(subject.getName() + "\n");
                stringBuilder.append(subject.skipsToString() + "\n");
            }
        }

        return stringBuilder.toString();
    }
}
