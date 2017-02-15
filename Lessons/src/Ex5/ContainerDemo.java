package Ex5;

import java.util.Date;
import java.util.Random;

/**
 * Created by mtzadmin on 14.02.2017.
 */
public class ContainerDemo {
    public static void main(String[] args) throws Exception{
        int[] firstArray = {1, 2, 3, 4, 5};
        int[] secondArray = {6, 7, 8};

        System.out.println("Print empty container:");
        ContainerInt firstContainer = new ContainerInt();
        System.out.println(firstContainer.toString());
        System.out.println("Init with one number:");
        firstContainer = new ContainerInt(firstArray[0]);
        System.out.println(firstContainer.toString());

        Random random = new Random();
        for (int i=0; i<50000; i++){
            firstContainer.add(random.nextInt(10000));
        }
        System.out.println(firstContainer.toString());

        ContainerInt secondContainer = firstContainer.clone();

        long start = System.currentTimeMillis();
        firstContainer.sort();
        long end = System.currentTimeMillis();
        double timeSortSeconds = (end - start);//1000;
        System.out.println(firstContainer.toString());
        System.out.println("Sorted in " + timeSortSeconds + " milliseconds");

        /*
        long start2 = System.currentTimeMillis();
        secondContainer.bubbleSort();
        long end2 = System.currentTimeMillis();
        double timeSortSeconds2 = (end2 - start2);///1000;
        System.out.println(secondContainer.toString());
        System.out.println("Sorted by bubbles in " + timeSortSeconds2 + " milliseconds");//*/

    }
}
