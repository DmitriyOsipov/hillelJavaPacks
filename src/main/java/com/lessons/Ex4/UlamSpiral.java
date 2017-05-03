package com.lessons.Ex4;

import com.lessons.utilClasses.UserConsoleReader;

public class UlamSpiral {
    public static void main(String[] args) throws Exception{
        UserConsoleReader userConsoleReader = new UserConsoleReader();
        do {
            System.out.println("Input size:");
            int size = userConsoleReader.readInt(0);
            size = checkSize(size);
            long[][] array = createArray(size);
            int center = getCenter(size);
            System.out.println("Center of array is [" + center + ";" + center + "]\n");
            move(array, size, center);
            print(array, size);
        }while (userConsoleReader.isRepeatYes());
    }

    public static int checkSize(int size){
        if (size%2==0){
            size++;
            System.out.println("Size must be an odd number. New size is: " + size);
        }
        return size;
    }

    public static long[][] createArray(int size){
         return new long[size][size];
    }
    public static int getCenter(int size){
        return (size/2);
    }
    public static void print(long[][] array, int size){
        int maxNumDigits = String.valueOf(array[size-1][size-1]).length();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isNumberSimple(array[i][j])) {
                    System.out.print("(" + String.format("%"+maxNumDigits+"d", array[i][j]) + ") ");
                }
                else {
                    System.out.print("|" + String.format("%"+maxNumDigits+"d", array[i][j]) + "| ");
                }
            }
            System.out.println();
        }
    }
    public static void move(long[][] array, int size, int center){
        moveRight(array, size, 1, center, center);
    }
    public static void moveRight(long[][] array, int size, long number, int startI, int startJ){
        long sizeSqr = size*size;
        if (number<=sizeSqr){
            do {
                array[startI][startJ] = number++;
                startJ++;
            }while ((array[startI-1][startJ] != 0)&&(number<=sizeSqr)&&(startJ<size-1));
            moveUp(array, size, number, startI, startJ);
        }
    }
    public static void moveUp(long[][] array, int size, long number, int startI, int startJ){
        long sizeSqr = size*size;
        if (number<=sizeSqr){
            do {
                array[startI][startJ] = number++;
                startI--;
            }while ((array[startI][startJ-1] != 0)&&(number<=sizeSqr)&&(startI>0));
            moveLeft(array, size, number, startI, startJ);
        }
    }
    public static void moveLeft(long[][] array, int size, long number, int startI, int startJ){
        long sizeSqr = size*size;
        if (number<=sizeSqr){
            do {
                array[startI][startJ] = number++;
                startJ--;
            }while ((array[startI+1][startJ] != 0)&&(number<=sizeSqr)&&(startJ>0));
            moveDown(array, size, number, startI, startJ);
        }
    }
    public static void moveDown(long[][] array, int size, long number, int startI, int startJ){
        long sizeSqr = size*size;
        if (number<=sizeSqr){
            do {
                array[startI][startJ] = number++;
                startI++;
            }while ((array[startI][startJ+1] != 0)&&(number<=sizeSqr)&&(startI<size-1));
            moveRight(array, size, number, startI, startJ);
        }
    }

    public static boolean isNumberSimple(long userNumber){
        boolean isNumberSimple = true;

        double divideBorder = Math.sqrt(userNumber);
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
                        isNumberSimple = false;
                        break;
                    }
                }
            }
        }

        return isNumberSimple;
    }
}
