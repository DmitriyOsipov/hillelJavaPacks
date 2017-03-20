package Ex11.hashMap;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap {
    private static final int PRIMARY_CAPACITY = 8;
    private int capacity;
    private MyMapInOutable[] table;

    public MyHashMap() {
        this(PRIMARY_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        table = new Bucket[capacity];

        for (int i=0; i<capacity; i++){
            table[i] = new Bucket();
        }
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
        table = changeTableCapacity(table, capacity);
    }

    private MyMapInOutable[] changeTableCapacity(MyMapInOutable[] oldTable, int newCapacity){
        this.capacity = newCapacity;
        int oldCapacity = oldTable.length;
        MyMapInOutable[] newTable = new MyMapInOutable[newCapacity];

        Class type = oldTable[0].getClass();
        for (int i=0; i<newCapacity; i++){
            try {
                newTable[i] = (MyMapInOutable) type.newInstance();
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
                this.capacity = oldCapacity;
                return oldTable;
            }
        }

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




    private class Bucket implements MyMapInOutable {
        List<MyMapElement> cell = new LinkedList<>();

        private Bucket(){}

        @Override
        public Object get(Object key){
            for (MyMapElement element:cell){
                if (element.getKey().equals(key)){
                    return element.getData();
                }
            }
            return null;
        }

        private MyMapElement getElement(Object key){
            for (MyMapElement element:cell){
                if (element.getKey().equals(key)){
                    return element;
                }
            }
            return null;
        }

        private boolean setElement(Object key, Object value){
            for (MyMapElement element:cell){
                if (element.getKey().equals(key)){
                    element.setData(value);
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean add(Object key, Object value){
            boolean result = setElement(key, value);
            if (!result){
                CellElement element = new CellElement(key, value);
                cell.add(element);
                result = true;
            }

            return result;
        }

        @Override
        public boolean remove(Object key) {
            MyMapElement element = getElement(key);
            if (element!=null){
                cell.remove(element);
                return true;
            }
            return false;
        }

        @Override
        public Iterator<MyMapElement> iteratorMapElements() {
            return new Iterator<MyMapElement>() {
                int current = 0;
                int maxInd = cell.size();
                @Override
                public boolean hasNext() {
                    return (current<maxInd);
                }

                @Override
                public MyMapElement next() {
                    MyMapElement element = cell.get(current);
                    current++;
                    return element;
                }
            };
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder("[");

            for (MyMapElement element:cell){
                builder.append(" \"" + element.getKey() + "\" -> " + element.getData());
                builder.append(";");
            }

            builder.append("]");

            return builder.toString();
        }
    }

    private class CellElement extends MyMapElement{
        Object key;
        Object data;

        private CellElement(Object key, Object value) {
            this.key = key;
            this.data = value;
        }

        public Object getKey() {
            return key;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object value) {
            this.data = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CellElement that = (CellElement) o;

            return key != null ? key.equals(that.key) : that.key == null;
        }

        @Override
        public int hashCode() {
            return key != null ? key.hashCode() : 0;
        }
    }
}
