package Ex3;

/**
 * Created by mtzadmin on 07.02.2017.
 */
public class SudentsDataExtended {
    public static void main(String[] args) throws Exception{
        String[][][] group = null;
        String skipMark = "NA";

        String[] names = {"Sidorov", "Petrov", "Ivanov"};
        for (String name:names) {
            group = addStudent(group, name);
        }
        group[2] = addDiscipline(group[2], "Math");
        /*
        group[0][1][0] = "Math";
        group[0][1][1] = "4";

        group[1][1][0] = "Philosophy";
        group[1][1][1] = "NA";*/
        //group[0][1][2] = skipMark;
        printGroup(group, skipMark, "Test");

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
}

