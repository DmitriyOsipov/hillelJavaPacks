package Ex11.hashMap;


public class MyHashMapDemo {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.add(50, 50);
        hashMap.add(75, 75);
        hashMap.add(27, 27);
        hashMap.add(15, 15);
        hashMap.add(60, 60);
        hashMap.add(90, 90);
        hashMap.add(110, 110);
        hashMap.add(1, 1);
        hashMap.add(40, 40);
        hashMap.add(80, 80);
        hashMap.add(69, 69);
        hashMap.add(78, 78);
        hashMap.add(37, 37);
        hashMap.add(20, 20);
        hashMap.add(22, 22);
        hashMap.add(83, 83);
        hashMap.add(47, 47);
        hashMap.add(39, 39);
        hashMap.add(38, 38);
        hashMap.add(0, 0);
        hashMap.add(44, 44);
        hashMap.add(32, 32);
        hashMap.add(24, 24);
        hashMap.add(23, 23);
        hashMap.add(21, 21);
        hashMap.add(25, 25);
        hashMap.add(77, 77);
        hashMap.add(76, 76);

        System.out.println(hashMap);
        System.out.println("Size " + hashMap.size());
        System.out.println();
        System.out.println("Remove 80");
        hashMap.remove(80);
        System.out.println(hashMap);
        System.out.println("Size " + hashMap.size());
        System.out.println();
        System.out.println("Remove 40");
        hashMap.remove(40);
        System.out.println(hashMap);
        System.out.println("Size " + hashMap.size());
        System.out.println();
        System.out.println("Remove 20");
        hashMap.remove(20);
        System.out.println(hashMap);
        System.out.println("Size " + hashMap.size());
        System.out.println();
        System.out.println("Remove 1");
        hashMap.remove(1);
        System.out.println(hashMap);
        System.out.println("Size " + hashMap.size());

    }
}
