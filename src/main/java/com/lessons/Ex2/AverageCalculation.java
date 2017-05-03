package com.lessons.Ex2;

/**
 * Задание 1
 *Программа, которая находит среднее арифметическое значение чисел любое количество.
 */
import java.util.Arrays;
import java.util.Random;

import com.lessons.utilClasses.UserConsoleReader;

public class AverageCalculation {
    public static void main(String[] args) throws Exception{
        double[] arrayOfNumbers;
        char choice=' ';

        MyAverage avg = new MyAverage();
        UserConsoleReader userConsoleReader = new UserConsoleReader();

        do {

            System.out.println("Input quantity of numbers:");
            int elementsAmount = userConsoleReader.readInt(0);
            arrayOfNumbers = new double[elementsAmount];

            System.out.println("1 - Enter array manually");
            System.out.println("2 - Generate array");
            System.out.println("3 - Calculate average for first " + elementsAmount + " numbers");

            choice = (char) System.in.read();
            switch (choice) {
                case '1': {
                    for (int index = 0; index < elementsAmount; index++) {
                        arrayOfNumbers[index] = userConsoleReader.readDouble("Input " + String.valueOf(index + 1) + " number");
                    }
                    System.out.println("Your array is: " + Arrays.toString(arrayOfNumbers));
                    System.out.println("Average is " + avg.calcAverage(arrayOfNumbers));
                }
                break;
                case '2': {
                    Random rand = new Random();
                    for (int index = 0; index < elementsAmount; index++) {
                        arrayOfNumbers[index] = rand.nextInt(255);
                    }
                    System.out.println("Your array is: " + Arrays.toString(arrayOfNumbers));
                    System.out.println("Average is " + avg.calcAverage(arrayOfNumbers));
                }
                break;
                case '3': {
                    System.out.println("Average of first " + elementsAmount + " numbers is " + avg.calcAverage(elementsAmount));
                }
                break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
        while (userConsoleReader.isRepeatYes());
        System.out.println("Bye");
    }
}
