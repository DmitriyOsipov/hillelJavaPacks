package Ex12.MyHashMapGenericTypes;

import java.util.*;

public class MyHashMap<K, V> implements Map<K, V>{
    private final static int PRIMARY_CAPACITY = 16;
    private int capacity;
    private int size = 0;
    private List<Entry<K,V>>[] table;

    public MyHashMap() {
       this(PRIMARY_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
    }

    private int calculateIndex(Object key){
        return  Math.abs(key.hashCode()) % capacity;
    }

    private boolean addEntry(K key, V value){
        int index = calculateIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value);
        boolean result = false;

        try {
            if (table[index] == null) {
                table[index] = new LinkedList<Entry<K, V>>();
            }
            if (!table[index].contains(newEntry)) {
                table[index].add(newEntry);
            } else {
                int existedIndex = table[index].indexOf(newEntry);
                table[index].get(existedIndex).setValue(value);
            }
            result = true;
        }
        catch (Exception e){}
        if (result){
            size++;
        }
        return result;
    }

    private Entry<K, V> getEntry(Object key){
        int bucketIndex = calculateIndex(key);
        K castedKey = (K)key;
        int index = -1;
        if (table[bucketIndex]!=null) {
            index = table[bucketIndex].indexOf(new Entry<K, V>(castedKey, null));
        }
        return (index>-1) ? table[bucketIndex].get(index) : null;
    }

    private Entry<K,V> removeEntry(Object key){
        Entry<K,V> result = null;
        K castedKey = (K)key;
        int bucketIndex = calculateIndex(key);
        Entry<K,V> checkedEntry = new Entry<>(castedKey, null);
        int index = table[bucketIndex].indexOf(checkedEntry);
        if (index>-1){
            result = table[bucketIndex].remove(index);
            if (result!=null){
                size--;
            }
        }
        return result;
    }

    private List<Entry<K,V>>[] changeCapacity(List<Entry<K,V>>[] oldTable, int newCapacity){
        List<Entry<K,V>>[] newTable = new List[newCapacity];
        Set<Map.Entry<K,V>> entrySet = this.entrySet();
        this.table = newTable;
        this.capacity = newCapacity;
        this.size = 0;

        for (Map.Entry<K,V> entry : entrySet){
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

    /*
    @Override
    public boolean containsKey(Object key) {
        int bucketIndex = calculateIndex(key);
        K castedKey = (K)key;
        if (table[bucketIndex]!=null) {
            return table[bucketIndex].contains(new Entry(castedKey, null));
        }
        return false;
    }//*/

    @Override
    public boolean containsKey(Object key) {
        int bucketIndex = calculateIndex(key);
        if (table[bucketIndex] != null){
            for (Entry<K,V> entry: table[bucketIndex]){
                if (entry.getKey().equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(int i=0; i<capacity; i++){
            if (table[i]!=null) {
                for (Entry<K, V> entry : table[i]) {
                    if (entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        Entry<K, V> entry = this.getEntry(key);
        return (entry!=null) ? entry.getValue() : null;
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> entry = this.getEntry(key);
        this.addEntry(key, value);
        return (entry!=null)? entry.getValue() : null;
    }

    @Override
    public V remove(Object key) {
        Entry<K, V> removed = this.removeEntry(key);
        return (removed!=null) ? removed.getValue() : null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry: m.entrySet()){
            this.addEntry(entry.getKey(), entry.getValue());
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
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int i=0; i<capacity; i++){
            if (table[i]!=null) {
                for (Entry<K, V> entry : table[i]) {
                    set.add(entry.getKey());
                }
            }
        }
        return set;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (int i=0; i<capacity; i++){
            if (table[i]!=null) {
                /*
                for (Entry<K, V> entry : table[i]) {
                    set.add(entry);
                }
                //*/
                set.addAll(table[i]);
            }
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> vCollection = new LinkedList<>();
        for (int i=0; i<capacity; i++){
            if (table[i]!=null) {
                for (Entry<K, V> entry : table[i]) {
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

    private class Entry<K, V> implements Map.Entry<K, V>{
        private final K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            Entry<?, ?> entry = (Entry<?, ?>) object;

            return key != null ? key.equals(entry.key) : entry.key == null;
        }

        @Override
        public int hashCode() {
            return key != null ? key.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "{\"" + key + "\" -> " + value + '}';
        }
    }
}
