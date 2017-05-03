package com.lessons.Ex11.mapsStatistic;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class MapStatistic {
    public static void main(String[] args) {
        int num = 1000000;
        Student[] students = generateStudents(num);

        System.out.println("Tree Map");
        Map<Integer, Student> treeMap = new TreeMap<>();
        testAdd(treeMap, students, num);
        System.out.println("--------------------------------------");
        testFind(treeMap, students, num);
        System.out.println("--------------------------------------");
        testRemoving(treeMap, students, num);
        System.out.println("======================================");

        System.out.println();

        System.out.println("Hash Map");
        Map<Integer, Student> hashMap = new HashMap<>();
        testAdd(hashMap, students, num);
        System.out.println("--------------------------------------");
        testFind(hashMap, students, num);
        System.out.println("--------------------------------------");
        testRemoving(hashMap, students, num);
        System.out.println("======================================");
    }

    private static void testAdd(Map map, Student[] students, int num){
        long start = 0;
        long end = 0;
        String add = "Adding ";
        System.out.println(add);
        start = System.currentTimeMillis();
        for (int i=0; i<num; i++){
            map.put(students[i].getId(), students[i]);
        }
        end = System.currentTimeMillis();
        showTime(start, end, add);
    }
    private static void testFind(Map map, Student[] students, int num){
        long start = 0;
        long end = 0;
        String find = "Finding ";
        System.out.println(find);
        System.out.println(find + 10);
        start = System.currentTimeMillis();
        map.get(students[10].getId()).toString();
        end = System.currentTimeMillis();
        showTime(start, end, find + 10);

        System.out.println(find + 1000);
        start = System.currentTimeMillis();
        map.get(students[1000].getId()).toString();
        end = System.currentTimeMillis();
        showTime(start, end, find + 10);

        System.out.println(find + num/2);
        start = System.currentTimeMillis();
        map.get(students[num/2].getId()).toString();
        end = System.currentTimeMillis();
        showTime(start, end, find + num/2);

        System.out.println(find + num);
        start = System.currentTimeMillis();
        map.get(students[num-1].getId()).toString();
        end = System.currentTimeMillis();
        showTime(start, end, find + num);
    }

    private static void testRemoving(Map map, Student[] students, int num){
        long start = 0;
        long end = 0;
        String remove = "Removing ";
        System.out.println(remove);
        System.out.println(remove + 10);
        start = System.currentTimeMillis();
        map.remove(students[10].getId());
        end = System.currentTimeMillis();
        showTime(start, end, remove + 10);

        System.out.println(remove + 50000);
        start = System.currentTimeMillis();
        map.remove(students[50000].getId());
        end = System.currentTimeMillis();
        showTime(start, end, remove + 50000);

        System.out.println(remove + num/2);
        start = System.currentTimeMillis();
        map.remove(students[num/2].getId());
        end = System.currentTimeMillis();
        showTime(start, end, remove + num/2);

        System.out.println(remove + (num-10));
        start = System.currentTimeMillis();
        map.remove(students[num-10].getId());
        end = System.currentTimeMillis();
        showTime(start, end, remove + (num-10));
    }

    private static Student[] generateStudents(int num){
        String[] names = {"I.", "P.", "A.", "E.", "A.", "S.", "S.", "K.", "M.", "D.", "A."};
        String[] surnames = {"Ivanov", "Petrov", "Sidorov", "Svetlaya", "Temnij", "Belij", "Chernaya", "Unnamed"};

        Random random = new Random();
        Student[] students = new Student[num];

        for (int i=0; i<num; i++){
            students[i] = new Student(i, names[Math.abs(random.nextInt())%names.length],
                                    surnames[Math.abs(random.nextInt())%surnames.length],
                                    Math.abs(random.nextInt())%25);
        }
        return students;
    }

    private static void showTime(long start, long end, String actionName){
        double result = end - start;
        System.out.println(actionName + " took " + result + " milliseconds.");
    }
}
