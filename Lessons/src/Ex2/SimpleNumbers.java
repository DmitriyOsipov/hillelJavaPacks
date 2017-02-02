package Ex2;

/**
 * Задание 5
 * Ввести число, определить простое ли оно.
 */
import utilClasses.*;

public class SimpleNumbers {
    public static void main(String[] args) throws Exception{
        int userNumber = 1;
        double divideBorder = 0;
        boolean isNumberSimple;
        UserConsoleReader userConsoleReader = new UserConsoleReader();

        do {
            isNumberSimple = true;
            System.out.println("Enter positive number, please");
            userNumber = userConsoleReader.readInt(1);
            divideBorder = Math.sqrt(userNumber);
            //dividers
            //I know, that here is too much conditions, but it is the easiest way, to solve the problem
            //we can reduce cycle loops using them
            if ((userNumber == 2)||(userNumber == 3))
            {
                isNumberSimple = true;
            }
            else {
                if (userNumber % 2 == 0) {
                    isNumberSimple = false;
                }
                else {
                    for (int checker = 3; checker <= divideBorder; checker = checker + 2) {
                        if (userNumber % checker == 0) {
                            System.out.println("Number " + userNumber + " is a composite number");
                            isNumberSimple = false;
                            break;
                        }
                    }
                }
            }

            if (isNumberSimple){
                System.out.println("Number " + userNumber + " is simple");
            }
        }
        while (userConsoleReader.isRepeatYes());
        System.out.println("Bye!");
    }
}

