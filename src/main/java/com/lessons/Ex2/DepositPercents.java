package com.lessons.Ex2;

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

public class DepositPercents {
    public static void main(String[] args) throws Exception{
        double sum=0, percents=0, sumFromPercents = 0;
        int years;
        UserConsoleReader userConsoleReader = new UserConsoleReader();

        do {
            System.out.println("Input your sum of deposit");
            sum = userConsoleReader.readDoublePositive();
            System.out.println("Input bank percent");
            percents = userConsoleReader.readDouble() / 100;
            System.out.println("Input the duration of the contribution");
            years = userConsoleReader.readInt();

            for (int yearCounter = 0; yearCounter < years; yearCounter++) {
                System.out.println("Year " + String.valueOf(yearCounter + 1));
                sumFromPercents = sum * percents;
                System.out.println("\tPercents: " + sumFromPercents);
                sum += sumFromPercents;
                System.out.println("\tTotal: " + sum);
            }
        }
        while (userConsoleReader.isRepeatYes());
        System.out.println("Bye!");
    }
}
