package com.lessons.Ex5.studentsAcc;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by mtzadmin on 15.02.2017.
 */
public class Skip {
    enum Tag {SKIP_ALL, SKIP_HALF, LATE;};

    private GregorianCalendar date;
    private String description;
    private Tag tag;

    public Skip(GregorianCalendar date, String description, Tag tag) {
        this.date = date;
        this.description = description;
        this.tag = tag;
    }

    public Skip(int year, int month, int day, String description, Tag tag){
        this.date = new GregorianCalendar(year, month, day);
        this.description = description;
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    public String tagToString(){
        String result;
        switch (tag){
            case LATE:{
                result = ("Late for a lecture.");
            }break;
            case SKIP_HALF:{
                result = ("Skipped the half of the class.");
            }break;
            case SKIP_ALL:{
                result =  ("Skipped the class.");
            }break;
            default:result =  ("No info.");
        }
        return result;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%2d", this.date.get(Calendar.DATE)).replace(' ','0') + "."
                + String.format("%2d" , this.date.get(Calendar.MONTH)).replace(' ','0') + "."
                + this.date.get(Calendar.YEAR));
        builder.append("\t");
        builder.append(this.tagToString());
        builder.append("\t");
        builder.append(description);
        return builder.toString();
    }
}
