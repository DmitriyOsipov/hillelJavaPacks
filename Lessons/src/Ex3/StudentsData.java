package Ex3;

import utilClasses.UserConsoleReader;

import javax.sound.midi.Soundbank;
import java.util.Scanner;
import java.util.SortedMap;

public class StudentsData {
    public static void main(String[] args) throws Exception{
        boolean repeat = true;
        String[] students = null;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("---------------------------------------");
            System.out.println("1 - Demo");
            System.out.println("2 - Add element");
            System.out.println("3 - Delete element");
            System.out.println("4 - Sort");
            System.out.println("5 - Contains");
            System.out.println("6 - Trim");
            System.out.println("7 - Print");
            System.out.println("8 - Exit");
            System.out.println("---------------------------------------");

            char answer;

            String answerS = scanner.nextLine();
            if (answerS.length()>0){
                answer=answerS.charAt(0);
            }
            else {
                answer = '0';
            }
            //scanner.next();
            switch (answer){
                case '1':{
                    demo();
                }break;
                case '2':{
                    System.out.println("Enter student:");
                    //scanner.nextLine();
                    students = addStudent(students, scanner.nextLine());
                    System.out.println("Group:");
                    print(students);
                }break;
                case '3':{
                    System.out.println("Enter student:");
                    //scanner.nextLine();
                    students = deleteStudent(students, scanner.nextLine());
                    System.out.println("Group:");
                    print(students);
                }break;
                case '4':{
                    students = sort(students);
                    System.out.println("Group:");
                    print(students);
                }break;
                case '5':{
                    System.out.println("Enter student:");
                    //scanner.nextLine();
                    String studentContain = scanner.nextLine();
                    if (containsStudent(students, studentContain)){
                        System.out.println("Yes");
                    }
                    else {
                        System.out.println("No");
                    }
                    System.out.println("Group");
                    print(students);
                }break;
                case '6':{
                    students = trim(students);
                    System.out.println("Group");
                    print(students);
                }break;
                case '7':{
                    System.out.println("Group");
                    print(students);
                }break;
                case '8':{
                    repeat = false;
                }break;
                default:{
                    System.out.println("Wrong choice");
                }break;
            }

        }while (repeat);
    }


    public static String[] addStudent(String[] studentsList, String newStudent){
        int studentsListLength = 0;
        if (studentsList != null) {
            studentsListLength = studentsList.length;
        }
        String[] result = new String[studentsListLength + 1];

        for (int i=0; i<studentsListLength; i++) {
            result[i] = studentsList[i];
        }
        result[studentsListLength] = newStudent;

        return result;
    }

    public static boolean containsStudent(String[] studentsList, String searchStudent){
        boolean result = false;

        if (studentsList!=null){
            for (String student:studentsList) {
                if (student.equals(searchStudent)){
                    result = true;
                    break;
                }
            }
        }

        return result;
    }
    public static int countContainsStudent(String[] studentsList, String searchStudent){
        int result = 0;

        if (studentsList!=null){
            for (String student:studentsList) {
                if (student.equals(searchStudent)){
                    result++;
                }
            }
        }

        return result;
    }

    public static String[] deleteStudent(String[] studentsList, String deleteStudent){
        String[] result = studentsList;
        int length = studentsList.length;
        int countedStudents = countContainsStudent(studentsList, deleteStudent);

        result = new String[length - countedStudents];
        int indexNewList = 0;
        for (String student:studentsList){
            if (!student.equals(deleteStudent)){
                result[indexNewList] = student;
                indexNewList++;
            }
        }

        return result;
    }

    public static String[] clear(){
        return null;
    }

    public static String[] trim(String[] studentsList){
        String[] result;
        result = deleteStudent(studentsList, "");
        result = deleteStudent(studentsList, " ");
        return result;
    }

     public static String[] joinGroup(String[] firstGroup, String[] secondGroup){
         String[] result = null;
         if ((firstGroup == null)&&(secondGroup==null)){
             return null;
         }
         if ((firstGroup==null)&&(secondGroup!=null)){
             return secondGroup;
         }
         if ((firstGroup!=null)&&(secondGroup==null)){
             return firstGroup;
         }
         if ((firstGroup!=null) && (secondGroup!=null)){
             result = new String[firstGroup.length + secondGroup.length];
             int indAll = 0;
             for (String student:firstGroup){
                 result[indAll] = student;
                 indAll++;
             }
             for (String student: secondGroup){
                 result[indAll] = student;
                 indAll++;
             }
         }

         return result;
     }

     public static String[] sort(String[] studentsList){
         String[] result = null;
         boolean changes;
         if (studentsList == null){
             System.out.println("There is no students in the list. Nothing to sort.");
             return null;
         }
         else {
             result = new String[studentsList.length];
             result = joinGroup(studentsList, null);
             do {
                 changes = false;
                 for (int i = 0; i<result.length-1; i++){
                     if (result[i].compareToIgnoreCase(result[i+1])>0)
                     {
                        String tmp = result[i+1];
                        result[i+1] = result[i];
                        result[i] = tmp;
                        changes = true;
                     }
                 }
             }while (changes);
         }
         return result;
     }

     public static boolean equals(String[] firstGroup, String[] secondGroup){
         boolean result = true;
         if ((firstGroup!= null)&&(secondGroup!=null)){
             if (firstGroup.length==secondGroup.length){
                 for (int i=0; ((i < firstGroup.length)&&(result)); i++){
                     if (!firstGroup[i].equals(secondGroup[i])){
                         result = false;
                     }
                 }
             }
             else {
                 result = false;
             }
         }
         else {
             System.out.println("Groups are empty. It is strange comparison.");
         }
         return result;
     }
     public static boolean containsAll(String[] firstGroup, String[] secondGroup){
         boolean result = true;
         if ((firstGroup != null)&&(secondGroup!=null)){
             if (firstGroup.length >= secondGroup.length){
                 for (int i=0; ((i<secondGroup.length)&&(result)); i++){
                     result = containsStudent(firstGroup, secondGroup[i]);
                 }
             }
             else {
                 for (int i=0; ((i<firstGroup.length)&&(result)); i++){
                     result = containsStudent(secondGroup, firstGroup[i]);
                 }
             }
         }
         else {
             System.out.println("One of group is null!");
         }

         return result;
     }

     public static void print(String[] studentsList){
         if ((studentsList!=null)&&(studentsList.length>0)){
             for (String student:studentsList) {
                 System.out.println(student);
             }
         }
         else {
             System.out.println("There are no students here!");
         }
     }

     public static void demo(){
         String[] groupA = {"Petrov", "Ivanov"};
         String[] groupB = {"Vasilyev", "Sidorov", "Abramovich"};
         String newStudent = "Nikolayev";
         String[] groupC = null;
         System.out.println("Starting demonstration....");
         System.out.println("--------------------------------------------------------------------");
         System.out.println("Our students:");
         print(groupA);
         System.out.println("--------------------------------------------------------------------");
         System.out.println("Trying to print empty group:");
         print(groupC);
         System.out.println("--------------------------------------------------------------------");
         System.out.println("Adding new student - " + newStudent);
         groupA = addStudent(groupA, newStudent);
         System.out.println("Our group");
         print(groupA);
         System.out.println("--------------------------------------------------------------------");

         System.out.println("Is there " + newStudent +"?");
         if (containsStudent(groupA, newStudent)){
             System.out.println("Yes");
         }
         else {
             System.out.println("No");
         }

         System.out.println("--------------------------------------------------------------------");

         System.out.println("Delete " + newStudent);
         groupA = deleteStudent(groupA, newStudent);
         //print(groupA);
         System.out.println("--------------------------------------------------------------------");

         System.out.println("Is there " + newStudent +"?");
         if (containsStudent(groupA, newStudent)){
             System.out.println("Yes");
         }
         else {
             System.out.println("No");
         }
         System.out.println("Our group:");
         print(groupA);
         System.out.println("--------------------------------------------------------------------");

         System.out.println("Second group:");
         print(groupB);

         System.out.println("--------------------------------------------------------------------");
         System.out.println("Join groups:");
         groupC = joinGroup(groupA, groupB);
         print(groupC);
         System.out.println("--------------------------------------------------------------------");
         System.out.println("Is new group contain second group?");
         if (containsAll(groupC, groupB)){
             System.out.println("Yes");
         }
         else {
             System.out.println("No");
         }
         System.out.println("--------------------------------------------------------------------");
         System.out.println("Is group 1 and 2 equal?");
         if (equals(groupA, groupB)){
             System.out.println("Yes");
         }
         else {
             System.out.println("No");
         }
         System.out.println("Is group 2 and 2 equal?");
         if (equals(groupB, groupB)){
             System.out.println("Yes");
         }
         else {
             System.out.println("No");
         }
         System.out.println("--------------------------------------------------------------------");
         System.out.println("Group");
         print(groupC);
         System.out.println("--------------------------------------------------------------------");
         System.out.println("Sorting:");
         groupC = sort(groupC);
         print(groupC);
     }

}
