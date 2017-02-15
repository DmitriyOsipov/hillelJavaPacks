package Ex5.studentsAcc;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by mtzadmin on 15.02.2017.
 */
public class Person {
    private final long mSecAtDay = 1000*60*60*24;//86400000L;
    private final long mSecAtYear = mSecAtDay*365;//31536000000L;

    private int id;
    private String name;
    private String surname;
    private GregorianCalendar birthday;

    public Person(int id, String name, String surname, int birthYear, int birthMonth, int birthDay) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = parseBirthday(birthYear, birthMonth, birthDay);
    }

    private GregorianCalendar parseBirthday(int year, int month, int day){

        return new GregorianCalendar(year, month, day);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge(){
        int result = 0;
        GregorianCalendar today = new GregorianCalendar();
        long ageMsec = today.getTimeInMillis() - this.birthday.getTimeInMillis();
        double years = ageMsec/mSecAtYear;
        double age = (ageMsec - Math.round(years/4)*mSecAtDay)/mSecAtYear;
        age = Math.round(age - age%1);
        result = (int)age;

        return result;
    }

    public String getBirthday(){
        String res = String.format("%2d", this.birthday.get(Calendar.DATE)).replace(' ','0') + "."
                    + String.format("%2d" , this.birthday.get(Calendar.MONTH)).replace(' ','0') + "."
                    + this.birthday.get(Calendar.YEAR);
        return res;
    }
}
