package Ex11.hashMapChangedContainer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap {

    private int capacity;
    private MyMapInOutable[] table;


    public MyHashMap(MyMapInOutable[] table) {
        this.table = table;
        this.capacity = table.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{\n");

        for (MyMapInOutable bucket: table){
            builder.append("  ");
            builder.append(bucket.toString());
            builder.append(";\n");
        }
        builder.append("}");
        return builder.toString().trim();
    }

    private int calculateIndex(Object key){
        int result = -1;
        result = Math.abs(key.hashCode())%capacity;
        return result;
    }

    public long size(){
        long count = 0;
        for (int i=0; i<capacity; i++){
            Iterator<MyMapElement> elementIterator = table[i].iteratorMapElements();
            while (elementIterator.hasNext()){
                count++;
                elementIterator.next();
            }
        }
        return count;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean add(Object key, Object value){
        int index = this.calculateIndex(key);
        boolean result = table[index].add(key, value);
        return result;
    }

    public Object get(Object key){
        int index = this.calculateIndex(key);
        Object result = table[index].get(key);
        return result;
    }

    public boolean remove(Object key){
        int index = this.calculateIndex(key);
        boolean result = table[index].remove(key);
        return result;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
        table = changeTableCapacity(table, capacity);
    }

    private MyMapInOutable[] changeTableCapacity(MyMapInOutable[] oldTable, int newCapacity){
        int oldCapacity = oldTable.length;
        MyMapInOutable[] newTable = new MyMapInOutable[newCapacity];

        for (int i=0; i<oldCapacity; i++){
            replaceElementsToNewTable(newTable, oldTable[i]);
        }
        return newTable;
    }

    private void replaceElementsToNewTable(MyMapInOutable[] elementsTable, MyMapInOutable container){
        Iterator<MyMapElement> iterator = container.iteratorMapElements();
        while (iterator.hasNext()){
            MyMapElement element = iterator.next();
            int index = this.calculateIndex(element.getKey());
            elementsTable[index].add(element.getKey(),element.getData());
        }
    }





}
