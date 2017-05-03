package com.lessons.Ex5_redone.StudentsAccounting;

import com.lessons.Ex5_redone.ContainerInt;
import java.util.ArrayList;

/**
 * Created by Dreamer on 19.02.2017.
 */

public class Subject {
    private final String name;
    private ContainerInt marks;
    private ArrayList<String> skips;

    public Subject(String name) {
        this.name = name;
        marks = new ContainerInt();
        skips = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMark(int mark){
        marks.add(mark);
    }

    public double getAverageMark(){
        return marks.getAverage();
    }

    public ContainerInt getMarks(){
        return marks.getCopy();
    }

    public void addSkip(String newSkip){
        skips.add(newSkip);
    }

    public int countSkips(){
        return skips.size();
    }

    public int countMarks(){
        return marks.getSize();
    }

    public boolean equals(Subject anotherSubject){
        if(this.name.equals(anotherSubject.getName())){
            return true;
        }
        else {
            return false;
        }
    }

    public String showSkips(){
        StringBuilder builder = new StringBuilder();
        builder.append("\n\tSkips: ");
        for (String skip:skips){
            builder.append("\n\t\t" + skip);
        }
        return builder.toString();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(name + "\tAverage mark: " + marks.getAverage());
        builder.append("\tSkipped " + this.countSkips() + " lessons.");
        builder.append("\n\tMarks: " + marks.toString());

        builder.append(this.showSkips());

        return builder.toString();
    }
}
