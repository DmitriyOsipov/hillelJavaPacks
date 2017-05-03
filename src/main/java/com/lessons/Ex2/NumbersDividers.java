package com.lessons.Ex2;

/**
 * Задание 6
 * Ввести число, определить каким числам оно кратно.
 */
import com.lessons.utilClasses.UserConsoleReader;

public class NumbersDividers {
    public static void main(String[] args) throws Exception{
        int userNumber=0;
        int dividerCounter;
        int printDividersPerLine = 15;
        UserConsoleReader userConsoleReader = new UserConsoleReader();

        do {
            dividerCounter = 1;
            System.out.println("Enter your number (positive)");
            userNumber = userConsoleReader.readInt(0);
            System.out.println("Dividers of " + userNumber);
            for (int divider = 2; divider <= userNumber/2; divider++){
                if (userNumber % divider == 0){
                    System.out.print(divider + "\t\t");
                    dividerCounter++;
                }
                if (dividerCounter % printDividersPerLine == 0){
                    dividerCounter = 1;
                    System.out.println();
                }
            }
            System.out.println();
        }
        while (userConsoleReader.isRepeatYes());
        System.out.println("Bye!");
    }
}

