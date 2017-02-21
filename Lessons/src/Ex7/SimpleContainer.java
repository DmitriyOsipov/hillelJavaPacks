package Ex7;

/**
 * Created by mtzadmin on 21.02.2017.
 */
public class SimpleContainer {
    private final int PRIMARY_CAPACITY = 100;
    private int capacity = this.PRIMARY_CAPACITY;
    private Object[] container = new Object[capacity];
    private int size=0;

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
        for (int i=0; i<size; i++){
            array[i] = this.container[i];
        }
        this.container = array;
    }
    private void changeSize(int newSize){
        this.size = newSize;
    }

    public boolean equals(SimpleContainer secondContainer){
        boolean result = false;

        if ((secondContainer != null)&&(this.size == secondContainer.getSize())){
            result = true;
            for (int i=0; ((i<this.size)&&(result)); i++){
                if(this.container[i].equals(secondContainer.getElement(i))){
                    result=false;
                }
            }
        }
        return result;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public Object getElement(int index){
        if ((index>=0)&&(index<size)){
            return this.container[index];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void add(Object value){
        this.checkCapacity(size);
        this.container[size] = value;
        this.changeSize(size + 1);
    }

    public void add(Object[] values){
        this.checkCapacity(this.size + values.length);
        int containerIndex = this.size;
        for(int i=0; i<values.length; i++){
            this.container[containerIndex] = values[i];
            containerIndex++;
        }
        this.changeSize(this.size + values.length);
    }

    public int getSize(){
        return size;
    }


    public int indexOf(Object value){
        int index=-1;
        for (int i=0; ((i<this.size)&&(index==-1)); i++){
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
        if (this.getSize()>=anotherContainer.getSize()) {
            result = true;
            for (int i=0; ((i<anotherContainer.getSize())&&(result)); i++){
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
        if(size>0) {
            this.changeSize(size - 1);
        }
    }

    public void delete(int index){
        if((size>0)&&(index>=0)&&(index<size)){
            this.trim(index);
            this.changeSize(size - 1);
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
        for (int i=0; i<this.size; i++){
            if (!collection.contains(this.container[i])){
                this.remove(this.container[i]);
                result = true;
            }
        }
        return result;
    }

    private void trim(int index){
        for(int i=index; i<size-1; i++){
            this.container[i] = this.container[i+1];
        }
    }

    public void trimAll(){
        Object[] temp = this.container;
        this.capacity = this.size;
        this.container = new Object[capacity];

        for (int i =0; i<this.size; i++){
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
        if (this.size>0) {
            for (int i = 0; i < this.size - 1; i++) {
                stringBuilder.append(this.container[i].toString() + "  ");
            }
            stringBuilder.append(this.container[this.size - 1].toString());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
