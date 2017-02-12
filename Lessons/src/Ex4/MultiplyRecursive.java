package Ex4;

import utilClasses.UserConsoleReader;

import java.math.BigInteger;

public class MultiplyRecursive {
    public static void main(String[] args) throws Exception{
        UserConsoleReader userConsoleReader = new UserConsoleReader();
        int firsNum, secondNum;
        long result=0L;

        do {
            System.out.println("Input first number");
            firsNum = userConsoleReader.readInt(-1);
            System.out.println("Input second number");
            secondNum = userConsoleReader.readInt(-1);
            try {
                result = multiply(firsNum, secondNum, firsNum);
                System.out.println(result);
            }
            catch (StackOverflowError error){
                System.out.println("Stack overflow error!");
            }
            //System.out.println(multiply(BigInteger.valueOf(firsNum), BigInteger.valueOf(secondNum), BigInteger.valueOf(firsNum)));

            System.out.println("For check: " + firsNum + " x " + secondNum + " = " + firsNum*secondNum);
        }while (userConsoleReader.isRepeatYes());
    }

    public static long multiply(int x, int y, long a){
        if ((x==0)||(y==0)){
            return 0;
        }
        if ((x==1)){
            return a=y;
        }
        if ((y==1)){
            return a;
        }
        return multiply(x, y-1, a+x);
    }
/*
    public static BigInteger multiply(BigInteger x, BigInteger y, BigInteger a){
        if (x.equals(BigInteger.ZERO) || y.equals(BigInteger.ZERO)){
            return BigInteger.ZERO;
        }
        if (x.equals(BigInteger.ONE)){
            return a = new BigInteger(y.toByteArray());
        }
        if (y.equals(BigInteger.ONE)){
            return a;
        }
        return multiply(x, y.subtract(BigInteger.ONE), a.add(x));
    }//*/
}
