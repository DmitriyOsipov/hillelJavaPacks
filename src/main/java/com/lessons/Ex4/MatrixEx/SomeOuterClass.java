package com.lessons.Ex4.MatrixEx;

import com.lessons.utilClasses.UserConsoleReader;
import java.util.Arrays;

/**
 * Created by Dreamer on 12.02.2017.
 */

public class SomeOuterClass {
    public static void main(String[] args) throws Exception{
        UserConsoleReader userConsoleReader = new UserConsoleReader();

        do {
            int matrixSize = 0;
            System.out.println("Input matrix size: ");
            matrixSize = userConsoleReader.readInt(0);

            MatrixClass matrix = new MatrixClass(matrixSize);
            System.out.println("Our matrix:");
            matrix.printMatrix();
            System.out.println();
            System.out.println("Sum of elements: " + matrix.getMatrixSum());
            System.out.println("Sum of elements by lines: " + Arrays.toString(matrix.getMatrixSumLines()));
            System.out.println("Average of elements: " + matrix.getMatrixAverage());
            System.out.println("Amount of positive elements: " + matrix.countPositives());
            System.out.println("Minimum element: " + matrix.getMin());
            System.out.println("Maximum element: " + matrix.getMax());
            System.out.println();
        } while (userConsoleReader.isRepeatYes());
    }
}
