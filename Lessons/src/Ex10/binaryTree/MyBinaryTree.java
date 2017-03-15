package Ex10.binaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class MyBinaryTree implements Iterable{
    private Node root;
    private Iterator_Kind iteratorKind = Iterator_Kind.PREFIX;

    enum Iterator_Kind {INFIX, POSTFIX, PREFIX, HORIZONTAL};

    public MyBinaryTree(){}

    public MyBinaryTree(Object object){
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void setIteratorKind(Iterator_Kind iteratorKind) {
        this.iteratorKind = iteratorKind;
    }

    public void clear(){
        root=null;
    }

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

    private Node getParent(Node currentNode){
        IteratorNode iterator = new IteratorNode();
        Node current;
        while (iterator.hasNext()){
            current = iterator.next();
            if ((current.getRight()==currentNode)||(current.getLeft()==currentNode)){
                return current;
            }
        }
        return null;
    }

    public boolean remove(Object object){
        boolean result = false;
        Node nodeToDelete = this.getNode(root, object);
        if (nodeToDelete!=null){
            Node parent = this.getParent(nodeToDelete);
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

        return result;
    }

    private void replaceNode(Node parent, Node current, Node newNode){
        if (parent.getLeft()==current){
            parent.setLeft(newNode);
        }
        else {
            parent.setRight(newNode);
        }

    }

    private void removeWithBothChildren(Node parent, Node toDelete){
        Node cur = toDelete.getLeft();
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
    private Iterator createIterator(){
        Iterator iterator;
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
    public Iterator iterator() {
        return createIterator();
    }



    private class IteratorNode implements Iterator<Node>{
        Stack<Node> nodeStack;
        Node current;

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
        public Node next() {
            Node value = current;

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

    private class IteratorHorizontal implements Iterator{
        private Node current;
        private LinkedList<Node> nodes;
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
        public Object next() {
            Object value = current.getData();

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
