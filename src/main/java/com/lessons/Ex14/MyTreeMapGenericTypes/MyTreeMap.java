package com.lessons.Ex14.MyTreeMapGenericTypes;

import java.util.*;

public class MyTreeMap<K, V> implements Iterable, Map<K, V>{
    private Node<K, V> root;
    private Iterator_Kind iteratorKind = Iterator_Kind.PREFIX;

    enum Iterator_Kind {INFIX, POSTFIX, PREFIX, HORIZONTAL};

    public MyTreeMap(){}

    public MyTreeMap(K key, V value){
        this.add(key, value);
    }

    @Override
    public boolean isEmpty(){
        return root==null;
    }

    public void setIteratorKind(Iterator_Kind iteratorKind) {
        this.iteratorKind = iteratorKind;
    }

    @Override
    public void clear(){
        root=null;
    }

    @Override
    public int size(){
        int count = 0;
        if (!isEmpty()){
            for(Object data:this){
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("[ ");
        IteratorNode nodes = new IteratorNode();
        while (nodes.hasNext()){
            Node node = nodes.next();
            String line = " \"" + node.getKey() + "\" -> ";
            builder.append(line);
            builder.append(node.getValue());
            builder.append(";");
        }
        builder.append("]");
        return builder.toString();
    }

    public boolean add(K key, V object){
        boolean result = false;

        Node<K, V> newNode = new Node<>(key, object, null, null);
        if (this.isEmpty()){
            root = newNode;
        }
        else {
            add(root, newNode);
        }
        result = true;
        return result;
    }

    private void add(Node<K, V> thisNode, Node<K, V> newNode){
        Comparable thisObject = (Comparable)thisNode.getKey();
        Comparable newObject = (Comparable)newNode.getKey();

        if (thisObject.compareTo(newObject)<0){
            addRight(thisNode, newNode);
        }
        else if(thisObject.compareTo(newObject)>0){
            addLeft(thisNode, newNode);
        }
        else {
            thisNode.setValue(newNode.getValue());
        }
    }

    private void addRight(Node<K,V> thisNode, Node<K,V> newNode){
        if (thisNode.getRight()==null){
            thisNode.setRight(newNode);
        }
        else {
            add(thisNode.getRight(), newNode);
        }
    }
    private void addLeft(Node<K,V> thisNode, Node<K,V> newNode){
        if (thisNode.getLeft()==null){
            thisNode.setLeft(newNode);
        }
        else {
            add(thisNode.getLeft(), newNode);
        }
    }

    private Node<K,V> getNode(Node<K,V> currentNode, Object key){
        Node<K,V> nodeResult = null;
        boolean finded = false;
        Comparable needed = (Comparable) key;
        while((currentNode!=null)&&(!finded)) {
            Comparable currentNodeKey = (Comparable) currentNode.getKey();

            if (currentNodeKey.compareTo(needed) == 0) {
                nodeResult = currentNode;
                finded = true;
            } else if (currentNodeKey.compareTo(needed) < 0) {
                nodeResult = currentNode.getRight();
            } else {
                nodeResult = currentNode.getLeft();
            }
            currentNode = nodeResult;
        }

        return nodeResult;
    }

    private Node<K,V> getParent(Node<K,V> currentNode){
        IteratorNode iterator = new IteratorNode();
        Node<K,V> current;
        while (iterator.hasNext()){
            current = iterator.next();
            if ((current.getRight()==currentNode)||(current.getLeft()==currentNode)){
                return current;
            }
        }
        return null;
    }

    @Override
    public V get(Object key) {
        if (key==null){
            throw new NullPointerException("Key cannot be null");
        }
        Node<K,V> gotNode = this.getNode(root, key);
        return (gotNode!=null) ? gotNode.getValue():null;
    }

    @Override
    public V put(K key, V value) {
        if (key==null){
            throw new NullPointerException("Key cannot be null");
        }
        V previousValue = this.get(key);
        this.add(key, value);
        return previousValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        if (m==null){
            throw new NullPointerException("Joined map cannot be null");
        }
        for (Entry<? extends K, ? extends V> entry: m.entrySet()){
            this.add(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        IteratorNode iteratorNode = new IteratorNode();
        while (iteratorNode.hasNext()){
            keys.add((iteratorNode.next()).getKey());
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new LinkedList<>();
        Iterator<V> iterator = this.iterator();
        while (iterator.hasNext()){
            values.add(iterator.next());
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> nodes = new HashSet<>();
        IteratorNode iteratorNode = new IteratorNode();
        while (iteratorNode.hasNext()){
            nodes.add(iteratorNode.next());
        }
        return nodes;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null){
            throw new NullPointerException("Key cannot be null");
        }
        Node<K,V> gotNode = this.getNode(root, key);
        return (gotNode!=null);
    }

    @Override
    public boolean containsValue(Object value) {
        Collection<V> values = this.values();
        for (V existed:values){
            if (existed.equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public V remove(Object key){
        if (key==null){
            throw new NullPointerException("Key cannot be null");
        }
        boolean result = false;
        Node<K,V> nodeToDelete = this.getNode(root, key);
        if (nodeToDelete!=null){
            Node<K,V> parent = this.getParent(nodeToDelete);
            boolean hasLeftChildren = (nodeToDelete.getLeft()!=null);
            boolean hasRightChildren = (nodeToDelete.getRight()!=null);

            if (!hasLeftChildren && !hasRightChildren){
                replaceNode(parent, nodeToDelete, null);
            }
            else if (!hasLeftChildren && hasRightChildren){
                replaceNode(parent, nodeToDelete, nodeToDelete.getRight());
            }
            else if (hasLeftChildren && !hasRightChildren){
                replaceNode(parent, nodeToDelete, nodeToDelete.getLeft());
            }
            else {
                removeWithBothChildren(parent, nodeToDelete);
            }

            result = true;
        }
        return (result) ? nodeToDelete.getValue() : null;
    }

    private void replaceNode(Node<K,V> parent, Node<K,V> current, Node<K,V> newNode){
        if (parent!=null) {
            if (parent.getLeft() == current) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
        }
        else {
            root = newNode;
        }
    }

    private void removeWithBothChildren(Node<K,V> parent, Node<K,V> toDelete){
        Node<K,V> cur = toDelete.getLeft();
        while (cur.getRight()!=null){
            cur = cur.getRight();
        }
        if (cur!=toDelete.getLeft()){
            getParent(cur).setRight(cur.getLeft());
            cur.setLeft(toDelete.getLeft());
        }
        cur.setRight(toDelete.getRight());
        replaceNode(parent, toDelete, cur);
    }
    private Iterator<V> createIterator(){
        Iterator<V> iterator;
        switch (iteratorKind){
            case INFIX : {
                iterator = new IteratorInfix();
            }break;
            case POSTFIX:{
                iterator = new IteratorPostfix();
            }break;
            case HORIZONTAL:{
                iterator = new IteratorHorizontal();
            }break;
            default:{
                iterator = new IteratorPrefix();
            }
        }
        return iterator;
    }

    @Override
    public Iterator<V> iterator() {
        return createIterator();
    }



    private class IteratorNode implements Iterator<Node<K,V>>{
        Stack<Node<K,V>> nodeStack;
        Node<K, V> current;

        private IteratorNode(){
            nodeStack = new Stack<>();
            current = root;
            if (current==null){
                return;
            }
            else {
                nodeStack.push(null);
            }
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Node<K,V> next() {
            Node<K,V> value = current;

            if (current.getRight()!=null){
                nodeStack.push(current.getRight());
            }
            if (current.getLeft()!=null){
                current = current.getLeft();
            }
            else {
                current = nodeStack.pop();
            }
            return value;
        }
    }

    private class IteratorPrefix implements Iterator<V>{
        Stack<Node<K, V>> nodeStack;
        Node<K, V> current;

        private IteratorPrefix(){
            nodeStack = new Stack<>();
            current = root;
            if (current==null){
                return;
            }
            else {
                nodeStack.push(null);
            }
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public V next() {
            V value = current.getValue();

            if (current.getRight()!=null){
                nodeStack.push(current.getRight());
            }
            if (current.getLeft()!=null){
                current = current.getLeft();
            }
            else {
                current = nodeStack.pop();
            }
            return value;
        }
    }

    private class IteratorInfix implements Iterator<V>{
        Stack<Node<K,V>> nodeStack = new Stack<>();
        Node<K,V> current;

        private IteratorInfix(){
            current = root;
            if (current==null){
                return;
            }
            else {
                nodeStack.push(null);
                while (current.getLeft()!=null){
                    nodeStack.push(current);
                    current = current.getLeft();
                }
            }
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public V next() {
            V value = current.getValue();

            if (current.getRight()!=null){
                current = current.getRight();
                while (current.getLeft()!=null){
                    nodeStack.push(current);
                    current = current.getLeft();
                }
            }
            else {
                current = nodeStack.pop();
            }

            return value;
        }
    }

    private class IteratorPostfix implements Iterator<V>{
        Stack<Node<K,V>> nodeStack = new Stack<>();
        Node<K,V> current;

        private IteratorPostfix(){
            current = root;
            if (current==null){
                return;
            }
            else {
                nodeStack.push(null);
                while (current.getLeft()!=null||current.getRight()!=null){
                    nodeStack.push(current);
                    if (current.getLeft()!=null){
                        current = current.getLeft();
                    }
                    else {
                        current = current.getRight();
                    }
                }
            }
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public V next() {
            V value = current.getValue();

            Node tempRoot = nodeStack.peek();
            if((tempRoot!=null)&&(tempRoot.getRight()!=null && tempRoot.getLeft()!=null && current==tempRoot.getLeft())){
                current = tempRoot.getRight();
                while (current.getLeft()!=null||current.getRight()!=null){
                    nodeStack.push(current);
                    if (current.getLeft()!=null){
                        current = current.getLeft();
                    }
                    else {
                        current = current.getRight();
                    }
                }
            }
            else {
                current = nodeStack.pop();
            }

            return value;
        }
    }

    private class IteratorHorizontal implements Iterator<V>{
        private Node<K,V> current;
        private LinkedList<Node<K,V>> nodes;
        private IteratorHorizontal(){
            nodes = new LinkedList<>();
            current = root;
            if (current==null){
                return;
            }
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public V next() {
            V value = current.getValue();

            if (current.getLeft() != null) {
                nodes.addLast(current.getLeft());
            }
            if (current.getRight() != null) {
                nodes.addLast(current.getRight());
            }
            if (!nodes.isEmpty()) {
                current = nodes.getFirst();
                nodes.removeFirst();
            }
            else {
                current = null;
            }
            return value;
        }
    }

    private class Node<K, V> implements Entry<K, V>{
        private final K key;
        private V value;
        private Node<K, V> right;
        private Node<K, V> left;

        private Node(K key, V value, Node<K, V> right, Node<K, V> left) {
            if (key==null){
                throw new NullPointerException("This map don't support null keys");
            }
            this.key = key;
            this.value = value;
            this.right = right;
            this.left = left;
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

        private Node<K, V> getRight() {
            return right;
        }

        private void setRight(Node<K, V> right) {
            this.right = right;
        }

        private Node<K, V> getLeft() {
            return left;
        }

        private void setLeft(Node<K, V> left) {
            this.left = left;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            Node<?, ?> node = (Node<?, ?>) object;

            return key != null ? key.equals(node.key) : node.key == null;
        }

        @Override
        public int hashCode() {
            return key != null ? key.hashCode() : 0;
        }
    }
}