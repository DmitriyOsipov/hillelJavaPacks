package utilClasses;

import javafx.util.converter.IntegerStringConverter;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class UserConsoleReader {
    public int[] readPointCoordinates() throws Exception{
        int[] coordinates ={0, 0};
        System.out.println("\tEnter coordinates of the point (x y)");
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        if (arr.length == 2){
            try {
                coordinates[0] = Integer.parseInt(arr[0]);
                coordinates[1] = Integer.parseInt(arr[1]);
            }
            catch (NumberFormatException ex)
            {
                System.out.println("\tWrong format");
            }
        }
        else{
            System.out.println("\tWrong format");
        }

        System.out.println("\tCoordinates of the point: " + Arrays.toString(coordinates));
        return coordinates;
    }

    public char readChar(){
        char result = ' ';
        Scanner scanner = new Scanner(System.in);
        result = scanner.next().charAt(0);
        return result;
    }

    public String readString(){
        String result = "";
        Scanner scanner = new Scanner(System.in);
        result = scanner.next();
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
