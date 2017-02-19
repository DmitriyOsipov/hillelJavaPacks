package Ex5_redone.StudentsAccounting;

/**
 * Created by Dreamer on 19.02.2017.
 */

public class Person {
    private final int id;
    private String name;
    private String surname;

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean equals(Person anotherPerson){
        if (this.id == anotherPerson.id){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append("ID: " + this.id);
        builder.append("\n" + this.surname + " " + this.name);

        return builder.toString();
    }
}
