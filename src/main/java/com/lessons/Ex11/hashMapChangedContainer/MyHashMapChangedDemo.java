package com.lessons.Ex11.hashMapChangedContainer;


public class MyHashMapChangedDemo {
    public static void main(String[] args) {
        System.out.println("Buckets");
        MyHashMap hashMap = new MyHashMap(getTableBucket(8));
        addElements(hashMap);
        demonstrate(hashMap);


        System.out.println();
        System.out.println("Tree");
        MyHashMap hashMapTree = new MyHashMap(getTableTrees(8));
        addElements(hashMapTree);
        demonstrate(hashMapTree);

        System.out.println();
        System.out.println("----------------------");
        System.out.println("Changed capacity to 16");
        hashMap.setCapacity(16);
        System.out.println(hashMap);
    }

    public static void addElements(MyHashMap hashMap) {
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
    }

    public static MyHashMapBucket[] getTableBucket(int capacity){
        MyHashMapBucket[] buckets = new MyHashMapBucket[capacity];
        for (int i=0; i<capacity; i++){
            buckets[i] = new MyHashMapBucket();
        }
        return buckets;
    }

    public static MyTreeMapMyMapInOut[] getTableTrees(int capacity){
        MyTreeMapMyMapInOut[] trees = new MyTreeMapMyMapInOut[capacity];
        for (int i=0; i<capacity; i++){
            trees[i] = new MyTreeMapMyMapInOut();
        }
        return trees;
    }

    public static void demonstrate(MyHashMap hashMap){
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
