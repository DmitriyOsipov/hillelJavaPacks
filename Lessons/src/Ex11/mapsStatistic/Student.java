package Ex11.mapsStatistic;

import java.util.Arrays;
import java.util.Random;

public class Student {
    private final int id;
    private String name;
    private String surname;

    private int[] marks;

    public Student(int id, String name, String surname, int marksCount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    private void generateMarks(int count){
        Random random = new Random();
        marks = new int[count];
        for (int i=0; i<count; i++){
            marks[i] = random.nextInt(100);
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
