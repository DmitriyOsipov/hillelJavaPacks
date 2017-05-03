package com.lessons.Ex5.studentsAccounting;

import java.util.HashMap;

/**
 * Created by mtzadmin on 16.02.2017.
 */
public class Student extends Person {
    private HashMap<String, Subject> disciplines;

    public Student(int id, String name, String surname, int year, int birthMonth, int birthDay){
        super(id, name, surname, year, birthMonth, birthDay);
        disciplines = new HashMap<>();
    }

    public double getAverageMark(){
        double result=0;

        return result;
    }
}
