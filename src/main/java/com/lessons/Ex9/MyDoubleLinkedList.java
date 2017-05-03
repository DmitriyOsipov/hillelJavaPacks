package com.lessons.Ex9;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class MyDoubleLinkedList {//implements List{
    /*
    private final boolean CASHE_SIZE=false;
    private Node first = null;
    private Node last = null;
    private long size = 0;
    private boolean sizeChanged;
    
    public MyDoubleLinkedList(){}
    public MyDoubleLinkedList(Object object){
        this.add(object);
    }

    private void setSizeChanged(){
        sizeChanged = true;
    }

    private boolean checkIndex(int index){
        if ((index<0)||(index>=this.size())){
            throw new IndexOutOfBoundsException();
        }
        return true;
    }

    private Node getNodeCashed(int index){
        Node result = null;
        if (this.checkIndex(index)){
            int arSize = this.size();

            if (index > arSize/2){
                result = searchFromStart(index);
            }
            else {
                result = searchFromEnd(index, arSize);
            }
        }
        return result;
    }

    private Node searchFromStart(int index){
        Node result = null;
        int ind = 0;
        Node element = first;
        while (result == null){
            if (ind == index){
                result = element;
            }
            element = element.getNext();
            ind++;
        }
        return result;
    }

    private Node searchFromEnd(int index, int listSize){
        Node result = null;
        int ind = listSize - 1;
        Node element = last;
        while (result == null){
            if (ind == index){
                result = element;
            }
            element = element.getPrevious();
            ind--;
        }
        return result;
    }

    public Node getNode(int index){
        Node retElement = null;
        if (this.checkIndex(index)){
            if (this.CASHE_SIZE){
                retElement = this.getNodeCashed(index);
            }
            else {
                retElement = this.searchFromStart(index);
            }
        }
        return retElement;
    }

    public boolean equals(MyDoubleLinkedList list){
        if (list == this){
            return true;
        }
        if ((list==null)||(list.size()!=this.size())){
            return false;
        }
        Node elementThis = this.first;
        Node elementInput = list.first;
        while ((elementThis!=null)&&(elementInput!=null)){
            if (!elementThis.getValue().equals(elementInput.getValue())){
                return false;
            }
            elementInput = elementInput.getNext();
            elementThis = elementThis.getNext();
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }
    //*/
    /**
     * Returns the number of elements in this list.  If this list contains
     * more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in this list
     *//*
    @Override
    public int size() {
        if (sizeChanged || !CASHE_SIZE){
            size=0;
            Node element = first;
            while (element!=null){
                size++;
                element = element.getNext();
            }
            sizeChanged = false;
        }
        if (size>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else {
            return (int)size;
        }
    }


    @Override
    public boolean contains(Object o) {
        Node element = first;
        while(element!=null){
            if (element.getValue().equals(o)){
                return true;
            }
            element = element.getNext();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        if (c==this){
            return true;
        }
        if (c==null){
            throw new NullPointerException();
        }
        Object[] objects = c.toArray();
        for (int i=0; i<objects.length; i++){
            if (!this.contains(objects[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
           Node current = first;
           Node previous = current.getPrevious();

            @Override
            public boolean hasNext() {
                return (current!=null);
            }


            @Override
            public Object next() throws IndexOutOfBoundsException{

                Object result = current.getValue();
                previous = current;
                current = current.getNext();

                return result;
            }


            @Override
            public void remove(){
                MyDoubleLinkedList.this.setSizeChanged();
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

    @Override
    public Object[] toArray() {
        Object[] result = this .toArray(new Object[this.size()]);
        return result;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a==null){
            throw new NullPointerException();
        }
        Object[] result;

        if (a.length >= this.size()){
            result = a;
        }
        else {
            result = new Object[this.size()];
        }

        int ind = 0;
        Node node = first;
        while (node!=null){
            result[ind] = node.getValue();
            node = node.getNext();
            ind++;
        }

        return result;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        this.size = 0;
        sizeChanged = true;
    }




    //add variants: list is empty, add to begin of list

    private boolean addLeft(Object o){
        this.setSizeChanged();
        Node node = new Node(o, first, null);
        if (!this.isEmpty()){
            first.setPrevious(node);
        }
        else {
            last = node;
        }
        first = node;
        return true;
    }

    //add to end of list

    @Override
    public boolean add(Object o) {
        this.setSizeChanged();
        if (this.isEmpty()){
            this.addLeft(o);
        }
        else {
            Node node = new Node(o, null, last);
            last = node;
        }
        return true;
    }


    //add to some index

    @Override
    public void add(int index, Object element) {
        this.setSizeChanged();

        Node old = this.getNode(index);
        Node newNode = new Node(element, old, old.getPrevious());

        old.getPrevious().setNext(newNode);
        old.setPrevious(newNode);
    }



    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        Node element = first;
        builder.append("[");
        while (element!=null){
            builder.append(" " + element.getValue().toString() + " ");
            element = element.getNext();
        }
        builder.append("]");
        return builder.toString();
    }
    
    public String toStringReverse(){
        StringBuilder builder = new StringBuilder("[");
        Node node = last;
        
        while (node!=null){
            builder.append(" " + node.getValue() + " ");
            node = node.getPrevious();
        }
        
        builder.append("]");
        return builder.toString();
    }
    //*/
}
