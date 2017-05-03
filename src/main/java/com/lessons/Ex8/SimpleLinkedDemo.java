package com.lessons.Ex8;

public class SimpleLinkedDemo {
    public static void main(String[] args) throws Exception{
        System.out.println("Create new list:");
        SimpleLinkedList list = new SimpleLinkedList();
        list.add("abc");
        list.add("bcd");
        list.add("cde");
        list.add("def");
        System.out.println(list);

        System.out.println("Size of list: " + list.size());

        System.out.println("It is empty - " + list.isEmpty());

        System.out.println("Contains \"cde\" " + list.contains("cde"));
        System.out.println("Contains \"acf\" " + list.contains("acf"));

        System.out.println("Contains list - " + list.containsAll(list));
        System.out.println();

        System.out.println("Create new list:");
        SimpleLinkedList list2 = new SimpleLinkedList();
        list2.add("acf");
        list2.add("bcd");
        list2.add("edc");
        list2.add("def");
        System.out.println(list);

        System.out.println("Contains list - " + list.containsAll(list2));
        list.retainAll(list2);
        System.out.println("Retain list1 :" + list);
        System.out.println("Delete \"bcd\"");
        list.remove("bcd");
        System.out.println("List1: " + list);
        list2.removeAll(list);
        System.out.println("Remove all list1 from list2: " + list2);
        System.out.println("List2 size: " + list2.size());
        System.out.println("For each test list2:");
        for (Object object:list2) {
            System.out.println(object);
        }
    }
}
