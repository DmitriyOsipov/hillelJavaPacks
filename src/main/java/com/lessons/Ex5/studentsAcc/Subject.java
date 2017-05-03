package com.lessons.Ex5.studentsAcc;

import com.lessons.Ex5.ContainerInt;

import java.util.*;

/**
 * Created by mtzadmin on 15.02.2017.
 */
public class Subject {
    enum Status {FINISHED, STUDYING }

    private String name;
    private Status status;
    private ContainerInt marks;
    private ArrayList<Skip> skips;

    public Subject(String name, Status status) {
        this.name = name;
        this.status = status;
        this.marks = new ContainerInt();
        this.skips = new ArrayList<Skip>();
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addMark(int value){
        this.marks.add(value);
    }

    public double getAverageMark(){
        return marks.getAverage();
    }

    public void addSkip(GregorianCalendar date, String description, Skip.Tag tag){
        this.skips.add(new Skip(date, description, tag));
    }

    public int[] countSkips(){
        int[] result = new int[Skip.Tag.values().length];
        for (Skip lection: skips){
            for (int i=0; i<Skip.Tag.values().length; i++){
                if (lection.getTag() == Skip.Tag.values()[i]){
                    result[i]++;
                    break;
                }
            }
        }
        return result;
    }

    public String skipsToString(){
        StringBuilder builder = new StringBuilder();
        int[] skipsCounted = this.countSkips();

        for (int i=0; i<Skip.Tag.values().length; i++){
            builder.append(Skip.Tag.values()[i] + ": " + skipsCounted[i] + "\n");
        }

        for (Skip lection: skips){
            builder.append(lection.toString());
        }

        return builder.toString();
    }
}

