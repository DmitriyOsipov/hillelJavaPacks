package com.lessons.Ex2_someRedone;

import java.util.Scanner;

public class UserConsoleReader {
    public char readChar(){
        char result = ' ';
        Scanner scanner = new Scanner(System.in);
        result = scanner.next().charAt(0);
        return result;
    }
    public double readDouble(){
        double result = 0;
        boolean isResultOk=false;
        Scanner scanner = new Scanner(System.in);

        do {
            if (scanner.hasNextDouble()) {
                result = scanner.nextDouble();
                isResultOk = true;
            } else {
                scanner.next();
                isResultOk = false;
                System.out.println("Number, please.");
            }
        }
        while (!isResultOk);

        return result;
    }
    public double readDouble(String headerText){
        double result = 0;
        boolean isResultOk=false;
        Scanner scanner = new Scanner(System.in);

        System.out.println(headerText);
        do {
            if (scanner.hasNextDouble()) {
                result = scanner.nextDouble();
                isResultOk = true;
            } else {
                scanner.next();
                isResultOk = false;
                System.out.println("Number, please.");
            }
        }
        while (!isResultOk);

        return result;
    }
    public double readDoublePositive(){
        double result = 0;
        boolean isResultOk=false;
        Scanner scanner = new Scanner(System.in);

        do {
            if ((scanner.hasNextDouble()) && ((result = scanner.nextDouble()) >0)) {
                isResultOk = true;
            } else {
                scanner.next();
                isResultOk = false;
                System.out.println("Positive number, please.");
            }
        }
        while (!isResultOk);

        return result;
    }

    public int readInt(){
        int result = 0;
        boolean isResultOk=false;
        Scanner scanner = new Scanner(System.in);

        do {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                isResultOk = true;
            } else {
                scanner.next();
                isResultOk = false;
                System.out.println("Integer, please.");
            }
        }
        while (!isResultOk);

        return result;
    }
    public int readInt(int bound){
        int result = 0;
        boolean isResultOk=false;
        Scanner scanner = new Scanner(System.in);

        do {
            if ((scanner.hasNextInt())&&((result = scanner.nextInt())>bound)) {
                isResultOk = true;
            } else {
                //scanner.next();
                isResultOk = false;
                System.out.println("Integer, greater than " + bound + ", please.");
            }
        }
        while (!isResultOk);

        return result;
    }

    public boolean isRepeatYes() throws Exception{

        System.out.println("Enter 'y' to repeat");
        int readCharCode = System.in.read();
        if ((readCharCode == 121)||(readCharCode == 89)){ //y or Y
            return true;
        }
        else{
            return false;
        }
    }
}
