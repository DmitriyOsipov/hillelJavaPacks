package Ex8_2;


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

    public void setValue(Object value){
        this.value = value;
    }

    public LinkedListElement getNext() {
        return next;
    }

    public void setNext(LinkedListElement next) {
        this.next = next;
    }
}
