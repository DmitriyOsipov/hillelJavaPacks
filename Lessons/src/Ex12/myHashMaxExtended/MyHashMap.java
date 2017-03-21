package Ex12.myHashMaxExtended;


import java.util.*;

public class MyHashMap implements Map {
    private static final int PRIMARY_CAPACITY = 16;
    private int capacity = PRIMARY_CAPACITY;
    private Bucket[] table = new Bucket[capacity];
    private int tableSize = 0;

    public MyHashMap() {
        this(PRIMARY_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        table = new Bucket[capacity];

        for (int i = 0; i < capacity; i++) {
            table[i] = new Bucket();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{\n");

        for (Bucket bucket : table) {
            builder.append("  ");
            builder.append(bucket.toString());
            builder.append(";\n");
        }
        builder.append("}");
        return builder.toString().trim();
    }

    private int calculateIndex(Object key) {
        int result = -1;
        result = Math.abs(key.hashCode()) % capacity;
        return result;
    }

    @Override
    public int size() {
        return tableSize;
    }

    public int getCapacity() {
        return capacity;
    }

    private boolean add(Object key, Object value) {
        int index = this.calculateIndex(key);
        boolean result = table[index].add(key, value);
        if (result) {
            tableSize++;
        }
        return result;
    }

    @Override
    public Object get(Object key) {
        int index = this.calculateIndex(key);
        Object result = table[index].get(key);
        return result;
    }

    private boolean removeElement(Object key) {
        int index = this.calculateIndex(key);
        boolean result = table[index].remove(key);
        if (result) {
            tableSize--;
        }
        return result;
    }

    public void setCapacity(int capacity) {
        table = changeTableCapacity(table, capacity);
    }

    @Override
    public boolean isEmpty() {
        return tableSize==0;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = this.calculateIndex(key);
        boolean result = false;
        Iterator<Bucket.Entity> iterator = table[index].iteratorMapElements();
        while (iterator.hasNext() && !result){
            result = iterator.next().getKey().equals(key);
        }
        return result;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean result = false;
        for (int i=0; i< table.length && !result; i++){
            Iterator<Bucket.Entity> iterator = table[i].iteratorMapElements();
            while (iterator.hasNext() && !result){
                result = iterator.next().getData().equals(value);
            }
        }
        return result;
    }

    @Override
    public Object put(Object key, Object value) {
        Object previousValue = this.get(key);
        this.add(key, value);
        return previousValue;
    }

    @Override
    public void putAll(Map m) {
        for (Object entry: m.entrySet()){
            Entry obj = (Entry)entry;
            this.add(obj.getKey(), obj.getValue());
        }
    }

    @Override
    public void clear() {
        this.tableSize = 0;
        for (int i=0; i<capacity; i++){
            table[i] = new Bucket();
        }
    }

    @Override
    public Set keySet() {
        Set set = new HashSet();
        for (int i=0; i<capacity; i++){
            Iterator<Bucket.Entity> iterator = table[i].iteratorMapElements();
            while (iterator.hasNext()){
                set.add(iterator.next().getKey());
            }
        }
        return set;
    }

    @Override
    public Collection values() {
        Collection collection = new LinkedList();
        for (int i=0; i<capacity; i++){
            Iterator<Bucket.Entity> iterator = table[i].iteratorMapElements();
            while (iterator.hasNext()){
                collection.add(iterator.next().getKey());
            }
        }
        return collection;
    }

    @Override
    public Set<Entry> entrySet() {
        Set set = new HashSet();
        for (int i=0; i<capacity; i++){
            Iterator<Bucket.Entity> iterator = table[i].iteratorMapElements();
            while (iterator.hasNext()){
                set.add(iterator.next());
            }
        }
        return set;
    }

    @Override
    public Object remove(Object key) {
        Object value = this.get(key);
        this.removeElement(key);
        return value;
    }

    private Bucket[] changeTableCapacity(Bucket[] oldTable, int newCapacity) {
        this.capacity = newCapacity;
        int oldCapacity = oldTable.length;
        Bucket[] newTable = new Bucket[newCapacity];

        Class type = oldTable[0].getClass();
        for (int i = 0; i < newCapacity; i++) {
            try {
                newTable[i] = (Bucket) type.newInstance();
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
                this.capacity = oldCapacity;
                return oldTable;
            }
        }

        for (int i = 0; i < oldCapacity; i++) {
            replaceElementsToNewTable(newTable, oldTable[i]);
        }
        return newTable;
    }

    private void replaceElementsToNewTable(Bucket[] elementsTable, Bucket container) {
        Iterator<Bucket.Entity> iterator = container.iteratorMapElements();
        while (iterator.hasNext()) {
            Bucket.Entity element = iterator.next();
            int index = this.calculateIndex(element.getKey());
            elementsTable[index].add(element.getKey(), element.getData());
        }
    }

    private class Bucket {
        List<Entity> cell = new LinkedList<>();

        private Bucket() {
        }


        public Object get(Object key) {
            for (Entity element : cell) {
                if (element.getKey().equals(key)) {
                    return element.getData();
                }
            }
            return null;
        }

        private Entity getElement(Object key) {
            for (Entity element : cell) {
                if (element.getKey().equals(key)) {
                    return element;
                }
            }
            return null;
        }

        private boolean setElement(Object key, Object value) {
            for (Entity element : cell) {
                if (element.getKey().equals(key)) {
                    element.setData(value);
                    return true;
                }
            }
            return false;
        }

        public boolean add(Object key, Object value) {
            boolean result = setElement(key, value);
            if (!result) {
                Entity element = new Entity(key, value);
                cell.add(element);
                result = true;
            }

            return result;
        }


        public boolean remove(Object key) {
            Entity element = getElement(key);
            if (element != null) {
                cell.remove(element);
                return true;
            }
            return false;
        }


        public Iterator<Entity> iteratorMapElements() {
            return new Iterator<Entity>() {
                int current = 0;
                int maxInd = cell.size();

                @Override
                public boolean hasNext() {
                    return (current < maxInd);
                }

                @Override
                public Entity next() {
                    Entity element = cell.get(current);
                    current++;
                    return element;
                }
            };
        }

        private class Entity {
            private final Object key;
            private Object data;

            public Entity(Object key, Object data) {
                this.key = key;
                this.data = data;
            }

            public Object getKey() {
                return key;
            }

            public Object getData() {
                return data;
            }

            public void setData(Object data) {
                this.data = data;
            }

            @Override
            public boolean equals(Object object) {
                if (this == object) return true;
                if (object == null || getClass() != object.getClass()) return false;

                Entity entity = (Entity) object;

                return key.equals(entity.key);
            }

            @Override
            public int hashCode() {
                return key.hashCode();
            }

            @Override
            public String toString() {
                return "{" + "key=" + key + ", data=" + data + '}';
            }
        }
    }
}
