package Ex8_2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class MyTwoLinkedList implements List{

    private TwoLinkedListElement first = null;
    private TwoLinkedListElement last = null;
    private int sizeList = 0;
    private boolean sizeChanged = false;

    public MyTwoLinkedList(){

    }
    public MyTwoLinkedList(Object object){
        this.add(object);
    }


    boolean equals(MyTwoLinkedList list){
        if (list == this){
            return true;
        }
        if (list.size()!=this.size()){
            return false;
        }
        TwoLinkedListElement elementThis = this.first;
        TwoLinkedListElement elementInput = list.first;
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
        if (sizeChanged){
            this.sizeList = 0;
            TwoLinkedListElement element = first;
            while (element !=null){
                sizeList++;
                element = element.getNext();
            }
            sizeChanged = false;
        }
        return sizeList;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public boolean contains(Object o) {
        TwoLinkedListElement element = first;
        while(element!=null){
            if (element.getValue().equals(o)){
                return true;
            }
            element = element.getNext();
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            TwoLinkedListElement current = first;
            TwoLinkedListElement previous = current.getPrevious();

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

        int ind=0;
        for (Object object:this){
            result[ind] = object;
            ind++;
        }

        return result;
    }

    @Override
    public boolean add(Object object) {
        boolean result = false;
        try {
            TwoLinkedListElement newElement = new TwoLinkedListElement(object, null, null);
            if (last == null) {
                this.first = newElement;
                this.last = newElement;
            } else {
                newElement.setPrevious(last);
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

    public boolean addLeft(Object object){
        boolean result = false;
        try {
            TwoLinkedListElement newElement = new TwoLinkedListElement(object, null, null);
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
            sizeChanged = true;
        }
        catch (Exception ex){
            result = false;
        }
        return result;
    }

    @Override
    public boolean remove(Object object) {
        TwoLinkedListElement element = first;
        TwoLinkedListElement previous = element.getPrevious();
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
                sizeChanged=true;
            }
            previous = element;
            element = element.getNext();
        }
        return result;
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

    public boolean containsAllListElement(TwoLinkedListElement inputElement){
        while (inputElement != null) {
            if (!this.contains(inputElement.getValue())) {
                return false;
            }
            inputElement = inputElement.getNext();
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] objects = c.toArray();
        boolean res = true;
        for(int i=0; ((i<objects.length) && res); i++){
            res = this.add(objects[i]);
        }
        return res;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        boolean res = false;
        if ((index<0)||(index>=this.size())){
            throw new IndexOutOfBoundsException();
        }
        if (c==null){
            return res;
        }
        TwoLinkedListElement indexElement = this.getElement(index);
        TwoLinkedListElement tmpLast = last;
        last = this.getElement(index - 1);
        res = this.addAll(c);
        last.setNext(indexElement);
        indexElement.setPrevious(last);
        last = tmpLast;

        return res;
    }

    @Override
    public boolean removeAll(Collection c) {
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
        TwoLinkedListElement prev = (fromIndex>0)? this.getElement(fromIndex-1):null;
        this.last = this.getElement(fromIndex);
        this.last.setPrevious(prev);
        this.last.setNext(null);
        result = true;

        return result;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean result = false;
        TwoLinkedListElement element = this.first;
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
        //first.setNext(null);
        first = null;
        last = first;
        this.sizeChanged = true;
        this.sizeList = 0;
    }

    @Override
    public Object get(int index) {
        return this.getElement(index).getValue();
    }

    public TwoLinkedListElement getElement(int index){
        TwoLinkedListElement retElement = null;
        if ((index<0)||(index>=this.size())){
            throw new IndexOutOfBoundsException();
        }
        else{
            int ind=0;
            TwoLinkedListElement element = first;
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
    public Object set(int index, Object element) {
        if ((index<0)||(index>this.size())){
            throw new IndexOutOfBoundsException();
        }

        TwoLinkedListElement linkedListElement = this.getElement(index);
        Object prevValue = linkedListElement.getValue();
        linkedListElement.setValue(element);

        return prevValue;
    }

    @Override
    public void add(int index, Object element) {
        if ((index<0)||(index>=this.size())){
            throw new IndexOutOfBoundsException();
        }
        else {
            if (index == 0){
                this.addLeft(element);
            }
            else {
                TwoLinkedListElement elementToInsert = new TwoLinkedListElement(element, this.getElement(index), null);
                TwoLinkedListElement previous = this.getElement(index - 1);
                TwoLinkedListElement nextEl = previous.getNext();
                previous.setNext(elementToInsert);
                elementToInsert.setPrevious(previous);
                nextEl.setPrevious(elementToInsert);
            }
        }
    }

    @Override
    public Object remove(int index) {
        Object prevVal = null;
        if (index==0){
            first = first.getNext();
        }
        else {
            TwoLinkedListElement previous = this.getElement(index - 1);
            prevVal = previous.getValue();
            previous.setNext(this.getElement(index + 1));
        }
        return prevVal;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        TwoLinkedListElement element = first;
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
        int index = -1, ind=0;
        TwoLinkedListElement element = first;
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
    public ListIterator listIterator() {
        return listIterator(0);
    }
    //*
    @Override
    public ListIterator listIterator(int index) {
        if ((index<0)||(index>=size())) {
            throw new IndexOutOfBoundsException();
        }
        return new ListIterator() {
            int current = index;
            TwoLinkedListElement currentElement = getElement(index);
            @Override
            public boolean hasNext() {
                return current!=size();
            }

            @Override
            public Object next() {
                Object result = currentElement.getValue();
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
            public Object previous() {
                current--;
                Object result = currentElement.getValue();
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
                TwoLinkedListElement previous = currentElement.getPrevious();
                previous.setNext(currentElement.getNext());
                currentElement.getNext().setPrevious(previous);
                currentElement = previous.getNext();

            }

            @Override
            public void set(Object o) {
                MyTwoLinkedList.this.set(current, o);
            }

            @Override
            public void add(Object o) {
                MyTwoLinkedList.this.add(current, o);
                current++;
            }
        };
    }
    //*/

    @Override
    public List subList(int fromIndex, int toIndex) {
        if ((fromIndex<0)||(fromIndex>=this.size())||(toIndex < fromIndex) || (toIndex>=this.size())){
            throw new IndexOutOfBoundsException();
        }
        MyTwoLinkedList newSubList = new MyTwoLinkedList();
        newSubList.addAll(this);
        newSubList.removeAll(toIndex);

        TwoLinkedListElement old = new TwoLinkedListElement(null, null, null);
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
}
