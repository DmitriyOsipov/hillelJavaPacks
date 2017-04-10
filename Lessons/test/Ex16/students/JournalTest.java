package Ex16.students;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class JournalTest {
    Journal journal;
    @Before
    public void setUp(){
        journal = new Journal(1);
    }
    @Test
    public void getStudentId() throws Exception {
        assertEquals(journal.getStudentId(), 1);
    }

    @Test
    public void getJournal() throws Exception {
        Map<String, List<Integer>> sub = journal.getJournal();
        assertTrue(sub.isEmpty());
        journal.putMark("Math", 10);
        journal.putMark("Math", 20);

        sub = journal.getJournal();
        assertFalse(sub.isEmpty());
        assertTrue(sub.containsKey("Math"));
        assertEquals(sub.get("Math").size(), 2);
        assertFalse(sub.containsKey("English"));
    }

    @Test
    public void getAverageMarks() throws Exception {
        Map<String, Double> avg = journal.getAverageMarks();
        assertTrue(avg.isEmpty());
        journal.putMark("Math", 10);
        journal.putMark("Math", 20);
        avg = journal.getAverageMarks();
        assertFalse(avg.isEmpty());
        boolean rs = (avg.get("Math")>14.95) && (avg.get("Math")<15.05);
        assertTrue(rs);
    }

    @Test
    public void putMark() throws Exception {
        assertTrue(journal.getJournal().isEmpty());
        journal.putMark("Math", 10);
        assertFalse(journal.getJournal().isEmpty());
        assertEquals(journal.getJournal().size(), 1);
        assertEquals(journal.getJournal().get("Math").size(), 1);
        journal.putMark("Math", 10);
        assertEquals(journal.getJournal().size(), 1);
        assertEquals(journal.getJournal().get("Math").size(), 2);
    }

    @Test
    public void getMarks() throws Exception {
        journal.putMark("Math", 10);
        journal.putMark("Math", 30);
        List<Integer> marks = journal.getMarks("Math");
        assertFalse(marks.isEmpty());
        assertEquals(marks.get(0), Integer.valueOf(10));
        assertEquals(marks.get(1), Integer.valueOf(30));
        assertEquals(marks.size(), 2);
        assertEquals(journal.getMarks("English"), null);
    }

    @Test
    public void getSubjects() throws Exception {
        Set<String> subjects = journal.getSubjects();
        assertTrue(subjects.isEmpty());

        journal.putMark("Math", 10);
        journal.putMark("English", 15);
        journal.putMark("Math", 5);
        subjects = journal.getSubjects();
        assertFalse(subjects.isEmpty());
        assertEquals(subjects.size(), 2);
    }

    @Test
    public void getCsvString() throws Exception {
        journal.putMark("Math", 10);
        String testStr = "1;Math;10\n";
        assertEquals(journal.getCsvString(), testStr);

        journal.putMark("Math", 10);
        testStr = "1;Math;10;10\n";
        assertEquals(journal.getCsvString(), testStr);

        journal.putMark("English", 20);
        testStr = "1;English;20\n1;Math;10;10\n";
        assertEquals(journal.getCsvString(), testStr);
    }

}