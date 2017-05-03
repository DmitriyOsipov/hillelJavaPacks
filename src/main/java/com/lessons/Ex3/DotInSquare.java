package com.lessons.Ex3;


import com.lessons.utilClasses.UserConsoleReader;

public class DotInSquare {
    public static void main(String[] args) throws Exception{
        int[][] points = new int[2][];
        int[] checkedPoint = new int[2];
        UserConsoleReader userConsoleReader = new UserConsoleReader();

        do {

            for (int i = 0; i < points.length; i++) {
                System.out.println((i + 1) + " point:");
                points[i] = userConsoleReader.readPointCoordinates();
            }

            System.out.println("Point:");
            checkedPoint = userConsoleReader.readPointCoordinates();

            if ((checkedPoint[0] <= Math.max(points[0][0], points[1][0])) && (checkedPoint[0] >= Math.min(points[0][0], points[1][0]))
                    && (checkedPoint[1] <= Math.max(points[0][1], points[1][1])) && (checkedPoint[1] >= Math.min(points[0][1], points[1][1]))) {
                System.out.println("Point is in the square");
            } else {
                System.out.println("Point is outside the square");
            }
        }while (userConsoleReader.isRepeatYes());
    }
}
