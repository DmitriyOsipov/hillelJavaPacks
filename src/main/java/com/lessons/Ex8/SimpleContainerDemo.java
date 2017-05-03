package com.lessons.Ex8;

public class SimpleContainerDemo {
    public static void main(String[] args){
        System.out.println("Create new container");

        SimpleContainer container = new SimpleContainer();
        container.add("abc");
        container.add("bcd");
        container.add("cde");
        container.add("def");
        System.out.println(container);

        System.out.println("Size of container: " + container.size());

        System.out.println("It is empty - " + container.isEmpty());

        System.out.println("Contains \"cde\" " + container.contains("cde"));
        System.out.println("Contains \"acf\" " + container.contains("acf"));

        System.out.println("Contains container - " + container.containsAll(container));
        System.out.println();

        System.out.println("Create new container:");
        SimpleContainer container2 = new SimpleContainer();
        container2.add("acf");
        container2.add("bcd");
        container2.add("edc");
        container2.add("def");
        System.out.println(container);

        System.out.println("Contains first container - " + container.containsAll(container2));
        container.retainAll(container2);
        System.out.println("Retain container1 :" + container);
        System.out.println("Delete \"bcd\"");
        container.remove("bcd");
        System.out.println("Container1: " + container);
        container2.removeAll(container);
        System.out.println("Remove all container1 from container2: " + container2);
        System.out.println("container2 size: " + container2.size());
        System.out.println("For each test container2:");
        for (Object object:container2) {
            System.out.println(object);
        }
    }
}
