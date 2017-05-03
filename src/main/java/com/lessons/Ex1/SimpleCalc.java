package com.lessons.Ex1;

import java.util.Scanner;

public class SimpleCalc {
    public static void main(String[] args) throws Exception {

        double x, y;

        x = SimpleCalc.readNumber("first");

        y = SimpleCalc.readNumber("second");

        System.out.println();
        System.out.println("Sum is " + (x + y));
        System.out.println("Difference is " + (x - y));
        System.out.println("Multiplication is " + (x * y));
        if(y!=0)
            System.out.println("Division is " + (x / y));
        else
            System.out.println("Division by zero is unacceptable");
    }

    private static double readNumber(String number)
    {
        double res = 0;
        boolean resOk;
        String num = "";

        Scanner sc = new Scanner(System.in);

        if (number!=null)
            num = number;

        System.out.println("Please, input " + num + " number");

        do {
            if (sc.hasNextDouble()) {
                res = sc.nextDouble();
                resOk = true;
            } else {
                sc.next();
                resOk = false;
                System.out.println("Number, please.");
            }
        }
        while (!resOk);


        System.out.println("Your input " + res + " as " + num + " number");

        return res;
    }

}
