package Ex3;

import utilClasses.UserConsoleReader;

import java.util.Arrays;

public class SudentsDataExtended {

    public static void main(String[] args) throws Exception{
        String[][][] group = null;
        String skipMark = "NA";
        String groupName = "Test";

        String[] names = {"Sidorov", "Petrov", "Ivanov", " ", "", "    "};

        for (String name:names) {
            group = addStudent(group, name);
        }
        group[2] = addDiscipline(group[2], "Math");
        int mathInd = indexOfDiscipline(group[2], "Math");
        int stInd = indexOfStudent(group, "Ivanov");
        group[2][mathInd] = addMark(group[2][1], "NA");
        group[stInd][1] = addMark(group[2][1], "75");
        group[2][1] = addMark(group[2][1], "60");
        stInd = indexOfStudent(group, "Sidorov");
        group[stInd] = addDiscipline(group[stInd], "Literature");
        int litIndex = indexOfDiscipline(group[stInd], "Literature");
        group[stInd][litIndex] = addMark(group[stInd][litIndex], "50");
        group[stInd][litIndex] = addMark(group[stInd][litIndex], "25");
        group[stInd][litIndex] = addMark(group[stInd][litIndex], skipMark);
        /*
        group[0][1][0] = "Math";
        group[0][1][1] = "4";

        group[1][1][0] = "Philosophy";
        group[1][1][1] = "NA";*/
        //group[0][1][2] = skipMark;
        printGroup(group, skipMark, groupName);

        System.out.println("Sorting");
        group = sortStudents(group);
        printGroup(group, skipMark, groupName);
        /*group=clear();
        printGroup(group, skipMark, groupName);*/
        System.out.println("+++++++Trim+++++++++");
        group = trim(group);
        printGroup(group, skipMark, groupName);

        String[] names1 = {"Skipper", "Rico", "Kowalski", "Private"};
        String[] names2 = {"King Julien", "Maurice", "Mort"};
        String[][][] groupPenguins = null;
        String[][][] groupLemurs = null;
        String[][][] groupCharacters = null;

        System.out.println("++++Join nulls");
        groupCharacters = joinGroups(groupPenguins, groupLemurs);
        printGroup(groupCharacters, skipMark, "Nulls");
        for (String penguin:names1){
            groupPenguins = addStudent(groupPenguins, penguin);
        }

        System.out.println("++++Join penguins isn't null");
        groupCharacters = joinGroups(groupPenguins, groupLemurs);
        printGroup(groupCharacters, skipMark, "Penguins + nulls");

        for (String lemur:names2){
            groupLemurs = addStudent(groupLemurs, lemur);
        }

        System.out.println("++++Join null + lemurs");
        groupCharacters = joinGroups(null, groupLemurs);
        printGroup(groupCharacters, skipMark, "Nulls + lemurs");
        System.out.println("++++Join all");
        groupCharacters = joinGroups(groupPenguins, groupLemurs);
        printGroup(groupCharacters, skipMark, "Characters of The Penguins of Madagascar");

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
            groupFirst = sortStudents(groupFirst);
            groupSecond = sortStudents(groupSecond);
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
                        if (group[i][j][k] == (skipMark)){
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
                                {"Biology", "Chemistry", "Medicine"}};


    }
}

