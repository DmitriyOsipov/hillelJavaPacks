package com.lessons.Ex14.MyTreeMapGenericTypes;

public class MyTreeMapGenericsDemo {
    public static void main(String[] args) {
       MyTreeMap<String, Integer> treeMap = new MyTreeMap<>();
        treeMap.put("50", 50);
        treeMap.put("75", 75);
        treeMap.put("27", 27);
        treeMap.put("15", 15);
        treeMap.put("60", 60);
        treeMap.put("90", 90);
        treeMap.put("110", 110);
        treeMap.put("1", 1);
        treeMap.put("40", 40);
        treeMap.put("80", 80);
        treeMap.put("69", 69);
        treeMap.put("78", 78);
        treeMap.put("37", 37);
        treeMap.put("20", 20);
        treeMap.put("22", 22);
        treeMap.put("83", 83);
        treeMap.put("47", 47);
        treeMap.put("39", 39);
        treeMap.put("38", 38);
        treeMap.put("0", 0);
        treeMap.put("44", 44);
        treeMap.put("32", 32);
        treeMap.put("24", 24);
        treeMap.put("23", 23);
        treeMap.put("21", 21);
        treeMap.put("25", 25);
        treeMap.put("77", 77);
        treeMap.put("76", 76);

        System.out.println(treeMap);
        System.out.println("Size " + treeMap.size());
        System.out.println();
        System.out.println("Remove 80");
        treeMap.remove("80");
        System.out.println(treeMap);
        System.out.println("Size " + treeMap.size());
        System.out.println();
        System.out.println("Remove 40");
        treeMap.remove("40");
        System.out.println(treeMap);
        System.out.println("Size " + treeMap.size());
        System.out.println();
        System.out.println("Remove 20");
        treeMap.remove("20");
        System.out.println(treeMap);
        System.out.println("Size " + treeMap.size());
        System.out.println();
        System.out.println("Remove 1");
        treeMap.remove("1");
        System.out.println(treeMap);
        System.out.println("Size " + treeMap.size());

        System.out.println();
        System.out.println("Get value with key \"50\"");
        System.out.println(treeMap.get("50"));
        System.out.println("get value with \"1100\": " + treeMap.get("1100"));

        System.out.println("Does treeMap contain entry with key \"47\"? " + treeMap.containsKey("47"));
        System.out.println("Does treeMap contain entry with key \"74\"? " + treeMap.containsKey("74"));

        System.out.println("Does treeMap contain entry with value 38? " + treeMap.containsValue(38));
        System.out.println("Does treeMap contain entry with value 8? " + treeMap.containsValue(8));

     System.out.println("Size of keySet: " + treeMap.keySet().size());
     System.out.println("Size of values collection: " + treeMap.values().size());
     System.out.println("Size of entry set: " + treeMap.entrySet().size());
     System.out.println("Is treeMap empty? " + treeMap.isEmpty());

     System.out.println("Clear treeMap");
     treeMap.clear();
     System.out.println(treeMap);
     System.out.println("Is it empty? " + treeMap.isEmpty());

     System.out.println("Try to put entry with null value:");
     treeMap.put("Test", null);
     System.out.println(treeMap);
     System.out.println("Try to put entry with null key:");
     treeMap.put(null, 10);
    }
}
