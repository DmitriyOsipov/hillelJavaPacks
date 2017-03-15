package Ex10.binaryTree;

public class Demo {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.add(50);
        tree.add(75);
        tree.add(27);
        tree.add(15);
        tree.add(60);
        tree.add(90);
        tree.add(110);
        tree.add(1);
        tree.add(40);
        tree.add(80);
        tree.add(69);
        tree.add(78);
        tree.add(37);
        tree.add(20);
        tree.add(22);
        tree.add(83);
        tree.add(47);
        tree.add(39);
        tree.add(38);
        tree.add(0);
        tree.add(44);
        tree.add(32);
        tree.add(24);
        tree.add(23);
        tree.add(21);
        tree.add(25);
        tree.add(77);
        tree.add(76);

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
    }
}
