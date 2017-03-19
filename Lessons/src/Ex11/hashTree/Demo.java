package Ex11.hashTree;


import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        MyTreeMap tree = new MyTreeMap();
        tree.add(50, 50);
        tree.add(75, 75);
        tree.add(27, 27);
        tree.add(15, 15);
        tree.add(60, 60);
        tree.add(90, 90);
        tree.add(110, 110);
        tree.add(1, 1);
        tree.add(40, 40);
        tree.add(80, 80);
        tree.add(69, 69);
        tree.add(78, 78);
        tree.add(37, 37);
        tree.add(20, 20);
        tree.add(22, 22);
        tree.add(83, 83);
        tree.add(47, 47);
        tree.add(39, 39);
        tree.add(38, 38);
        tree.add(0, 0);
        tree.add(44, 44);
        tree.add(32, 32);
        tree.add(24, 24);
        tree.add(23, 23);
        tree.add(21, 21);
        tree.add(25, 25);
        tree.add(77, 77);
        tree.add(76, 76);

        //tree.setIteratorKind(MyBinaryTree.Iterator_Kind.HORIZONTAL);
        System.out.println(tree);
        System.out.println("Size " + tree.size());
        System.out.println();
        System.out.println("Remove 80");
        tree.remove(80);
        System.out.println(tree);
        System.out.println("Size " + tree.size());
        System.out.println();
        System.out.println("Remove 40");
        tree.remove(40);
        System.out.println(tree);
        System.out.println("Size " + tree.size());
        System.out.println();
        System.out.println("Remove 20");
        tree.remove(20);
        System.out.println(tree);
        System.out.println("Size " + tree.size());
        System.out.println();
        System.out.println("Remove 1");
        tree.remove(1);
        System.out.println(tree);
        System.out.println("Size " + tree.size());


        System.out.println("Add \"4\" with value 149: ");
        tree.add(4, 149);
        System.out.println(tree);
        System.out.println("Size " + tree.size());

        System.out.println("print values with infix iterator:");
        tree.setIteratorKind(MyTreeMap.Iterator_Kind.INFIX);
        Iterator treeIterator = tree.iterator();
        while (treeIterator.hasNext()){
            System.out.print("  " + treeIterator.next());
        }
        System.out.println();
        System.out.println("As you see, this tree compares nodes with key value");

    }
}
