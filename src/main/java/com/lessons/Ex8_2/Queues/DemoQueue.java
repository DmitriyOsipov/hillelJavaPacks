package com.lessons.Ex8_2.Queues;

public class DemoQueue {

    public static void main(String[] args){
        String[] elements = new String[]{"aaa", "bbb", "ccc", "ddd", "eee", "fff"};

        MyQueue queue = new MyQueue();
        MyDeque deque = new MyDeque();

        System.out.println("Queue: " + queue);
        System.out.println("Deque: " + deque);

        System.out.println("Empty? Queue - ");
        isEmpty(queue);
        System.out.println("Deque - ");
        isEmpty(deque);

        System.out.println("Fill");
        inputElements(elements, queue);
        inputElements(elements, deque);
        System.out.println("Queue: " + queue);
        System.out.println("Deque: " + deque);

        System.out.println("Pop 3 elements");
        System.out.println("Queue: ");
        pop(queue, 3);
        System.out.println();
        System.out.println("Deque: ");
        pop(deque, 3);
        System.out.println();

        System.out.println("q - ");
        size(queue);
        System.out.println("d - ");
        size(deque);

        System.out.println("Clear Deque");
        deque.clear();
        System.out.println("Is it empty?");
        isEmpty(deque);
        size(deque);
        System.out.println("Push elements in front of Deque ");
        for (String s: elements){
            deque.pushFront(s);
        }
        System.out.println("Deque: " + deque);
        size(deque);
        System.out.println("Pop elements from back from deque:");
        while (!deque.isEmpty()){
            System.out.print(deque.popBack() + "\t");
        }
    }

    public static void inputElements(Object[] objects, MyQueue queue){
        for(Object object:objects){
            queue.pushBack(object);
        }
    }
    public static void isEmpty(MyQueue queue){
        System.out.println(queue.isEmpty());
    }
    public static void size(MyQueue queue){
        System.out.println("Size: " + queue.size());
    }
    public static void pop(MyQueue queue, int els){
        for (;els>=0; els--) {
            System.out.print(queue.popFront() + "\t");
        }
    }
}
