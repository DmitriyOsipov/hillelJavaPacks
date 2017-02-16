package Ex5;

/**
 * Created by mtzadmin on 14.02.2017.
 */
public class ContainerInt {
    private int[] container;

    public ContainerInt(){
        this.container = new int[0];
    }
    public ContainerInt(int firstElementValue){
        this.add(firstElementValue);
    }
    public ContainerInt(int[] array){
        this.container = array.clone();
    }

    private boolean isNull(){
        if (this.container == null){
            this.container = new int[0];
            return true;
        }
        else {
            return false;
        }
    }
    private boolean isEmpty(){
        return this.isEmpty(false);
    }
    private boolean isEmpty(boolean showMsg){
        boolean result;
        if ((this.isNull())||(this.container.length == 0)){
            result = true;
            if (showMsg) {
                System.out.println("Container is empty.");
            }
        }
        else {
            result = false;
        }
        return result;
    }
    private boolean checkIndex(int indexValue){
        boolean result;
        if ((!this.isEmpty(true)) && (indexValue >= 0) && (indexValue < this.container.length)){
            result = true;
        }
        else {
            result = false;
            System.out.println("Index out of bound");
        }
        return result;
    }

    public void add(int value){
        int oldSize;
        if (this.isNull()){
            oldSize = 0;
        }
        else {
            oldSize = this.container.length;
        }
        int[] array = new int[oldSize + 1];
        for (int i=0; i<oldSize; i++){
            array[i] = this.container[i];
        }
        array[oldSize] = value;
        this.container = array;
    }

    public int getElement(int index){
        int result;
        if (this.checkIndex(index)){
            result = this.container[index];
        }
        else {
            result = Integer.MIN_VALUE;
        }
        return result;
    }

    public int getSize(){
        if (this.isNull()){
            return 0;
        }
        else {
            return this.container.length;
        }
    }

    public ContainerInt clone(){
        return new ContainerInt(this.getArrayCopy());
    }

    public void clear(){
        this.container = new int[0];
    }

    public boolean contains(int value){
        if (this.indexOf(value)>=0){
            return true;
        }
        else{
            return false;
        }
    }

    public void delete(int index){
        if (this.checkIndex(index)) {
            int[] array = new int[this.container.length - 1];
            int newIndex=0;
            for (int i=0; i<this.container.length; i++){
                if (i!=index){
                    array[newIndex] = this.container[i];
                    newIndex++;
                }
            }
            this.container = array;
        }
    }

    public int max(){
        int result = this.container[0];
        for (int element:
            this.container) {
            if (element>result){
                result = element;
            }
        }
        return result;
    }

    public int min(){
        int result = this.container[0];
        for (int element:
             this.container) {
            if (element<result){
                result = element;
            }
        }
        return result;
    }

    public int indexOf(int value){
        int result = -1;
        for (int i=0; ((i<this.container.length)&&(result == -1)); i++){
            if (this.container[i]==value){
                result = i;

            }
        }
        return result;
    }

    public int[] getArrayCopy(){
        int[] copyArray = new int[this.getSize()];
        if (this.getSize()>0){
            for (int i=0; i<this.getSize(); i++){
                copyArray[i] = this.container[i];
            }
        }
        return copyArray;
    }

    public void join(ContainerInt containerInt){
        for (int element:
             containerInt.getArrayCopy()) {
            this.add(element);
        }
    }

    public boolean equals(ContainerInt containerInt){
        boolean result=true;
        if (this.getSize()!=containerInt.getSize()){
            result = false;
        }
        else{
            int[] secondArray = containerInt.getArrayCopy();
            for (int i=0; ((i < this.getSize())&&(result)); i++){
                if (this.container[i]!=secondArray[i]){
                    result = false;
                }
            }
        }
        return result;
    }

    public double getSum(){
        double result = 0;
        for (int element: this.container){
            result+=element;
        }
        return result;
    }

    public double getAverage(){
        return this.getSum()/this.getSize();
    }

    public int count(int what){
        int result = 0;
        for (int element : this.container){
            if (element==what){
                result++;
            }
        }
        return result;
    }

    public void sort(){
        if(!this.isEmpty()){
            this.quickSort(0, this.getSize()-1);
        }
    }

    public void bubbleSort(){
        if (!this.isEmpty()) {
            boolean change;
            int op=0;
            do {
                change = false;
                for (int i = 1; i < this.getSize(); i++) {
                    if (this.container[i - 1] > this.container[i]) {
                        int temp = this.container[i];
                        this.container[i] = this.container[i - 1];
                        this.container[i-1] = temp;
                        change = true;
                    }
                }
                op++;
                /*
                if (op%10_000==0){
                    System.out.println(op);
                }//*/
            } while (change);
        }
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

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (!this.isEmpty()) {
            for (int i = 0; i < this.getSize() - 1; i++) {
                stringBuilder.append(this.container[i] + "  ");
            }
            stringBuilder.append(this.container[this.getSize() - 1]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
