package Ex3;

import utilClasses.UserConsoleReader;
import java.math.BigInteger;
import java.util.HashMap;

public class FiboRecCashed {
    private static HashMap<Integer, BigInteger> cache = new HashMap<Integer, BigInteger>();
    public static void main(String[] args) throws Exception{
        UserConsoleReader userConsoleReader = new UserConsoleReader();
        do {
            System.out.println("Insert number: ");

            int number = userConsoleReader.readInt(0);
            BigInteger fiboRec = fiboCashed(number, BigInteger.ZERO, BigInteger.ONE);
            System.out.println("===============================================================");
            System.out.println(number + " Fibonacci number (counted by recursion with cache) is");
            System.out.println(fiboRec.toString());

        }while (userConsoleReader.isRepeatYes());
    }

    public static BigInteger fiboCashed(int num, BigInteger firstEl, BigInteger secondEl){
        BigInteger result;
        if (num == 1){
            return BigInteger.ONE;
        }
        if ((result= cache.get(num))!=null){
            return result;
        }
        result = firstEl.add(fiboCashed(num-1, secondEl, secondEl.add(firstEl)));
        cache.put(num, result);
        return result;
    }

}
