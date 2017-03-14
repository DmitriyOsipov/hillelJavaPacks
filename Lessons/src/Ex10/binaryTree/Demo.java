package Ex10.binaryTree;

public class Demo {
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.add(50);
        tree.add(75);
        tree.add(25);
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
        tree.add(0);
        tree.add(44);
        tree.add(32);

        System.out.println(tree);

        System.out.println(tree.remove(44));
    }
}
