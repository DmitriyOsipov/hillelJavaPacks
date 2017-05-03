package com.lessons.Ex8;



public class LinkedListElement {
    private Object value;
    private LinkedListElement next;

    public LinkedListElement(Object value, LinkedListElement next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public LinkedListElement getNext() {
        return next;
    }

    public void setNext(LinkedListElement next) {
        this.next = next;
    }
}
