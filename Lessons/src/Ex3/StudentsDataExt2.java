package Ex3;

public class StudentsDataExt2 {
    public static void main(String[] args) throws Exception{
        String[][][] students = null;
        String absence = "NA";

        students = addStudent(students, "Ivanov");

        printStudents(students, absence);

    }

    public static String[][][] addStudent(String[][][] group, String newStudent){
        String[][][] result = null;
        int newSize=0;

        if ((newStudent!=null)&&(newStudent.length()>0)){
            if ((group == null)||(group.length == 0)){
                newSize = 1;
                result = new String[newSize][1][1];
            }
            else {
                newSize = group.length + 1;
                result = new String[newSize][][];
                for (int i=0; i < newSize - 1; i++){
                    result[i] = group[i];
                }
            }

            result[newSize - 1][0][0] = newStudent;

        }

        return result;
    }

    public static String[][][] addSubject(String[][][] group, String student, String subject){
        String[][][] result = group;
        if ((student!=null)&&(student.length()>0)){
            switch (countContainsStudent(group, student)){
                case 0: {
                    result = addStudent(result, student);
                }
                case 1:{
                    int index = indexOf(result, student);
                    //result[index]
                    for (int j=1; j < group[index].length; j++){
                        for (int k=1; k < group[index][j].length; k++){

                        }
                    }
                }break;
                default:{
                    System.out.println("Cannot add subjects. There are too many such students.");
                }
            }
        }
        return result;
    }

    public static int countContainsStudent(String[][][] group, String student){
        int result = 0;
        if ((group == null)|| (group.length == 0)){
            System.out.println("Group is empty! No contains.");
        }
        else {
            for (int i=0; i<group.length; i++){
                if (group[i][0][0].equals(student)){
                    result++;
                }
            }
        }
        return result;
    }
    public static int indexOf(String[][][] group, String student){
        int res = -1;

        switch (countContainsStudent(group, student)){
            case 0:{
                System.out.println("There is no such student");
            }break;
            default:{
                do {
                    res++;
                }while (group[res][0][0].equals(student));
            }
        }

        return res;
    }

    public static void printStudents(String[][][] group, String absenceMark){
        if (group!=null){
            for (int i=0; i<group.length; i++){
                System.out.println(group[i][0][0]);
                for (int j=1; j<group[i].length; j++){
                    System.out.print("\t" + group[i][j][1] + " marks: ");
                    int skips=0;
                    for (int k = 1; k < group[i][j].length; k++){
                        if (group[i][j][k].equals(absenceMark)){
                            skips++;
                        }
                        else {
                            System.out.print(group[i][j][k] + " ");
                        }
                    }
                    System.out.println("\t\tSkipped " + skips + " lectures.");
                }
                System.out.println("-------------------------------------------------");
            }
        }
        else {
            System.out.println("Group is empty.");
        }
    }

}
