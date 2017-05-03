package com.lessons.Ex4.MatrixEx;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Dreamer on 12.02.2017.
 */
public class MatrixClass {

    private int[][] array;

    public MatrixClass(int size){
        array = fillMatrixRand(size);
    }

    private int[][] fillMatrixRand(int size){
        int[][] result = new int[size][size];
        for (int i=0; i < size; i++){
            for (int j=0; j<size; j++){
                result[i][j] = getRand();
            }
        }
        return result;
    }

    public void printMatrix(){
        for (int i = 0; i < array.length; i++){
            for (int j=0; j< array[i].length; j++){
                System.out.print(array[i][j] + "\t\t");
            }
            System.out.println();
        }
    }


    private int getRand(){
        Random random = new Random();
        return (int)(Math.pow(-1, random.nextInt(2))*random.nextInt(21));
    }

    public int getMatrixSum(){
        int sum =0;
        for (int i=0; i < array.length; i++){
            for (int j=0; j<array[i].length; j++){
                sum+=array[i][j];
            }
        }
        return sum;
    }

    public int countPositives(){
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

    public int[] getMatrixSumLines(){
        int[] sum = new int[array.length];
        for (int i=0; i < array.length; i++){
            for (int j=0; j<array[i].length; j++){
                sum[i]+=array[i][j];
            }
        }
        return sum;
    }

    public double getMatrixAverage(){
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

    public int getMax(){
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

    public int getMin(){
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
