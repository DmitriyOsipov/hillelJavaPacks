package Ex8_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Demo {
    public static void main(String[] args) throws Exception{
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        String[] els = new String[]{"ab", "bc", "cd", "de", "ef", "cd", "ab", "fh", "ef"};
        String[] els2 = new String[]{"gh", "kl", "ab", "de", "ck", "fh"};
        System.out.println("Is 1-st empty ? " + list1.isEmpty());
        System.out.println("Add elements");
        for (String s : els){
            list1.add(s);
        }

        for (String s: els2){
            list2.add(s);
        }
        System.out.println(list1.toString());
        System.out.println("Is 1-st empty? " + list1.isEmpty());
        System.out.println(list2.toString());

        System.out.println();
        System.out.println("Size 1: " + list1.size());
        System.out.println("Size 2: " + list2.size());

        System.out.println();
        System.out.println("Is list1 equal to list2 ? " + list1.equals(list2));
        System.out.println("Is list2 equal to list2 ? " + list2.equals(list2));

        System.out.println();
        System.out.println("Contains 1 'de'? " + list1.contains("de"));
        System.out.println("Contains 1 - 2? " + list1.containsAll(list2));
        System.out.println("Contains 1 - 1? " + list1.containsAll(list1));
        System.out.println("Contains 2 - " + list2.getElement(1).getValue() + " (1 element)? " + list2.containsAllListElement(list2.getElement(1)));

        System.out.println("Get element value from list1 with index 5: " + list1.get(5));
        System.out.println("Set element value to 'aaa' with index 4: ");
        list1.set(4, "aaa");
        System.out.println(list1);
        System.out.println("List 1 to Array: " + Arrays.toString(list1.toArray()));
        Object[] obj2 = new Object[3];
        System.out.println("List 2 to Array: " + Arrays.toString(list2.toArray(obj2)));

        System.out.println("Add 'ef' to left side of list1: ");
        list1.addLeft("ef");
        System.out.println(list1);

        System.out.println();
        System.out.println("Index of 'aaa' in list 1: " + list1.indexOf("aaa"));
        System.out.println("Remove 'aaa' from list1: ");
        list1.remove("aaa");
        System.out.println(list1);
        System.out.println("Index of 'aaa' in list 1: " + list1.indexOf("aaa"));

        System.out.println("Last index of 'cd' in list1: " + list1.lastIndexOf("cd"));
        System.out.println("remove element with index 3:");
        list1.remove(3);
        System.out.println(list1);

        System.out.println();
        System.out.println("Add 'lm' at index 4: ");
        list1.add(4, "lm");
        System.out.println(list1);

        System.out.println();
        System.out.println("List 1: " + list1);
        System.out.println("size = " + list1.size());
        System.out.println("List 2: " + list2);
        System.out.println("size = " + list2.size());
        System.out.println("Add all list2 to list1: ");
        list1.addAll(list2);
        System.out.println("List 1: " + list1);
        System.out.println("Size: " + list1.size());
        System.out.println();

        ArrayList<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        strings.add("ddd");
        System.out.println("Add arrayList to list1: ");
        list1.addAll(strings);
        System.out.println(list1);

        System.out.println();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("ccc");
        System.out.println("List 2: " + list2);
        System.out.println("Add another array list to list 2 from index 3");
        list2.addAll(3, arrayList);
        System.out.println(list2);

        System.out.println();
        System.out.println("Remove all from index 17 from list1");
        list1.removeAll(17);
        System.out.println(list1);

        System.out.println();
        System.out.println("Get sublist 3 to 8 from list1");
        System.out.println(list1.subList(3,8));
        System.out.println("-------------------------------------");

        System.out.println(list1);
        System.out.println("Remove all array list 2 from list 1");
        list1.removeAll(arrayList);
        System.out.println(list1);
        System.out.println();
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        System.out.println("Retain all list 2 from list 1:");
        list1.retainAll(list2);
        System.out.println(list1);

        System.out.println();
        System.out.println("iterator demo:");
        System.out.println("Foreach");
        for (Object object:list2){
            System.out.print(object + " | ");
        }
        System.out.println();
        System.out.println("Iterator");
        Iterator iterator = list2.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + " | ");
        }

        System.out.println();
        System.out.println("List iterator demo");
        //System.out.println("start from 3");
        ListIterator listIterator = list2.listIterator();
        int i=0;
        while(listIterator.hasNext()){
            if (i==1){
                System.out.println("\nset 1-st element to 'x'");
                listIterator.set("x");
            }
            if (i==2){
                System.out.println("\nadd element after 2");
                listIterator.add("ADDED");
            }
            if (i==3){
                System.out.println("\ndelete 3rd element");
                listIterator.remove();
            }
            i++;
            System.out.print(listIterator.next() + " |");
        }
        System.out.println();
        System.out.println(list2);
        System.out.println(" --- AND BACK ---  ");
        System.out.println();

        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previous() + " |");
        }

        System.out.println();


    }
}
