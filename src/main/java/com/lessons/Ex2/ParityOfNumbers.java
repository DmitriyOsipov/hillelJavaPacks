package com.lessons.Ex2;

/**
 * Задание 4
 * Ввести число, определить четное или нет.
 */
import com.lessons.utilClasses.UserConsoleReader;

public class ParityOfNumbers {
    public static void main(String[] args) throws Exception{
        int enteredNumber=0;
        UserConsoleReader userConsoleReader = new UserConsoleReader();

        do{
            System.out.println("Enter integer number, please");
            enteredNumber = userConsoleReader.readInt();
            System.out.println("You entered " + enteredNumber);
            if (enteredNumber % 2 == 0){
                System.out.println("This is even number");
            }
            else{
                System.out.println("This is odd number");
            }

        }while (userConsoleReader.isRepeatYes());
        System.out.println("Bye!");
    }
}

