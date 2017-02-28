package Ex8_2;

public class Demo {
    public static void main(String[] args) throws Exception{
        MyLinkedList list1 = new MyLinkedList();
        MyLinkedList list2 = new MyLinkedList();
        String[] els = new String[]{"ab", "bc", "cd", "de", "ef", "cd", "ab", "fh", "ef"};
        String[] els2 = new String[]{"gh", "kl", "ab", "de", "ck", "fh"};
        for (String s : els){
            list1.add(s);
        }
        for (String s: els2){
            list2.add(s);
        }
        System.out.println(list1.toString());
        System.out.println(list2.toString());

        System.out.println();
        System.out.println("Size 1: " + list1.size());
        System.out.println("Size 2: " + list2.size());

        System.out.println("Contains 1 'de'? " + list1.contains("de"));
        System.out.println("Contains 1 - 2? " + list1.containsAll(list2));
        System.out.println("Contains 1 - 1? " + list1.containsAll(list1));
        System.out.println("Contains 2 - " + list2.getElement(1).getValue() + " (1 element)? " + list2.containsAllListElement(list2.getElement(1)));

    }
}
