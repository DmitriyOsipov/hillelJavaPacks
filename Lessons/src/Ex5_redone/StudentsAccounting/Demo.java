package Ex5_redone.StudentsAccounting;

/**
 * Created by Dreamer on 19.02.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        System.out.println("Create new group");
        Group group1 = new Group("ABC");
        System.out.println(group1.toString());
        System.out.println("Create new student");
        Student st1 = new Student(0, "Ivan", "Ivanov");
        //System.out.println(st1.toString());
        st1.addSubject("Math");
        st1.addMark("Math", 15);
        st1.addMark("Math", 25);
        st1.addMark("Math", 25);
        st1.addSkip("Math", "19.02.2017");
        st1.addSubject("Physics");
        st1.addMark("Physics", 25);
        System.out.println(st1.toString());
        System.out.println();
        System.out.println();

        System.out.println("Add him to group");
        group1.add(st1);
        System.out.println(group1.toString());
        System.out.println();
        System.out.println();

        Student st2 = new Student(1, "Petr", "Petrov");
        //System.out.println(st1.toString());
        st2.addSubject("Math");
        st2.addMark("Math", 10);
        st2.addMark("Math", 5);
        st2.addSkip("Math", "02.02.2017");
        st2.addSkip("Math", "03.02.2017");
        st2.addSkip("Math", "04.02.2017");

        st2.addSubject("Physics");
        st2.addMark("Physics", 15);
        st2.addSkip("Physics", "03.02.2017");
        st2.addSkip("Physics", "04.02.2017");

        System.out.println(st2.toString());
        System.out.println();
        System.out.println();

        System.out.println("Does st2 contain to group?");
        System.out.println(group1.contains(st2.getSurname()));
        System.out.println();
        System.out.println("Does st1 contain to group?");
        System.out.println(group1.contains(st1));
        System.out.println();

        System.out.println("Add st2 to new group");
        Group group2 = new Group("Group2");
        group2.add(st2);
        System.out.println(group2.toString());
        System.out.println();
        System.out.println();

        System.out.println("Does group1 contain group2?");
        System.out.println(group1.containsAll(group2));
        System.out.println();
        System.out.println("Are they equal?");
        System.out.println(group1.equals(group2));
        System.out.println();
        System.out.println("Are group 1 and group 1 equal?");
        System.out.println(group1.equals(group1));
        System.out.println();

        System.out.println("Join groups:");
        group1.join(group2);
        System.out.println(group1.toString());
        System.out.println();
        System.out.println();
        System.out.println("Delete Ivanov from group1");
        group1.delete("Ivanov");
        System.out.println(group1.toString());

    }
}
