package Ex15;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyTwoLinkedListTest {
    private MyTwoLinkedList<Integer> list;

    @Before
    public void setUp(){
        list = new MyTwoLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test(expected = NullPointerException.class)
    public void add() {
        list = new MyTwoLinkedList<>();
        assertTrue(list.isEmpty());
        assertTrue(list.size()==0);
        assertTrue(list.add(1));
        assertTrue(list.size()==1);
        assertFalse(list.isEmpty());
        assertTrue(list.add(5));
        assertTrue(list.size()==2);
        list.add(null);
    }

    @Test
    public void size() throws Exception {
        list = new MyTwoLinkedList<>();
        assertTrue(list.size() == 0);
        list.add(1);
        assertTrue(list.size()==1);
        list.add(3);
        assertTrue(list.size()==2);
    }

    @Test
    public void isEmpty() throws Exception {
        list = new MyTwoLinkedList<>();
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void clear() throws Exception {
        assertTrue(list.size()==3);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
        assertTrue(list.size()==0);
    }

    @Test (expected = NullPointerException.class)
    public void equals() throws Exception {
        MyTwoLinkedList<Integer> list2 = new MyTwoLinkedList<>(1);
        list2.add(2);
        assertFalse(list.equals(list2));
        list2.add(3);
        assertTrue(list.equals(list2));
        MyTwoLinkedList<Integer> list3 = null;
        assertFalse(list.equals(list3));
    }

    @Test (expected = NullPointerException.class)
    public void contains() throws Exception {
        list.add(1);
        list.add(2);
        list.add(3);
        assertFalse(list.contains(4));
        assertFalse(list.contains("aaa"));
        assertTrue(list.contains(2));
        list.contains(null);
    }

    @Test
    public void iterator(){
        Iterator iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 1);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 2);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), 3);
    }

    @Test
    public void toArray(){

        Integer[] ar = {1, 2, 3};
        Object[] arO = list.toArray();
        assertEquals(ar[0], arO[0]);
        assertEquals(ar[1], arO[1]);
        assertEquals(ar.length, arO.length);
    }

    @Test (expected = NullPointerException.class)
    public  void toArray2(){

        Integer[] a = null;
        a = list.toArray(a);
        a = new Integer[2];
        a = list.toArray(a);
        assertTrue(a.length == list.size());
        assertTrue(a[0].equals(1));
    }

    @Test
    public void addLeft(){
        list.addLeft(2);
        list.addLeft(3);
        Iterator iter = list.iterator();
        assertEquals(iter.next(), 3);
        assertEquals(iter.next(), 2);
        assertEquals(iter.next(), 1);
    }

    @Test
    public void remove(){
        assertFalse(list.remove(Integer.valueOf(5)));
        assertTrue(list.contains(2));
        assertTrue(list.remove(Integer.valueOf(2)));
        assertFalse(list.contains(2));

        assertTrue(list.contains(3));
        assertTrue(list.remove(Integer.valueOf(3)));
        assertFalse(list.contains(3));
    }

    @Test (expected = NullPointerException.class)
    public void containsAll(){
        ArrayList<Integer> aL = new ArrayList<>();
        aL.add(2);
        aL.add(1);
        list.containsAll(null);
        assertTrue(list.containsAll(aL));
        aL.add(5);
        assertFalse(list.containsAll(aL));
    }

    @Test (expected = NullPointerException.class)
    public void addAll(){
        ArrayList<Integer> aL = new ArrayList<>();
        aL.add(4);
        aL.add(5);

        assertTrue(list.addAll(aL));
        assertEquals(list.size(), 5);
        aL.add(null);
        assertFalse(list.addAll(aL));
        assertEquals(list.size(), 7);
    }

    @Test (expected = NullPointerException.class)
    public void removeAll(){
        ArrayList<Integer> aL = new ArrayList<>();
        aL.add(4);
        aL.add(5);
        assertTrue(list.addAll(aL));
        assertEquals(list.size(), 5);
        assertTrue(list.addAll(aL));
        assertEquals(list.size(), 7);
        assertFalse(list.removeAll(null));
        assertTrue(list.removeAll(aL));
        assertEquals(list.size(), 3);
    }

    @Test
    public void removeAll2(){
        ArrayList<Integer> aL = new ArrayList<>();
        aL.add(4);
        aL.add(5);
        assertTrue(list.addAll(aL));
        assertEquals(list.size(), 5);
        assertTrue(list.addAll(aL));
        assertEquals(list.size(), 7);
        assertTrue(list.removeAll(5));
        assertEquals(list.size(), 6);
        assertTrue(list.removeAll(2));
        assertEquals(list.size(), 3);
    }

    @Test
    public void retainAll(){
        ArrayList<Integer> aL = new ArrayList<>();
        aL.add(4);
        aL.add(5);
        assertTrue(list.addAll(aL));
        assertEquals(list.size(), 5);
        assertTrue(list.retainAll(aL));
        assertEquals(list.size(), 2);
        assertTrue(list.addAll(aL));
        assertEquals(list.size(), 4);
        assertFalse(list.retainAll(aL));
        assertEquals(list.size(), 4);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void get(){
        list.get(-1);
        assertEquals(list.get(0),Integer.valueOf(1));
        assertEquals(list.get(1),Integer.valueOf(2));
        assertEquals(list.get(2),Integer.valueOf(3));
        list.get(50);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void set(){
        list.set(-1,7);
        assertEquals(list.set(0,5), Integer.valueOf(1));
        assertEquals(list.get(0), Integer.valueOf(5));
        assertEquals(list.set(1,7),Integer.valueOf(2));
        assertEquals(list.get(1), Integer.valueOf(7));
        list.set(50,9);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void addPos(){
        list.add(-1,10);
        list.add(1,5);
        assertEquals(list.get(1), Integer.valueOf(5));
        assertEquals(list.get(2), Integer.valueOf(2));
        list.add(24, 1);
        list.add(2,10);
        assertEquals(list.get(1), Integer.valueOf(5));
        assertEquals(list.get(2), Integer.valueOf(10));
        assertEquals(list.get(3), Integer.valueOf(2));
    }

    @Test (expected =  IndexOutOfBoundsException.class)
    public void removePos(){
        list.remove(-1);
        assertEquals(list.remove(0), Integer.valueOf(1));
        assertEquals(list.remove(1), Integer.valueOf(3));
        assertEquals(list.remove(0),Integer.valueOf(2));
        assertTrue(list.isEmpty());
        list.remove(0);
    }

    @Test (expected = NullPointerException.class)
    public void indexOf(){
        list.indexOf(null);
        assertEquals(list.indexOf(3),2);
        assertEquals(list.indexOf(1), 0);
        assertEquals(list.indexOf(10), -1);
    }

    @Test (expected = NullPointerException.class)
    public void lastIndexOf(){
        list.add(1);
        list.add(2);
        list.add(1);
        list.lastIndexOf(null);
        assertEquals(list.lastIndexOf(3), 2);
        assertEquals(list.lastIndexOf(1), 5);
        assertEquals(list.lastIndexOf(2), 4);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void subList(){
        list.add(4);
        list.add(5);
        list.add(6);

        MyTwoLinkedList<Integer> list2 = (MyTwoLinkedList<Integer>) list.subList(0, list.size()-1);
        assertTrue(list2.equals(list));
        list2 = (MyTwoLinkedList<Integer>)list.subList(2,4);
        assertEquals(list2.size(), 3);
        assertEquals(list2.get(0), list.get(2));
        assertEquals(list2.get(2), list.get(4));
        try {
            list2 = (MyTwoLinkedList<Integer>)list2.subList(2,100);
        }
        catch (IndexOutOfBoundsException e) {
            assertEquals(list2.size(), 3);
            throw e;
        }
    }

    @Test (expected = NoSuchElementException.class)
    public void listIterator(){
        ListIterator<Integer> li = list.listIterator();
        assertFalse(li.hasPrevious());
        assertTrue(li.hasNext());
        assertEquals(li.next(), Integer.valueOf(1));
        assertTrue(li.hasPrevious());
        assertTrue(li.hasNext());
        assertEquals(li.next(), Integer.valueOf(2));
        assertEquals(li.next(), Integer.valueOf(3));
        assertFalse(li.hasNext());
        try{
            li.next();
            assertTrue(false);
        }
        catch (NoSuchElementException e){
            assertTrue(true);
        }

        assertTrue(li.hasPrevious());
        assertEquals(li.previous(), Integer.valueOf(2));
        li.previous();
        li.previous();
    }
}