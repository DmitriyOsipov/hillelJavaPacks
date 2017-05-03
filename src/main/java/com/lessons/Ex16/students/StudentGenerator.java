package com.lessons.Ex16.students;


import java.util.Random;

public class StudentGenerator {

    public Group generateGroup(int id, int countStudents, int startIdStudent){
        Group group = new Group(id, String.format("Group-%d", id));
        String[] studentsNames = {"Ivanov", "Petrov", "Sidorov", "Antonov", "Burak", "Cot", "Efremov", "Gorodnij",
                "Hromov", "Ilushenko", "Klon", "Slon", "Voron", "Rudij"};
        Random random = new Random();
        for (int i=0; i<countStudents; i++){
            int nameId = Math.abs(random.nextInt())%(studentsNames.length-1);
            Student student = new Student(startIdStudent+i, studentsNames[nameId]);
            student.setJournal(this.generateJournal(student.getId()));
            group.add(student);
        }
        return group;
    }

    public Journal generateJournal(int studentId){
        Journal journal = new Journal(studentId);
        String[] subjects = {"Math", "Physics", "English", "Programming", "Philosophy", "Literature",
                            "Ukrainian", "Russian", "Biology", "Geography", "Chemistry", "Algorithms",
                            "Ecology", "Circuit Design", "Electrical Engineering", "Discrete Math"};
        Random random = new Random();
        int countMarks = 20 + Math.abs(random.nextInt(20));
        for (int i=0; i<countMarks; i++){
            int subjId = Math.abs(random.nextInt())%(subjects.length - 1);
            journal.putMark(subjects[subjId], Math.abs(random.nextInt(101)));
        }
        return journal;
    }

}
