package Ex16.students;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class StudentTest {
    Student student;
    @Before
    public void setUp(){
        student = new Student(0, "Ivanov");
    }
    @Test
    public void getId() throws Exception {
        assertEquals(student.getId(),0);
    }

    @Test
    public void getName() throws Exception {
        assertEquals(student.getName(), "Ivanov");
    }

    @Test
    public void setName() throws Exception {
        student.setName("Petrov");
        assertEquals(student.getName(), "Petrov");
    }

    @Test
    public void getGroup() throws Exception {
        assertEquals(student.getGroup(), 0);
    }

    @Test
    public void setGroup() throws Exception {
        student.setGroup(1);
        assertEquals(student.getGroup(),1);
    }

    @Test
    public void getCsvString() {
        String test = "0;Ivanov;0";
        assertEquals(student.getCsvString(), test);
    }
}