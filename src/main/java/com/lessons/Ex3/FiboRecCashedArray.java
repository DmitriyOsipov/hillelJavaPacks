package com.lessons.Ex3;

import com.lessons.utilClasses.UserConsoleReader;

import java.math.BigInteger;
import java.util.ArrayList;

public class FiboRecCashedArray {
    //private static BigInteger[] cache = null;
    public static ArrayList<BigInteger> cache;// = new ArrayList<BigInteger>();
    public static void main(String[] args) throws Exception{
        UserConsoleReader userConsoleReader = new UserConsoleReader();
        do {
            System.out.println("Insert number: ");

            int number = userConsoleReader.readInt(0);
            BigInteger fiboRec = fiboCashed(number, BigInteger.ZERO, BigInteger.ONE);
            System.out.println("===============================================================");
            System.out.println(number + " Fibonacci number (counted by recursion with cache) is");
            System.out.println(fiboRec.toString());
            //cache = null;
        }while (userConsoleReader.isRepeatYes());
    }

    public static BigInteger fiboCashed(int num, BigInteger firstEl, BigInteger secondEl){
        BigInteger result;
        if (cache == null ){
            cache = new ArrayList<BigInteger>();
            cache.add(BigInteger.ZERO);
            //cache[1] = BigInteger.ONE;
        }
        if ((num == 1)){
            return BigInteger.ONE;
        }
        if (cache.size()>=(num+1)){
            return cache.get(num);
        }
        result = firstEl.add(fiboCashed(num-1, secondEl, secondEl.add(firstEl)));
        cache.add(result);
        return result;
    }

}
