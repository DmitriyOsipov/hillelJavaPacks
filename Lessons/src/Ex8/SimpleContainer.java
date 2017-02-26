package Ex8;

import java.util.Iterator;

public class SimpleContainer implements Iterable{
    private final int PRIMARY_CAPACITY = 100;
    private int capacity = this.PRIMARY_CAPACITY;
    private Object[] container = new Object[capacity];
    private int sizeCont =0;

    public SimpleContainer(){}
    public SimpleContainer(Object element){
        this.add(element);
    }
    public SimpleContainer(Object[] elementsArray){
        this.add(elementsArray);
    }

    private void checkCapacity(int sizeCheck){
        boolean capacityChanged = false;
        while(sizeCheck>=capacity-1) {
            if (capacity < Integer.MAX_VALUE / 2) {
                capacity *= 2;
            } else{
                capacity = (capacity + 1000);
            }
            capacityChanged = true;
        }
        if (capacityChanged) {
            this.reformContainer(capacity);
        }
    }
    private void reformContainer(int newCapacity){
        Object[] array = new Object[newCapacity];
        for (int i = 0; i< sizeCont; i++){
            array[i] = this.container[i];
        }
        this.container = array;
    }
    private void changeSize(int newSize){
        this.sizeCont = newSize;
    }

    public boolean equals(SimpleContainer secondContainer){
        boolean result = false;

        if ((secondContainer != null)&&(this.sizeCont == secondContainer.size())){
            result = true;
            for (int i = 0; ((i<this.sizeCont)&&(result)); i++){
                if(this.container[i].equals(secondContainer.getElement(i))){
                    result=false;
                }
            }
        }
        return result;
    }

    public boolean isEmpty(){
        return this.sizeCont ==0;
    }

    public Object getElement(int index){
        if ((index>=0)&&(index< sizeCont)){
            return this.container[index];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(Object value){
        this.checkCapacity(sizeCont);
        this.container[sizeCont] = value;
        this.changeSize(sizeCont + 1);
    }

    public void add(Object[] values){
        this.checkCapacity(this.sizeCont + values.length);
        int containerIndex = this.sizeCont;
        for(int i=0; i<values.length; i++){
            this.container[containerIndex] = values[i];
            containerIndex++;
        }
        this.changeSize(this.sizeCont + values.length);
    }

    public int size(){
        return sizeCont;
    }


    public int indexOf(Object value){
        int index=-1;
        for (int i = 0; ((i<this.sizeCont)&&(index==-1)); i++){
            if(this.container[i].equals(value)){
                index = i;
            }
        }
        return index;
    }

    public boolean contains(Object value){
        if (this.indexOf(value)>=0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean containsAll(SimpleContainer anotherContainer){
        boolean result = false;
        if (this.size()>=anotherContainer.size()) {
            result = true;
            for (int i = 0; ((i<anotherContainer.size())&&(result)); i++){
                if (this.indexOf(anotherContainer.getElement(i))==-1){
                    result = false;
                }
            }
        }
        return result;
    }

       public void join(SimpleContainer secondContainer){
        this.add(secondContainer.container);
    }

    public void delete(){
        if(sizeCont >0) {
            this.changeSize(sizeCont - 1);
        }
    }

    public void delete(int index){
        if((sizeCont >0)&&(index>=0)&&(index< sizeCont)){
            this.trim(index);
            this.changeSize(sizeCont - 1);
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void remove(Object object){
        int index = -1;
        do{
            index = this.indexOf(object);
            if (index!=-1){
                this.delete(index);
            }
        }while (index!=-1);
    }

    public void removeAll(SimpleContainer collection){
        for (Object element: collection.container){
            this.remove(element);
        }
    }

    public boolean retainAll(SimpleContainer collection){
        boolean result = false;
        for (int i = 0; i<this.sizeCont; i++){
            if (!collection.contains(this.container[i])){
                this.remove(this.container[i]);
                result = true;
            }
        }
        return result;
    }

    private void trim(int index){
        for(int i = index; i< sizeCont -1; i++){
            this.container[i] = this.container[i+1];
        }
    }

    public void trimAll(){
        Object[] temp = this.container;
        this.capacity = this.sizeCont;
        this.container = new Object[capacity];

        for (int i = 0; i<this.sizeCont; i++){
            this.container[i] = temp[i];
        }
    }

    public void clear(){
        this.container = new Object[PRIMARY_CAPACITY];
        this.changeSize(0);
        this.capacity = PRIMARY_CAPACITY;
    }



    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (this.sizeCont >0) {
            for (int i = 0; i < this.sizeCont - 1; i++) {
                stringBuilder.append(this.container[i].toString() + "  ");
            }
            stringBuilder.append(this.container[this.sizeCont - 1].toString());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int current=0;
            @Override
            public boolean hasNext() {
                return (current< size());
            }

            @Override
            public Object next() {
                Object result = container[current];
                current++;
                return result;
            }
        };
    }
}
