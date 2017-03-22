package Ex12.myHashMaxExtended;


import java.util.*;

public class MyHashMap implements Map{
    private final int PRIMARY_CAPACITY = 16;
    private int capacity = PRIMARY_CAPACITY;
    private int size = 0;
    private List<Entry>[] table = new LinkedList[capacity];

    private int calculateIndex(Object key){
        return  Math.abs(key.hashCode()) % capacity;
    }

    private boolean addEntry(Object key, Object value){
        int index = calculateIndex(key);
        Entry newEntry = new Entry(key, value);
        boolean result = false;

        if (table[index] == null){
            table[index] = new LinkedList<Entry>();
        }
        if (!table[index].contains(newEntry)){
            table[index].add(newEntry);
        }
        else {
            int existedIndex = table[index].indexOf(newEntry);
            table[index].get(existedIndex).setValue(value);
        }
        result = true;
        if (result){
            size++;
        }
        return result;
    }

    private Entry getEntry(Object key){
        int bucketIndex = calculateIndex(key);
        int index = -1;
        if (table[bucketIndex]!=null) {
            index = table[bucketIndex].indexOf(new Entry(key, null));
        }
        return (index>-1) ? table[bucketIndex].get(index) : null;
    }

    private Entry removeEntry(Object key){
        Entry result = null;
        int bucketIndex = calculateIndex(key);
        int index = table[bucketIndex].indexOf(new Entry(key, null));
        if (index>-1){
            result = table[bucketIndex].remove(index);
            if (result!=null){
                size--;
            }
        }
        return result;
    }

    private List<Entry>[] changeCapacity(List<Entry>[] oldTable, int newCapacity){
        List<Entry>[] newTable = new List[newCapacity];
        Set<Map.Entry> entrySet = this.entrySet();
        //int oldSize = size;
        //int oldCapacity = capacity;
        this.table = newTable;
        this.capacity = newCapacity;
        this.size = 0;

        for (Map.Entry entry : entrySet){
            this.addEntry(entry.getKey(), entry.getValue());
        }
        return oldTable;
    }

    public void setCapacity(int capacity) {
        changeCapacity(this.table, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean containsKey(Object key) {
        int bucketIndex = calculateIndex(key);
        if (table[bucketIndex]!=null) {
            return table[bucketIndex].contains(new Entry(key, null));
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(int i=0; i<capacity; i++){
            if (table[i]!=null) {
                for (Entry entry : table[i]) {
                    if (entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        Entry entry = this.getEntry(key);
        return (entry!=null) ? entry.getValue() : null;
    }

    @Override
    public Object put(Object key, Object value) {
        Entry entry = this.getEntry(key);
        this.addEntry(key, value);
        return (entry!=null)? entry.getValue() : null;
    }

    @Override
    public Object remove(Object key) {
        Entry removed = this.removeEntry(key);
        return (removed!=null) ? removed.getValue() : null;
    }


    @Override
    public void putAll(Map m) {
        for (Object entry: m.entrySet()){
            Entry obj = (Entry)entry;
            this.addEntry(obj.getKey(), obj.getValue());
        }
    }

    @Override
    public void clear() {
        this.size = 0;
        for (int i=0; i<capacity; i++){
            table[i] = null;
        }
    }


    @Override
    public Set keySet() {
        Set set = new HashSet();
        for (int i=0; i<capacity; i++){
            if (table[i]!=null) {
                for (Entry entry : table[i]) {
                    set.add(entry.getKey());
                }
            }
        }
        return set;
    }

    @Override
    public Set<Map.Entry> entrySet() {
        Set<Map.Entry> set = new HashSet<>();
        for (int i=0; i<capacity; i++){
            if (table[i]!=null) {
                for (Entry entry : table[i]) {
                    set.add(entry);
                }
            }
        }
        return set;
    }

    @Override
    public Collection values() {
        Collection vCollection = new LinkedList();
        for (int i=0; i<capacity; i++){
            if (table[i]!=null) {
                for (Entry entry : table[i]) {
                    vCollection.add(entry.getValue());
                }
            }
        }
        return vCollection;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        for (int i=0; i<capacity; i++){
            builder.append("\n\t");
            builder.append(table[i]);
            builder.append(',');
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("\n}");
        return builder.toString();
    }

    private class Entry implements Map.Entry{
        private final Object key;
        private Object value;

        public Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public Object setValue(Object value) {
            Object oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            Entry entry = (Entry) object;

            return key != null ? key.equals(entry.key) : entry.key == null;
        }

        @Override
        public int hashCode() {
            return key != null ? key.hashCode() : 0;
        }

        @Override
        public String toString() {
            //return '{' + "key=" + key + ", value=" + value + '}';
            return "{\"" + key + "\" -> " + value + '}';
        }
    }
}
