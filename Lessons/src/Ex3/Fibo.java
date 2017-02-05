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

            long Fn = Math.round(Math.pow(phi, num) / sqrt5);
            System.out.println(num + " Fibonacci number is " + Fn);
        }
        while (userConsoleReader.isRepeatYes());
    }
}
