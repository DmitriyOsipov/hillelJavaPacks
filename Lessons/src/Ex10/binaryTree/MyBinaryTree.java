package Ex10.binaryTree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;
import java.lang.Enum;

public class MyBinaryTree implements Iterable{
    private Node root;
    private ITERATOR_KIND iteratorKind = ITERATOR_KIND.PREFIX;

    enum ITERATOR_KIND {INFIX, POSTFIX, PREFIX};

    public MyBinaryTree(){}

    public MyBinaryTree(Object object){
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void setIteratorKind(ITERATOR_KIND iteratorKind) {
        this.iteratorKind = iteratorKind;
    }

    public void clear(){
        root=null;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder("[ ");
        for(Object object:this){
            builder.append(object);
            builder.append(" ");
        }
        builder.append("]");
        return builder.toString();
    }

    public boolean add(Object object){
        boolean result = false;

        Node newNode = new Node(object, null, null);
        if (this.isEmpty()){
            root = newNode;
        }
        else {
            add(root, newNode);
        }
        result = true;
        return result;
    }

    private void add(Node thisNode, Node newNode){
        Comparable thisObject = (Comparable)thisNode.getData();
        Comparable newObject = (Comparable)newNode.getData();

        if (thisObject.compareTo(newObject)<0){
            addRight(thisNode, newNode);
        }
        else if(thisObject.compareTo(newObject)>0){
            addLeft(thisNode, newNode);
        }
        else {
            thisNode.setData(newObject);
        }
    }

    private void addRight(Node thisNode, Node newNode){
        if (thisNode.getRight()==null){
            thisNode.setRight(newNode);
        }
        else {
            add(thisNode.getRight(), newNode);
        }
    }
    private void addLeft(Node thisNode, Node newNode){
        if (thisNode.getLeft()==null){
            thisNode.setLeft(newNode);
        }
        else {
            add(thisNode.getLeft(), newNode);
        }
    }

    private Node getNode(Node currentNode, Object object){
        Node nodeResult = null;
        if (currentNode==null){
            return nodeResult;
        }
        Comparable currentObj = (Comparable)currentNode.getData();
        Comparable needed = (Comparable)object;

        if (currentObj.compareTo(needed)==0){
            nodeResult = currentNode;
        }
        else if (currentObj.compareTo(needed)<0){
            nodeResult = getNode(currentNode.getRight(), object);
        }
        else {
            nodeResult = getNode(currentNode.getLeft(), object);
        }


        return nodeResult;
    }

    public boolean remove(Object object){
        boolean result = false;

        Node nodeToDelete = this.getNode(root, object);
        if (nodeToDelete!=null){

            result = true;
        }

        return result;
    }

    private Iterator createIterator(){
        Iterator iterator;
        switch (iteratorKind){
            case INFIX : {
                iterator = new IteratorInfix();
            }break;
            case POSTFIX:{
                iterator = new IteratorPostfix();
            }break;
            default:{
                iterator = new IteratorPrefix();
            }
        }
        return iterator;
    }

    @Override
    public Iterator iterator() {
        return createIterator();
    }




    private class IteratorPrefix implements Iterator{
        Stack<Node> nodeStack;
        Node current;

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
        public Object next() {
            Object value = current.getData();

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

    private class IteratorInfix implements Iterator{
        Stack<Node> nodeStack = new Stack<>();
        Node current;

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
        public Object next() {
            Object value = current.getData();

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

    private class IteratorPostfix implements Iterator{
        Stack<Node> nodeStack = new Stack<>();
        Node current;

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
        public Object next() {
            Object value = current.getData();

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

    private class Node{
        Object data;
        Node right;
        Node left;
        int count=1;

        private Node(Object data, Node right, Node left) {
            this.data = data;
            this.right = right;
            this.left = left;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
