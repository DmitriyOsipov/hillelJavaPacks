package com.lessons.Ex2_someRedone;

/**
 * Задание 2
 * Программу, которая предлагает пользователю
 *   ввести
 *      сумму денежного вклада в гривнах,
 *      процент годовых, которые выплачивает банк,
 *      длительность вклада (лет).
 * Вывести
 *      накопленную сумму денег за каждый год
 *      и начисленные проценты.
 */
import com.lessons.utilClasses.UserConsoleReader;
import java.math.BigDecimal;
import java.math.MathContext;

public class DepositPercentsBD {
    public static void main(String[] args) throws Exception{
        double sum=0;// percents=0;
        BigDecimal sumFromPercents, totalSum, percentsBD;
        int years;
        UserConsoleReader userConsoleReader = new UserConsoleReader();
        do {
            System.out.println("Input your sum of deposit");
            sum = userConsoleReader.readDoublePositive();
            totalSum = new BigDecimal(sum);
            System.out.println("Input bank percent");
            percentsBD = new BigDecimal(userConsoleReader.readDouble() / 100);
            System.out.println("Input the duration of the contribution");
            years = userConsoleReader.readInt();

            for (int yearCounter = 0; yearCounter < years; yearCounter++) {
                System.out.println("Year " + String.valueOf(yearCounter + 1));
                sumFromPercents = totalSum.multiply(percentsBD);
                System.out.println("\tPercents: " + sumFromPercents.round(MathContext.DECIMAL32).toString());
                totalSum = totalSum.add(sumFromPercents);
                System.out.println("\tTotal: " + totalSum.round(MathContext.DECIMAL32).toString());
            }
        }
        while (userConsoleReader.isRepeatYes());
        System.out.println("Bye!");
    }
}
