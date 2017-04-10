package Ex16.students;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class GroupTest {
    Group group;
    @Before
    public void setUp(){
        group = new Group(0, "group0");
    }

    @Test
    public void getId() throws Exception {
        assertEquals(group.getId(), 0);
    }

    @Test
    public void add() throws Exception {
        Student student = new Student(1, "Ivanov");
        assertEquals(group.size(),0);
        group.add(student);
        assertEquals(group.size(),1);
        group.add(student);
        assertEquals(group.size(),1);

    }

    @Test
    public void remove() throws Exception {
        Student ivanov = new Student(0, "Ivanov");
        Student petrov = new Student(1, "Petrov");
        group.add(ivanov);
        group.add(petrov);
        assertEquals(group.size(), 2);
        group.remove(3);
        assertEquals(group.size(), 2);
        group.remove(1);
        assertEquals(group.size(),1);
        assertFalse(group.getStudents().contains(petrov));
        assertTrue(group.getStudents().contains(ivanov));
    }

    @Test
    public void size() throws Exception {
        assertEquals(group.size(), 0);
        Student ivanov = new Student(0, "Ivanov");
        Student petrov = new Student(1, "Petrov");
        group.add(ivanov);
        assertEquals(group.size(), 1);
        group.add(petrov);
        assertEquals(group.size(), 2);
    }

    @Test
    public void getStudents() throws Exception {
        assertTrue(group.getStudents().isEmpty());
        Student ivanov = new Student(0, "Ivanov");
        Student petrov = new Student(1, "Petrov");
        group.add(ivanov);
        group.add(petrov);
        Collection<Student> students = group.getStudents();
        assertFalse(students.isEmpty());
        assertEquals(students.size(), 2);
        assertTrue(students.contains(ivanov));
        assertTrue(students.contains(petrov));
    }

    @Test
    public void getCsvString() throws Exception {
        String test = "0;group0;";
        assertEquals(group.getCsvString(), test);
    }

}