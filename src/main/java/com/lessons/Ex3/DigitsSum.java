package com.lessons.Ex3;
import com.lessons.utilClasses.UserConsoleReader;

public class DigitsSum {
    public static int getDigitsSum(int inputNumber){
        int result = 0;
        int number = inputNumber;

        do {
            result += number % 10;
            number = (number - number % 10)/10;
            //number = number/10;
        }while(number>0);

        return result;
    }
    public static void main(String[] args) throws Exception{
        UserConsoleReader userConsoleReader = new UserConsoleReader();
        int inputNumber;

        do {
            System.out.println("Input your number");
            inputNumber = userConsoleReader.readInt(0);

            System.out.println("Result of digits addiction: ");
            System.out.println(getDigitsSum(inputNumber));
        }
        while (userConsoleReader.isRepeatYes());
        System.out.println("Bye!");
    }
}
