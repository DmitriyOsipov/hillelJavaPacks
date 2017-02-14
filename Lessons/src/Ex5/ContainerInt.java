package Ex5;

/**
 * Created by mtzadmin on 14.02.2017.
 */
public class ContainerInt {
    private int[] container;

    public ContainerInt(int firstElemetValue){
        this.add(firstElemetValue);
    }
    public ContainerInt(int[] array){
        this.container = array.clone();
    }

    private boolean isNull(){
        return (this.container == null);
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
        if ((!this.isEmpty()) && (indexValue >= 0) && (indexValue < this.container.length)){
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

    public void clear(){
        this.container = null;
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

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (!this.isEmpty()) {
            for (int i = 0; i < this.getSize() - 1; i++) {
                stringBuilder.append(this.container[i] + ", ");
            }
            stringBuilder.append(this.container[this.getSize() - 1]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
