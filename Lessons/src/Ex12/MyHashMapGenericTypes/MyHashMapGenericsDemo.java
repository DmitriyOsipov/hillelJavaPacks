package Ex12.MyHashMapGenericTypes;

public class MyHashMapGenericsDemo {
    public static void main(String[] args) {
       MyHashMap<String, Integer> hashMap = new MyHashMap();
        hashMap.put("50", 50);
        hashMap.put("75", 75);
        hashMap.put("27", 27);
        hashMap.put("15", 15);
        hashMap.put("60", 60);
        hashMap.put("90", 90);
        hashMap.put("110", 110);
        hashMap.put("1", 1);
        hashMap.put("40", 40);
        hashMap.put("80", 80);
        hashMap.put("69", 69);
        hashMap.put("78", 78);
        hashMap.put("37", 37);
        hashMap.put("20", 20);
        hashMap.put("22", 22);
        hashMap.put("83", 83);
        hashMap.put("47", 47);
        hashMap.put("39", 39);
        hashMap.put("38", 38);
        hashMap.put("0", 0);
        hashMap.put("44", 44);
        hashMap.put("32", 32);
        hashMap.put("24", 24);
        hashMap.put("23", 23);
        hashMap.put("21", 21);
        hashMap.put("25", 25);
        hashMap.put("77", 77);
        hashMap.put("76", 76);

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

        System.out.println();
        System.out.println("Get value with key \"50\"");
        System.out.println(hashMap.get("50"));
        System.out.println("get value with \"1100\": " + hashMap.get("1100"));

        System.out.println("Does hashMap contain entry with key \"47\"? " + hashMap.containsKey("47"));
        System.out.println("Does hashMap contain entry with key \"74\"? " + hashMap.containsKey("74"));

        System.out.println("Does hashMap contain entry with value 80? " + hashMap.containsValue(80));
        System.out.println("Does hashMap contain entry with value 8? " + hashMap.containsValue(8));


    }
}
