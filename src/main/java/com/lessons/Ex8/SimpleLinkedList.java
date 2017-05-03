package com.lessons.Ex8;

import java.util.Iterator;

public class SimpleLinkedList implements Iterable{
    private LinkedListElement first = null;
    private LinkedListElement last = null;
    private int sizeList = 0;
    private boolean sizeChanged = false;

    public SimpleLinkedList(){

    }
    public SimpleLinkedList(Object object){
        this.add(object);
    }

    /**
     * add an object into linked list
     * @param object
     * some object to add
     */
    public boolean add(Object object){
        boolean result = false;
        try {
            LinkedListElement newElement = new LinkedListElement(object, null);
            if (last == null) {
                this.first = newElement;
                this.last = newElement;
            } else {
                last.setNext(newElement);
                last = newElement;
            }
            result = true;
            sizeChanged = true;
        }
        catch (Exception ex){
            result = false;
        }
        return result;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public boolean contains(Object object){
        LinkedListElement element = first;
        while(element!=null){
            if (element.getValue().equals(object)){
                return true;
            }
            element = element.getNext();
        }
        return false;
    }

    public boolean containsAll(SimpleLinkedList list){
        if (list==this){
            return true;
        }
        LinkedListElement inputElement = list.first;
        while (inputElement!=null){
            if (!this.contains(inputElement.getValue())){
                return false;
            }
            inputElement = inputElement.getNext();
        }
        return true;
    }

    public boolean remove(Object object){
        LinkedListElement element = first;
        boolean result = false;
        while (element.getNext()!=null){
            if (element.getNext().getValue().equals(object)){
                if (last==element.getNext()){
                    last = element;
                    last.setNext(null);
                    return true;
                }
                element.setNext(element.getNext().getNext());
                result = true;
                sizeChanged=true;
            }
            element = element.getNext();
        }
        return result;
    }

    public boolean removeAll(SimpleLinkedList list){
        boolean result = false;
        LinkedListElement inputElement = list.first;

        while (inputElement!=null){
            //this.remove(inputElement.getValue());
            result = result | this.remove(inputElement.getValue());
            inputElement = inputElement.getNext();
        }
        return result;
    }

    public boolean retainAll(SimpleLinkedList list){
        boolean result = false;
        LinkedListElement element = this.first;
        while (element!=null){
            if(!list.contains(element.getValue())){
                this.remove(element.getValue());
                result = true;
            }
            element = element.getNext();
        }
        return result;
    }

    public boolean addAll(SimpleLinkedList list){
        LinkedListElement element = list.first;
        while (element!=null){
            if (!this.add(element.getValue())){
                return false;
            }
        }
        return true;
    }

    public void clear(){
        this.first = null;
        this.last = null;
        this.sizeList = 0;
        sizeChanged = true;
    }

    public int size() {
        if (sizeChanged){
            this.sizeList = 0;
            LinkedListElement element = first;
            while (element !=null){
                sizeList++;
                element = element.getNext();
            }
        }
        return sizeList;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        LinkedListElement element = first;
        builder.append("[");
        while (element!=null){
            builder.append(" " + element.getValue().toString() + " ");
            element = element.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            LinkedListElement current = first;
            LinkedListElement previous = null;

            @Override
            public boolean hasNext() {
                //return (current.getNext()!=null);
                return (current!=null);
            }


            @Override
            public Object next() throws IndexOutOfBoundsException{

                Object result = current.getValue();
                /*
                if (!hasNext()){
                    throw new IndexOutOfBoundsException();
                }*/
                previous = current;
                current = current.getNext();

                return result;
            }


            @Override
            public void remove(){
                if (!hasNext()){
                    previous.setNext(null);
                }
                else {
                    if (previous!=null) {
                        previous.setNext(current.getNext());
                    }
                    else {
                        current = current.getNext();
                        first = current;
                    }
                }
            }
        };
    }


}
