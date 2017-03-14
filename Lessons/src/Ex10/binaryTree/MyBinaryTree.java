package Ex10.binaryTree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class MyBinaryTree implements Iterable{
    Node root;
    //Iterator iterator;

    public MyBinaryTree(){}

    public MyBinaryTree(Object object){
    }

    public boolean isEmpty(){
        return root==null;
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
        add(root, newNode);

        return result;
    }

    private void add(Node thisNode, Node newNode){
        Comparable thisObject = (Comparable)thisNode.getData();
        Comparable newObject = (Comparable)newNode.getData();

        if (thisObject.compareTo(newObject)<0){
            if (thisNode.getRight()==null){
                thisNode.setRight(newNode);
            }
            else {
                add(thisNode.getRight(), newNode);
            }
        }
        else if(thisObject.compareTo(newObject)>0){
            if (thisNode.getLeft()==null){
                thisNode.setLeft(newNode);
            }
            else {
                add(thisNode.getLeft(), newNode);
            }
        }
        else {
            thisNode.setData(newObject);
            //thisNode.setCount(thisNode.getCount()+1);
        }
    }

    @Override
    public Iterator iterator() {
        return new IteratorPrefix();
    }




    private class IteratorPrefix implements Iterator{
        Stack<Node> nodeStack;
        Node current;

        private IteratorPrefix(){
            current = root;
            if (current==null){
                return;
            }
            else {
                nodeStack = new Stack<>();
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
