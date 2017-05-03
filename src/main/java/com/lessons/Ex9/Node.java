package com.lessons.Ex9;

public class Node {
    private Object value;
    private Node next;
    private Node previous;

    public Node(Object value, Node next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value){
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
