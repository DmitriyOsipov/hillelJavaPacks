package com.lessons.Ex3;

import com.lessons.utilClasses.UserConsoleReader;

import java.util.Arrays;
import java.util.Random;

public class SudentsDataExtended {

    public static void main(String[] args) throws Exception{
        demo();
    }

    public static String[][][] addStudent(String[][][] group, String newStudent){
        String[][][] result = null;

        if ((group==null)||(group.length==0)){
            result = new String[1][1][1];
            result[0][0][0] = newStudent;
            //result[0][1][0] = "";
        }
        else{
            result = new String[group.length + 1][][];
            for (int i=0; i < group.length; i++){
                result[i] = group[i];
            }
            result[group.length] = new String[1][1];
            result[group.length][0][0] = newStudent;
            //result[group.length][1][0] = "";
        }

        return result;
    }

    public static String[][] addDiscipline(String[][] disciplinesArray, String newDiscipline){
        String[][] result = null;
        /*
        if ((disciplinesArray==null)||(disciplinesArray.length==0)){
            result = new String[1][1];
            result[0][0] = newDiscipline;
        }*/
        //else
            if (countDisciplines(disciplinesArray, newDiscipline) == 0){
            result = new String[disciplinesArray.length + 1][];
            for (int i = 0; i < disciplinesArray.length; i++){
                result[i] = disciplinesArray[i];
                /*
                result[i] = new String [disciplinesArray[i].length];
                for (int j=0; j<disciplinesArray[i].length; j++){
                    result[i][j] = disciplinesArray[i][j];
                }*/
            }
            result[disciplinesArray.length] = new String[1];
            result[disciplinesArray.length][0] = newDiscipline;
        }
        else {
            result = disciplinesArray;
        }

        return result;
    }

    public static String[] addMark(String[] marksArray, String newMark){
        String[] result = new String[marksArray.length + 1];
        for (int i = 0; i < marksArray.length; i ++){
            result[i] = marksArray[i];
        }
        result[marksArray.length] = newMark;
        return result;
    }

    public static int indexOfDiscipline(String[][] disciplinesArray, String checkDiscipline){
        int result = -1;
        if (countDisciplines(disciplinesArray, checkDiscipline) != 0 ){
           for (int i=0; i<disciplinesArray.length; i++){
                if (disciplinesArray[i][0] == checkDiscipline){
                    result = i;
                }
            }
        }
        return result;
    }

    public static int countDisciplines(String[][] disciplinesArray, String checkDiscipline){
        int counter = 0;

        if ((disciplinesArray!=null)&&(disciplinesArray.length>0)){
            for (int i=0; i < disciplinesArray.length; i++){
                if (disciplinesArray[i][0].equals(checkDiscipline)){
                    counter++;
                }
            }
        }

        return counter;
    }

    public static int countStudents(String[][][] group, String studentName){
        int result = 0;
        if (group!=null){
            for (int i = 0; i < group.length; i++){
                if (group[i][0][0] == studentName){
                    result++;
                }
            }
        }
        return result;
    }
    public static int indexOfStudent(String[][][] group, String studentName){
        int result = -1;
        if (countStudents(group, studentName) != 0){
            for (int i=0; i < group.length; i++){
                if (group[i][0][0] == studentName){
                    result = i;
                    break;
                }
            }
        }
        return result;
    }

    public static String[][][] deleteStudent(String[][][] group, String studentName){
        if (studentName==null){
            System.out.println("Wrong name to delete");
            return group;
        }
        int countStudentsToDelete = countStudents(group, studentName);
        String[][][] result = null;
        if (countStudentsToDelete>1){
            System.out.println("There are " + countStudentsToDelete + " with this name.");
            System.out.println("Input index or -1 to delete all");
            UserConsoleReader userConsoleReader = new UserConsoleReader();
            int index = userConsoleReader.readInt();
            if (index == -1){
                result = new String[group.length - countStudentsToDelete][][];
                int resultIndex=0;
                for (int i=0; i<group.length; i++){
                    if (!group[i][0][0].equals(studentName)){
                        result[resultIndex] = group[i];
                        resultIndex++;
                    }
                }
            }
            else if((index>=0)&&(index<group.length)){
                result = deleteStudent(group, studentName, index);
            }
            else{
                System.out.println("Wrong index!");
            }
        }
        else if (countStudentsToDelete==1){
            result = deleteStudent(group, studentName, indexOfStudent(group, studentName));
        }
        else{
            result = group;
        }

        return result;
    }

    private static String[][][] deleteStudent(String[][][] group, String studentName, int index){
        String[][][] result = null;

        if ((studentName!=null)&&(group[index][0][0].equals(studentName))){
            result = new String[group.length - 1][][];
            int resultIndex = 0;
            for (int i=0; i<group.length;i++){
                if (i!=index){
                    result[resultIndex] = group[i];
                    resultIndex++;
                }
            }
        }
        else{
            System.out.println("Wrong name or index!");
            result = group;
        }

        return result;
    }

    private static String[][][] deleteStudent(String[][][] group, int index){
        String[][][] result = null;

        if ((index>=0)&&(index<group.length)){
            result = new String[group.length - 1][][];
            int resultIndex = 0;
            for (int i=0; i<group.length;i++){
                if (i!=index){
                    result[resultIndex] = group[i];
                    resultIndex++;
                }
            }
        }
        else{
            System.out.println("Wrong name or index!");
            result = group;
        }

        return result;
    }

    public static String[][][] sortStudents(String[][][] group){
        String[][][] result = null;
        if (group==null){
            System.out.println("There is no students in the list. Nothing to sort.");
        }
        else{
            result = group;
            boolean changes;
            do {
                changes = false;
                for (int i=0; i<result.length-1; i++){
                    if (result[i][0][0].compareToIgnoreCase(result[i+1][0][0])>0){
                        String[][] tmp = result[i+1];
                        result[i+1]=result[i];
                        result[i] = tmp;
                        changes = true;
                    }
                }
            }while (changes);
        }
        return result;
    }

    public static String[][][] clear(){
        return null;
    }

    public static String[][][] trim(String[][][] group){
        boolean deleted;
        String[][][] result = group;

        do {
            deleted=false;
            for (int i=0; ((!deleted)&&(i<result.length)); i++){
                if((result[i][0][0]==null)||(result[i][0][0].trim().length()==0)){
                    result = deleteStudent(result, i);
                    deleted = true;
                }
            }
        }while (deleted);

        return result;
    }

    public static String[][][] joinGroups(String[][][] firstGroup, String[][][] secondGroup){
        String[][][] result = null;
        if ((firstGroup!=null)&&(secondGroup==null)){
            result = firstGroup;
        }
        else if ((firstGroup==null)&&(secondGroup!=null)){
            result = secondGroup;
        }
        else if((firstGroup!=null)&&(secondGroup!=null)){
            result = new String[firstGroup.length + secondGroup.length][][];

            int resultIndex = 0;
            for (int i=0; i<firstGroup.length; i++){
                result[resultIndex] = firstGroup[i];
                resultIndex++;
            }
            for (int j=0; j<secondGroup.length; j++){
                result[resultIndex] = secondGroup[j];
                resultIndex++;
            }
        }
        return result;
    }

    public static boolean containsAll(String[][][] group, String[][][] groupWhat){
        boolean result = true;
        if ((group!=null)&&(groupWhat!=null)&&(group.length>=groupWhat.length)){
            for (int i=0; ((result)&&(i<groupWhat.length)); i++){
                if (countStudents(group, groupWhat[i][0][0])==0){
                    result = false;
                }
            }
        }
        else {
            result = false;
        }
        return result;
    }

    public static boolean equals(String[][][] groupOne, String[][][] groupTwo, boolean makeSortBeforeComparation){
        String[][][] groupFirst = groupOne;
        String[][][] groupSecond = groupTwo;
        if (makeSortBeforeComparation){
            groupFirst = sortStudents(copyGroup(groupFirst));
            groupSecond = sortStudents(copyGroup(groupSecond));
        }

        boolean result = true;
        if ((groupFirst==null)&&(groupSecond==null)){
            result = true;
        }
        else if (groupFirst.length==groupSecond.length){
            for (int i=0; ((result)&&(i<groupFirst.length)); i++){
                if (!groupFirst[i][0][0].equals(groupSecond[i][0][0])){
                    result = false;
                }
            }
        }
        else {
            result = false;
        }
        return result;
    }


    public static void printGroup(String[][][] group, String skipMark, String groupName){
        System.out.println("======================Students of \"" + groupName + "\"======================");
        if (group!=null){
            for (int i=0; i<group.length; i++){
                System.out.println(group[i][0][0]);
                for (int j=1; j<group[i].length; j++){
                    System.out.print("\t" + group[i][j][0] + " marks: ");
                    int skips=0;
                    for (int k = 1; k < group[i][j].length; k++){
                        if (group[i][j][k].startsWith(skipMark)){
                            skips++;
                        }
                        else {
                            System.out.print(group[i][j][k] + ", ");
                        }
                    }
                    System.out.println("\n\t\tSkipped " + skips + " lectures.");
                }
                System.out.println("-------------------------------------------------");
            }
        }
        else {
            System.out.println("Group is empty.");
        }
    }

    public static String[][][] copyGroup(String[][][] group){
        String[][][] result=null;
        if (group!=null){
            result = new String[group.length][][];
            for (int i=0; i<group.length; i++){
                result[i] = new String[group[i].length][];
                for (int j=0; j<group[i].length; j++){
                    result[i][j] = new String[group[i][j].length];
                    for (int k=0; k<group[i][j].length; k++){
                        result[i][j][k] = new String(group[i][j][k]);
                    }
                }
            }
        }
        return result;
    }


    public static void demo(){
        String[] namesA = {"Petrov", "Ivanov"};
        String[] namesB = {"Vasilyev", "Sidorov", "Abramovich"};
        String newStudent = "Nikolayev";
        String[][][] groupA = null, groupB=null, groupC=null;
        String skipMark = "NA", groupAName = "Group A", groupBName = "Group B", groupCName = "Group C";

        System.out.println("+++++Starting demonstration");
        System.out.println("Arrays of students");
        System.out.println("First: " + Arrays.toString(namesA));
        System.out.println("Second: " + Arrays.toString(namesB));
        System.out.println("New student: " + newStudent);

        System.out.println("++++Adding students to groups");
        for (int i=0; i<namesA.length; i++){
            groupA = addStudent(groupA, namesA[i]);
        }
        for (int i=0; i<namesB.length; i++){
            groupB = addStudent(groupB, namesB[i]);
        }
        printGroup(groupA, skipMark, groupAName);
        printGroup(groupB, skipMark, groupBName);

        String[][] subjects = {{"Algebra", "Physics", "Geometry"},
                                {"Literature", "Philosophy", "English"},
                                {"Biology", "Chemistry", "Medicine"},
                                {"Economics", "Management", "Accounting"},
                                {"Geography", "Logistics", "Traffic"},
                                {"Cultural studies", "Religious", "Philosophy"}};

        Random rand = new Random();

        System.out.println("++++Adding subjects");
        for (int i=0; i<groupA.length; i++){
            int subjInd = rand.nextInt(subjects.length);
            for (int j=0; j<subjects[subjInd].length; j++) {
                groupA[i] = addDiscipline(groupA[i], subjects[subjInd][j]);
            }
        }
        printGroup(groupA, skipMark, groupAName);

        for (int i=0; i<groupB.length; i++){
            int subjInd = rand.nextInt(subjects.length);
            for (int j=0; j<subjects[subjInd].length; j++) {
                groupB[i] = addDiscipline(groupB[i], subjects[subjInd][j]);
            }
        }
        printGroup(groupB, skipMark, groupBName);

        String[] marks = {"35", "25", "40", "50", skipMark, "15", "10", "27", "33", skipMark, "49"};

        System.out.println("++++Adding marks");
        for (int i=0; i < groupA.length; i++){
            for (int j=1; j<groupA[i].length; j++){
                int marksQuant = rand.nextInt(15);
                for (int k=0; k<marksQuant; k++) {
                    groupA[i][j] = addMark(groupA[i][j], marks[rand.nextInt(marks.length)]);
                }
            }
        }
        printGroup(groupA, skipMark, groupAName);

        for (int i=0; i < groupB.length; i++){
            for (int j=1; j<groupB[i].length; j++){
                int marksQuant = rand.nextInt(15);
                for (int k=0; k<marksQuant; k++) {
                    groupB[i][j] = addMark(groupB[i][j], marks[rand.nextInt(marks.length)]);
                }
            }
        }
        printGroup(groupB, skipMark, groupBName);

        System.out.println("++++Checking a new student in A");
        System.out.println("Count: " + countStudents(groupA, newStudent));
        System.out.println("++++Adding " + newStudent);
        groupA = addStudent(groupA, newStudent);
        printGroup(groupA, skipMark, groupAName);
        System.out.println("Count: " + countStudents(groupA, newStudent));
        System.out.println("+++++Delete " + newStudent);
        groupA = deleteStudent(groupA, newStudent);
        System.out.println("Count " + newStudent + ": " + countStudents(groupA, newStudent));
        printGroup(groupA, skipMark, groupAName);

        System.out.println("++++Adding '   ' as a new student and sort groupA:");
        groupA = addStudent(groupA, "      ");
        groupA = sortStudents(groupA);
        printGroup(groupA, skipMark, groupAName);
        System.out.println("++++++Trim groupA");
        groupA = trim(groupA);
        printGroup(groupA, skipMark, groupAName);

        System.out.println("++++Join groupA and groupB to groupC");
        groupC = joinGroups(groupA, groupB);
        printGroup(groupC, skipMark, groupCName);

        System.out.println("+++++Contains groupC groupB?");
        System.out.println(containsAll(groupC, groupB));
        System.out.println("+++++Contains groupA groupC?");
        System.out.println(containsAll(groupA, groupC));

        System.out.println("+++++Is groupC and groupB equal?");
        System.out.println(equals(groupC, groupB, false));
        System.out.println("+++++Is groupB and groupB equal?");
        System.out.println(equals(groupB, groupB, false));
        System.out.println("+++++Is groupB and sorted doOperation of groupB equal?");
        String[][][] copyB = copyGroup(groupB);
        copyB = sortStudents(copyB);
        printGroup(copyB, skipMark, "Sorted doOperation of B");
        System.out.println(equals(groupB, copyB, false));
        System.out.println("+++++Is groupB and sorted groupB equal if we insert 'true' as 'makeSortBeforeComparation' parameter to equals()?");
        System.out.println(equals(groupB, sortStudents(groupB), true));

    }
}

