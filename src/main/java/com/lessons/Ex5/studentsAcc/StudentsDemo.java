package com.lessons.Ex5.studentsAcc;

/**
 * Created by mtzadmin on 15.02.2017.
 */
public class StudentsDemo {
    public static void main(String[] args) throws Exception {
        Person test = new Person(0, "Ivan", "Petrov", 1989, 6, 19);
        System.out.println(test.getBirthday().toString());
        System.out.println(test.getAge());
    }
}
