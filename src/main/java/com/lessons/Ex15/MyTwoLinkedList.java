package com.lessons.Ex15;

import java.util.*;


public class MyTwoLinkedList<T> implements List<T>{

    private TwoLinkedListElement<T> first = null;
    private TwoLinkedListElement<T> last = null;

    public MyTwoLinkedList(){

    }
    public MyTwoLinkedList(T object){
        this.add(object);
    }


    boolean equals(MyTwoLinkedList<T> list){
        if (list == this){
            return true;
        }
        if (list.size()!=this.size()){
            return false;
        }
        TwoLinkedListElement<T> elementThis = this.first;
        TwoLinkedListElement<T> elementInput = list.first;
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
    public int size() {
        int sizeList = 0;
        TwoLinkedListElement<T> element = first;
        while (element !=null){
            sizeList++;
            element = element.getNext();
        }

        return sizeList;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public boolean contains(Object o) {
        if (o==null){
            throw new NullPointerException();
        }

        TwoLinkedListElement<T> element = first;
        while(element!=null){
            if (element.getValue().equals(o)){
                return true;
            }
            element = element.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            TwoLinkedListElement<T> current = first;
            TwoLinkedListElement<T> previous = current.getPrevious();

            @Override
            public boolean hasNext() {
                //return (current.getNext()!=null);
                return (current!=null);
            }


            @Override
            public T next() throws NoSuchElementException{
                if (current==null)
                {
                    throw new NoSuchElementException();
                }
                T result = current.getValue();
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

    @Override
    public Object[] toArray() {
        Object[] result = new Object[this.size()];

        int ind = 0;
        for(Object object:this){
            result[ind] = object;
            ind++;
        }

        return result;
    }

    @Override
    public<T> T[] toArray(T[] a) {
        if (a==null){
            throw new NullPointerException();
        }
        T[] result;
        try {
            if (a.length >= this.size()) {
                result = a;
            } else {
                result = (T[]) new Object[this.size()];
            }

            int ind = 0;

            for (Object object : this) {
                result[ind] = (T) object;
                ind++;
            }
        }
        catch (ClassCastException e){
            throw new ArrayStoreException();
        }
        return result;
    }

    @Override
    public boolean add(T object) {
        boolean result = false;
        try {
            TwoLinkedListElement<T> newElement = new TwoLinkedListElement<>(object, null, null);
            if (last == null) {
                this.first = newElement;
                this.last = newElement;
            } else {
                newElement.setPrevious(last);
                last.setNext(newElement);
                last = newElement;
            }
            result = true;
        }
        catch (Exception ex){
            result = false;
            throw ex;
        }
        return result;
    }

    public boolean addLeft(T object){
        boolean result = false;
        try {
            TwoLinkedListElement<T> newElement = new TwoLinkedListElement<>(object, null, null);
            if (last == null) {
                this.first.setPrevious(newElement);
                this.first = newElement;
                this.last = newElement;
            } else {
                newElement.setNext(first);
                first.setPrevious(newElement);
                first = newElement;
            }
            result = true;
        }
        catch (Exception ex){
            result = false;
            throw  ex;
        }
        return result;
    }

    @Override
    public boolean remove(Object object) {
        if (object == null){
            throw new NullPointerException();
        }
        TwoLinkedListElement<T> element = first;
        TwoLinkedListElement<T> previous = element.getPrevious();
        boolean result = false;
        while (element!=null){
            if (element.getValue().equals(object)){
                if (first == element){
                    first = element.getNext();
                    first.setPrevious(null);
                }
                else{
                    if (last==element){
                        last = previous;
                        last.setNext(null);
                        return true;
                    }
                    else {
                        element.getNext().setPrevious(previous);
                        previous.setNext(element.getNext());
                    }
                }
                result = true;
            }
            previous = element;
            element = element.getNext();
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
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

    public boolean containsAllListElement(TwoLinkedListElement<T> inputElement){
        while (inputElement != null) {
            if (!this.contains(inputElement.getValue())) {
                return false;
            }
            inputElement = inputElement.getNext();
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c==null){
            throw new NullPointerException();
        }
        T[] objects = (T[])c.toArray();
        boolean res = true;
        for(int i=0; ((i<objects.length) && res); i++){
            res = this.add(objects[i]);
        }
        return res;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        boolean res = false;
        if ((index<0)||(index>=this.size())){
            throw new IndexOutOfBoundsException();
        }
        if (c==null){
            throw new NullPointerException();
        }
        TwoLinkedListElement<T> indexElement = this.getElement(index);
        TwoLinkedListElement<T> tmpLast = last;
        last = this.getElement(index - 1);
        res = this.addAll(c);
        last.setNext(indexElement);
        indexElement.setPrevious(last);
        last = tmpLast;

        return res;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
       if (c==null){
           throw new NullPointerException();
       }
        boolean result = false;
        Object[] objects = c.toArray();

        for (Object object:objects){
            result = result | this.remove(object);
        }
        return result;
    }

    public boolean removeAll(int fromIndex){
        boolean result = false;
        if ((fromIndex<0)||(fromIndex>=this.size())){
            throw new IndexOutOfBoundsException();
        }
        TwoLinkedListElement<T> prev = (fromIndex>0)? this.getElement(fromIndex-1):null;
        this.last = this.getElement(fromIndex);
        this.last.setPrevious(prev);
        this.last.setNext(null);
        result = true;

        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c==null){
            throw new NullPointerException();
        }
        boolean result = false;
        TwoLinkedListElement<T> element = this.first;
        while (element!=null){
            if(!c.contains(element.getValue())){
                this.remove(element.getValue());
                result = true;
            }
            element = element.getNext();
        }
        return result;
    }

    @Override
    public void clear() {
        first = null;
        //last = first;
        last = null;
    }

    @Override
    public T get(int index) {
        return this.getElement(index).getValue();
    }

    public TwoLinkedListElement<T> getElement(int index){
        TwoLinkedListElement<T> retElement = null;
        if ((index<0)||(index>=this.size())){
            throw new IndexOutOfBoundsException();
        }
        else{
            int ind=0;
            TwoLinkedListElement<T> element = first;
            while (retElement==null){
                if (ind==index){
                    retElement = element;
                }
                element = element.getNext();
                ind++;
            }
        }
        return retElement;
    }

    @Override
    public T set(int index, T element) {
        if ((index<0)||(index>this.size())){
            throw new IndexOutOfBoundsException();
        }

        TwoLinkedListElement<T> linkedListElement = this.getElement(index);
        T prevValue = linkedListElement.getValue();
        linkedListElement.setValue(element);

        return prevValue;
    }

    @Override
    public void add(int index, T element) {
        if ((index<0)||(index>=this.size())){
            throw new IndexOutOfBoundsException();
        }
        else {
            if (index == 0){
                this.addLeft(element);
            }
            else {
                TwoLinkedListElement<T> elementToInsert = new TwoLinkedListElement<>(element, this.getElement(index), null);
                TwoLinkedListElement<T> previous = this.getElement(index - 1);
                TwoLinkedListElement<T> nextEl = previous.getNext();
                previous.setNext(elementToInsert);
                elementToInsert.setPrevious(previous);
                nextEl.setPrevious(elementToInsert);
            }
        }
    }

    @Override
    public T remove(int index) {
        T prevVal = null;
        if (index==0){
            prevVal = first.getValue();
            first = first.getNext();
        }
        else {
            TwoLinkedListElement<T> previous = this.getElement(index - 1);
            prevVal = previous.getValue();
            previous.setNext(this.getElement(index + 1));
        }
        return prevVal;
    }

    @Override
    public int indexOf(Object o) {
        if (o==null){
            throw new NullPointerException();
        }
        int index = 0;
        TwoLinkedListElement<T> element = first;
        while (element!=null){
            if (element.getValue().equals(o)){
                return index;
            }
            element = element.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o==null){
            throw new NullPointerException();
        }
        int index = -1, ind=0;
        TwoLinkedListElement<T> element = first;
        while (element!=null){
            if(element.getValue().equals(o)){
                index = ind;
            }
            ind++;
            element = element.getNext();
        }
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }
    //*
    @Override
    public ListIterator<T> listIterator(int index) {
        if ((index<0)||(index>=size())) {
            throw new IndexOutOfBoundsException();
        }
        return new ListIterator<T>() {
            int current = index;
            TwoLinkedListElement<T> currentElement = getElement(index);
            @Override
            public boolean hasNext() {
                return current!=size();
            }

            @Override
            public T next() {
                if (current>=size()||current<0){
                    throw new NoSuchElementException();
                }
                T result = currentElement.getValue();
                current++;
                if (hasNext()) {
                    currentElement = currentElement.getNext();
                }

                return result;
            }

            @Override
            public boolean hasPrevious() {
                return current>0;
            }

            @Override
            public T previous() {
                if (current>=size()||current<0){
                    throw new NoSuchElementException();
                }
                current--;
                T result = currentElement.getValue();
                if (hasPrevious()){
                    currentElement = currentElement.getPrevious();
                }
                return result;
            }

            @Override
            public int nextIndex() {
                return current + 1;
            }

            @Override
            public int previousIndex() {
                return current - 1;
            }

            @Override
            public void remove() {
                if(current==0){
                    first = first.getNext();
                    first.setPrevious(null);
                    return;
                }
                if (current==size()-1)
                {
                    last = currentElement.getPrevious();
                    currentElement.setPrevious(null);
                    current--;
                    last.setNext(null);
                    currentElement = last;
                    return;
                }
                TwoLinkedListElement<T> previous = currentElement.getPrevious();
                previous.setNext(currentElement.getNext());
                currentElement.getNext().setPrevious(previous);
                currentElement = previous.getNext();

            }

            @Override
            public void set(T o) {
                MyTwoLinkedList.this.set(current, o);
            }

            @Override
            public void add(T o) {
                MyTwoLinkedList.this.add(current, o);
                current++;
            }
        };
    }
    //*/

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if ((fromIndex<0)||(fromIndex>=this.size())||(toIndex < fromIndex) || (toIndex>=this.size())){
            throw new IndexOutOfBoundsException();
        }
        MyTwoLinkedList<T> newSubList = new MyTwoLinkedList<>();
        newSubList.addAll(this);
        newSubList.removeAll(toIndex);

        TwoLinkedListElement<T> old = new TwoLinkedListElement<>();
        if (fromIndex>0){
            old = newSubList.getElement(fromIndex-1);
        }
        newSubList.first = newSubList.getElement(fromIndex);

        old.setNext(null);

        return newSubList;
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        TwoLinkedListElement element = first;
        builder.append("[");
        while (element!=null){
            builder.append(" " + element.getValue().toString() + " ");
            element = element.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    public class TwoLinkedListElement<T> {
        private T value;
        private TwoLinkedListElement<T> next;
        private TwoLinkedListElement<T> previous;

        private TwoLinkedListElement() {
        }

        private TwoLinkedListElement(T value, TwoLinkedListElement<T> next, TwoLinkedListElement<T> previous) {
            if (value == null){
                throw new NullPointerException();
            }
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value){
            if (value == null){
                throw new NullPointerException();
            }
            this.value = value;
        }

        public TwoLinkedListElement<T> getNext() {
            return next;
        }

        public void setNext(TwoLinkedListElement<T> next) {
            this.next = next;
        }

        public TwoLinkedListElement<T> getPrevious() {
            return previous;
        }

        public void setPrevious(TwoLinkedListElement<T> previous) {
            this.previous = previous;
        }
    }
}
