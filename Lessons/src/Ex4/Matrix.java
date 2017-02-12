package Ex4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Dreamer on 12.02.2017.
 */
public class Matrix {
    public static void main(String[] args) throws Exception{
        int[][] matrix;// = new int[10][10];
        matrix = fillMatrixRand(3);
        printMatrix(matrix);

        System.out.println("Sum: " + getMatrixSum(matrix));
        System.out.println("Average: " + getMatrixAverage(matrix));
        System.out.println("Sum by lines: " + Arrays.toString(getMatrixSumLines(matrix)));
        System.out.println("Amount of positives: " + countPositives(matrix));
        System.out.println("Maximum is: " + getMax(matrix));
        System.out.println("Minimum is: " + getMin(matrix));
    }

    public static int[][] fillMatrixRand(int size){
        int[][] result = new int[size][size];
        for (int i=0; i < size; i++){
            for (int j=0; j<size; j++){
                result[i][j] = getRand();
            }
        }
        return result;
    }

    public static void printMatrix(int[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j=0; j< array[i].length; j++){
                System.out.print(array[i][j] + "\t\t");
            }
            System.out.println();
        }
    }


    public static int getRand(){
        Random random = new Random();
        return (int)(Math.pow(-1, random.nextInt(2))*random.nextInt(21));
    }

    public static int getMatrixSum(int[][] array){
        int sum =0;
        for (int i=0; i < array.length; i++){
            for (int j=0; j<array[i].length; j++){
                sum+=array[i][j];
            }
        }
        return sum;
    }

    public static int countPositives(int[][] array){
        int amount =0;
        for (int i=0; i < array.length; i++){
            for (int j=0; j<array[i].length; j++){
                if (array[i][j]>0) {
                    amount++;
                }
            }
        }
        return amount;
    }

    public static int[] getMatrixSumLines(int[][] array){
        int[] sum = new int[array.length];
        for (int i=0; i < array.length; i++){
            for (int j=0; j<array[i].length; j++){
                sum[i]+=array[i][j];
            }
        }
        return sum;
    }

    public static double getMatrixAverage(int[][] array){
        double sum =0;
        int amount = 0;
        for (int i=0; i < array.length; i++){
            amount+=array[i].length;
            for (int j=0; j<array[i].length; j++){
                sum+=array[i][j];
            }
        }
        return sum/amount;
    }

    public static int getMax(int[][] array){
        int max = array[0][0];
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array.length; j++){
                if (max<array[i][j]){
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    public static int getMin(int[][] array){
        int min = array[0][0];
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array.length; j++){
                if (min>array[i][j]){
                    min = array[i][j];
                }
            }
        }
        return min;
    }
}
