package com.lessons.Ex2;

/*
*Задание 2
* отрисовка "графики"
*/
import com.lessons.utilClasses.UserConsoleReader;

public class MatrixGraphics {
    public static void main(String[] args) throws Exception{

        int xDimension, yDimension;
        char nullElement = ' ', symbolElement = '*';

        UserConsoleReader userConsoleReader = new UserConsoleReader();
        ArrPaint arrayPainting = new ArrPaint();

        do {
            System.out.println("Input x-dimension please");
            xDimension = userConsoleReader.readInt(1);
            System.out.println("Input y-dimension please");
            yDimension = userConsoleReader.readInt(1);

            char[][] matrix = arrayPainting.getClearMatrix(xDimension, yDimension, nullElement);

            System.out.println("------------Part A\t\"Perimeter\"---------------");

            arrayPainting.paintPerimeter(matrix);
            arrayPainting.showArray(matrix);

            System.out.println("------------Part B\t\"The envelope\"--------------");

            int indexDiagonalMain = 0, indexMatrixColumn = 0, indexDiagonalSecondary = (xDimension > yDimension) ? yDimension - 1 : xDimension - 1;
            do {
                matrix[indexDiagonalMain][indexMatrixColumn] = symbolElement;
                matrix[indexDiagonalSecondary][indexMatrixColumn] = symbolElement;
                indexDiagonalMain++;
                indexMatrixColumn++;
                indexDiagonalSecondary--;
            }
            while ((indexDiagonalMain < xDimension) && (indexMatrixColumn < yDimension) && (indexDiagonalSecondary >= 0));

            arrayPainting.showArray(matrix);
            System.out.println();

            System.out.println("------------Part C\t\"Chess board\"---------------");


            for (int indexXDimension = 0; indexXDimension < xDimension; indexXDimension++) {
                for (int indexYDimension = 0; indexYDimension < yDimension; indexYDimension++) {
                    matrix[indexXDimension][indexYDimension] = ((indexXDimension + indexYDimension) % 2 == 0) ? symbolElement : nullElement;
                }
            }
            arrayPainting.showArray(matrix);
        }
        while (userConsoleReader.isRepeatYes());
        System.out.println("Bye!");
    }
}

