package Ex8_2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class MyLinkedList implements List{

    private LinkedListElement first = null;
    private LinkedListElement last = null;
    private int sizeList = 0;
    private boolean sizeChanged = false;

    public MyLinkedList(){

    }
    public MyLinkedList(Object object){
        this.add(object);
    }

    @Override
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
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public boolean contains(Object o) {
        LinkedListElement element = first;
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

    public boolean addLeft(Object object){
        boolean result = false;
        try {
            LinkedListElement newElement = new LinkedListElement(object, null);
            if (last == null) {
                this.first = newElement;
                this.last = newElement;
            } else {
                newElement.setNext(first);
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

    public boolean containsAllListElement(LinkedListElement inputElement){
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
    public boolean addAll(MyLinkedList list){
        try {
            if (last == null){
                this.first = list.first;
                this.last = list.last;
            }
            this.last.setNext(list.first);
            this.last = list.last;
            this.sizeChanged = true;
        }
        catch (Exception ex){
            return false;
        }
        return true;
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
        LinkedListElement indexElement = this.getElement(index);
        LinkedListElement tmpLast = last;
        last = this.getElement(index - 1);
        res = this.addAll(c);
        last.setNext(indexElement);
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
        this.last = this.getElement(fromIndex);
        this.last.setNext(null);
        result = true;

        return result;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean result = false;
        LinkedListElement element = this.first;
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
        first.setNext(null);
        last = first;
        this.sizeChanged = true;
        this.sizeList = 0;
    }

    @Override
    public Object get(int index) {
        return this.getElement(index).getValue();
    }

    public LinkedListElement getElement(int index){
        LinkedListElement retElement = null;
        if ((index<0)||(index>=this.size())){
            throw new IndexOutOfBoundsException();
        }
        else{
            int ind=0;
            LinkedListElement element = first;
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

        LinkedListElement linkedListElement = this.getElement(index);
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
                LinkedListElement elementToInsert = new LinkedListElement(element, this.getElement(index));
                LinkedListElement previous = this.getElement(index - 1);
                previous.setNext(elementToInsert);
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
            LinkedListElement previous = this.getElement(index - 1);
            prevVal = previous.getValue();
            previous.setNext(this.getElement(index + 1));
        }
        return prevVal;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        LinkedListElement element = first;
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
        LinkedListElement element = first;
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
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        if ((fromIndex<0)||(fromIndex>=this.size())||(toIndex < fromIndex) || (toIndex>=this.size())){
            throw new IndexOutOfBoundsException();
        }
        MyLinkedList newSubList = new MyLinkedList();
        newSubList.addAll(this);
        newSubList.removeAll(toIndex-1);
        newSubList.first = newSubList.getElement(fromIndex);
        if (fromIndex>0){
            newSubList.getElement(fromIndex-1).setNext(null);
        }

        return newSubList;
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
}
