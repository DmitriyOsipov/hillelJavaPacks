package Ex5_redone;


public class ContainerInt {
    private final int PRIMARY_CAPACITY = 100;
    private int capacity = this.PRIMARY_CAPACITY;
    private int[] container = new int[capacity];
    private int size=0;
    private double sum=0;
    private boolean containerChanged = true;

    public ContainerInt(){

    }
    public ContainerInt(int elementValue){
        this.add(elementValue);
    }
    public ContainerInt(int[] array){
        this.add(array);
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
        int[] array = new int[newCapacity];
        for (int i=0; i<size; i++){
            array[i] = this.container[i];
        }
        this.container = array;
    }
    private void changeSize(int newSize){
        this.size = newSize;
        this.containerChanged = true;
    }

    public boolean equals(ContainerInt secondContainer){
        boolean result = false;

        if ((secondContainer != null)&&(this.size == secondContainer.getSize())){
            result = true;
            for (int i=0; ((i<this.size)&&(result)); i++){
                if(this.container[i]!=secondContainer.getElement(i)){
                    result=false;
                }
            }
        }
        return result;
    }

    public ContainerInt getCopy(){
        return new ContainerInt(this.container);
    }

    public void clear(){
        this.container = new int[this.PRIMARY_CAPACITY];
        this.changeSize(0);
    }

    public int getElement(int index){
        int result = Integer.MIN_VALUE;
        if ((index>=0)&&(index<size)){
            result = this.container[index];
        }
        else {
            throw new IndexOutOfBoundsException();
        }
        return result;
    }

    public void add(int value){
        this.checkCapacity(size);
        this.container[size] = value;
        this.changeSize(size + 1);
    }

    public void add(int[] values){
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

    public double getSum() {
        if (this.containerChanged){
            this.sum = 0;
            for (int i=0; i<size; i++){
                sum+=this.container[i];
            }
            this.containerChanged = false;
        }
        return sum;
    }

    public double getAverage(){
        double avg = this.getSum()/this.size;
        return avg;
    }

    public int indexOf(int value){
        int index=-1;
        for (int i=0; ((i<this.size)&&(index==-1)); i++){
            if(this.container[i]==value){
                 index = i;
            }
        }
        return index;
    }

    public boolean contains(int value){
        if (this.indexOf(value)>=0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean containsAll(ContainerInt anotherContainer){
        boolean result = false;

        if (this.getSize()>=anotherContainer.getSize()) {
            int[] array = anotherContainer.getArrayCopy();
            result = true;
            for (int i=0; ((i<anotherContainer.getSize())&&(result)); i++){
                if (this.indexOf(array[i])==-1){
                    result = false;
                }
            }
        }
        return result;
    }

    public int max(){
        int max = Integer.MIN_VALUE;
        if (size>0){
            max = this.container[0];
            for(int element:this.container){
                if (max < element){
                    max = element;
                }
            }
        }
        else{
            throw new ArrayIndexOutOfBoundsException("Container is empty");
        }
        return max;
    }

    public int min(){
        int min = Integer.MIN_VALUE;
        if (size>0){
            min = this.container[0];
            for(int element:this.container){
                if (min > element){
                    min = element;
                }
            }
        }
        else{
            throw new ArrayIndexOutOfBoundsException("Container is empty");
        }
        return min;
    }

    public int[] getArrayCopy(){
        int[] array = new int[this.size];
        for(int i=0; i<size; i++){
            array[i] = this.container[i];
        }
        return array;
    }

    public void join(ContainerInt secondContainer){
        this.add(secondContainer.getArrayCopy());
    }

    public void delete(){
        if(size>0) {
            this.changeSize(size - 1);
            this.containerChanged = true;
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

    private void trim(int index){
        for(int i=index; i<size-1; i++){
            this.container[i] = this.container[i+1];
        }
    }

    public void sort(){
        this.quickSort(0, this.size-1);
    }

    public void bubbleSort(){
        boolean change;
        int op=0;
        do {
            change = false;
            //*
            for (int i = 1; i < this.size - 1 - op; i++) {
                if (this.container[i - 1] > this.container[i]) {
                    int temp = this.container[i];
                    this.container[i] = this.container[i - 1];
                    this.container[i-1] = temp;
                    change = true;
                }
            }
            //*/
            op++;
        } while (change);
    }

    private void quickSort(int start, int end){
        if(start>=end){
            return;
        }
        int i=start, j=end;
        int center = i-(i-j)/2;
        while(i<j){
            while ((i<center)&&(this.container[i]<=this.container[center])) {
                i++;
            }
            while ((j>center)&&(this.container[j]>=this.container[center])){
                j--;
            }
            if (i<j){
                int temp = this.container[i];
                this.container[i]=this.container[j];
                this.container[j] = temp;
                if (i==center){
                    center=j;
                }
                else if(j==center){
                    center = i;
                }
            }
        }
        quickSort(start, center);
        quickSort(center+1, end);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (this.size>0) {
            for (int i = 0; i < this.size - 1; i++) {
                stringBuilder.append(this.container[i] + "  ");
            }
            stringBuilder.append(this.container[this.size - 1]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
