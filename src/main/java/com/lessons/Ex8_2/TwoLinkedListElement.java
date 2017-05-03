package com.lessons.Ex8_2;


public class TwoLinkedListElement {
    private Object value;
    private TwoLinkedListElement next;
    private TwoLinkedListElement previous;

    public TwoLinkedListElement(Object value, TwoLinkedListElement next, TwoLinkedListElement previous) {
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

    public TwoLinkedListElement getNext() {
        return next;
    }

    public void setNext(TwoLinkedListElement next) {
        this.next = next;
    }

    public TwoLinkedListElement getPrevious() {
        return previous;
    }

    public void setPrevious(TwoLinkedListElement previous) {
        this.previous = previous;
    }
}
