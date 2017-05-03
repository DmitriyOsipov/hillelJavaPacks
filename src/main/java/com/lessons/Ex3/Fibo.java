package com.lessons.Ex3;

import com.lessons.utilClasses.UserConsoleReader;

public class Fibo {
    public static void main(String[] args) throws Exception{
        double sqrt5 = Math.sqrt(5);
        double phi = (sqrt5 + 1)/2;
        int num = 0;

        UserConsoleReader userConsoleReader = new UserConsoleReader();

        do {

            System.out.println("Enter number");
            num = userConsoleReader.readInt(0);

            System.out.println("Calculating Fn with Golden ratio");
            long fn = Math.round(Math.pow(phi, num) / sqrt5);
            System.out.println("\t" + num + " Fibonacci number is " + fn);

            System.out.println("----------------------------------------");

            System.out.println("Calculating all numbers to Fn");
            long[] fibo = {0, 1};
            long fnAll = 1;
            System.out.print(fnAll + "  ");
            for (int i=1; i<num; i++){
                fnAll = fibo[0] + fibo[1];
                fibo[0] = fibo[1];
                fibo[1] = fnAll;
                if (i%20==0){
                    System.out.println();
                }
                System.out.print(fnAll + "  ");
            }
            System.out.println();
            System.out.println();
            System.out.println("\t" + num + " Fibonacci number is " + fnAll);

            System.out.println("----------------------------------------");
            System.out.println("Array version 2");
            System.out.println("Calculating all numbers to Fn");
            long[] fiboArray2 = new long[num];
            fiboArray2[0]=1;
            if (num>1) {
                fiboArray2[1] = 1;
            }
            for (int i=2; i<num; i++){
                fiboArray2[i] = fiboArray2[i-1] + fiboArray2[i-2];
            }
            for (long fiboEl : fiboArray2){
                System.out.print(fiboEl + "  ");
            }
            System.out.println();
            System.out.println();
            System.out.println("\t" + num + " Fibonacci number is " + fiboArray2[num-1]);
            System.out.println("----------------------------------------");

            System.out.println("Calculating Fn with recursion");
            try {
                long fiboRec = recFibo(num);
                System.out.println("\t" + num + " Fibonacci number is " + fiboRec);
            }
            catch (StackOverflowError er){
                System.out.println("Too many recursion! Stack overflow!");
            }

            System.out.println("----------------------------------------");
        }
        while (userConsoleReader.isRepeatYes());
    }

    public static long recFibo(int number){
        long res = 1;
        if (number == 1){
            return 1;
        }
        if (number==2){
            return 1;
        }
        res = recFibo(number-2) + recFibo(number - 1);
        return res;
    }
}
