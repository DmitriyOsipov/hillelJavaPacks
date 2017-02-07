package Ex3;

import utilClasses.UserConsoleReader;

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
            System.out.println("\t" + num + " Fibonacci number is " + fn);
            System.out.println("----------------------------------------");
        }
        while (userConsoleReader.isRepeatYes());
    }
}
