package Ex12.mapsStatistic;


import java.util.*;

public class MapStatistic {
    public static void main(String[] args) {
        int num = 1000000;
        Student[] students = generateStudents(num);
        double[] treeMapTimes = new double[3];
        double[] hashMapTimes = new double[3];

        System.out.println("Tree Map");
        Map<Integer, Student> treeMap = new TreeMap<>();
        treeMapTimes[0] = testAdd(treeMap, students, num);
        System.out.println("--------------------------------------");
        treeMapTimes[1] = testFind(treeMap, students, num);
        System.out.println("--------------------------------------");
        treeMapTimes[2] = testRemoving(treeMap, students, num);
        System.out.println("======================================");

        System.out.println();

        System.out.println("Hash Map");
        Map<Integer, Student> hashMap = new HashMap<>();
        hashMapTimes[0] = testAdd(hashMap, students, num);
        System.out.println("--------------------------------------");
        hashMapTimes[1] = testFind(hashMap, students, num);
        System.out.println("--------------------------------------");
        hashMapTimes[2] = testRemoving(hashMap, students, num);
        System.out.println("======================================");

        System.out.println("TOTAL:");
        System.out.println(getRemainingTime(treeMapTimes, hashMapTimes));
    }

    private static double testAdd(Map map, Student[] students, int num){
        long start = 0;
        long end = 0;
        String add = "Adding ";
        System.out.println(add);
        start = System.currentTimeMillis();
        for (int i=0; i<num; i++){
            map.put(students[i].getId(), students[i]);
        }
        end = System.currentTimeMillis();
        return showTime(start, end, add);
    }
    private static double testFind(Map map, Student[] students, int num){
        long start = 0;
        long end = 0;
        String find = "Finding ";
        System.out.println(find);

        start = System.currentTimeMillis();
        for (int i=0; i<num; i++){
            map.get(students[i].getId());
        }
        end = System.currentTimeMillis();
        return showTime(start, end, find);
    }

    private static double testRemoving(Map map, Student[] students, int num){
        long start = 0;
        long end = 0;
        String remove = "Removing ";
        System.out.println(remove);

        start = System.currentTimeMillis();
        for (int i=0; i<num; i++) {
            map.remove(students[i].getId());
        }
        end = System.currentTimeMillis();
        return showTime(start, end, remove);
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

    private static double showTime(long start, long end, String actionName){
        double result = end - start;
        System.out.println(actionName + " took " + result + " milliseconds.");
        return result;
    }

    private static String getRemainingTime(double[] treeMapTimes, double[]hashMapTimes){
        String[] action = {"Adding", "Finding", "Removing"};
        String[] mapName = {"TreeMap", "HashMap"};
        String borderLine = "\n"+String.format("%45s","").replace(' ','_');
        StringBuilder builder = new StringBuilder(borderLine);
        builder.append("\n|" + addLeft("|") + addLeft(mapName[0]+"|") +  addLeft(mapName[1]+"|"));
        builder.append("\n|" + addLeft("|") + addLeft("ms|") +  addLeft("ms|"));
        for (int i=0; i<action.length; i++){
            builder.append(borderLine);
            builder.append("\n|" + addLeft(action[i]+"|"));
            builder.append(addLeft(treeMapTimes[i]+"|"));
            builder.append(addLeft(hashMapTimes[i]+"|"));
        }
        builder.append(borderLine);

        return builder.toString();
    }

    private static String addLeft(Object str){
        return String.format("%15s", str.toString());
    }

    private static class Student {
        private final int id;
        private String name;
        private String surname;

        private int[] marks;

        private Student(int id, String name, String surname, int marksCount) {
            this.id = id;
            this.name = name;
            this.surname = surname;
        }

        private void generateMarks(int count){
            Random random = new Random();
            marks = new int[count];
            for (int i=0; i<count; i++){
                marks[i] = random.nextInt(100);
            }
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", marks=" + Arrays.toString(marks) +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            return id == student.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}
