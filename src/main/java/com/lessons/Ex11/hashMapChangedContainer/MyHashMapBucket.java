package com.lessons.Ex11.hashMapChangedContainer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashMapBucket implements MyMapInOutable {
        List<MyMapElement> cell = new LinkedList<>();

        public MyHashMapBucket(){}

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
