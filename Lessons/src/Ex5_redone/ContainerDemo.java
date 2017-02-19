package Ex5_redone;

import java.util.Random;


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

        System.out.println("Init with an array");
        firstContainer = new ContainerInt(firstArray);
        System.out.println(firstContainer.toString());

        System.out.println("Size of container");
        System.out.println(firstContainer.getSize());

        System.out.println("3-rd element is");
        System.out.println(firstContainer.getElement(3));

        System.out.println("Index of 4 is ");
        System.out.println(firstContainer.indexOf(4));

        System.out.println("Does container contain 10?");
        System.out.println(firstContainer.contains(10));

        System.out.println("Delete last element");
        firstContainer.delete();
        System.out.println(firstContainer.toString());
        System.out.println("Delete 2-nd element");
        firstContainer.delete(1);
        System.out.println(firstContainer.toString());

        System.out.println("Add 10");
        firstContainer.add(10);
        System.out.println(firstContainer.toString());

        System.out.println("Sum of elements");
        System.out.println(firstContainer.getSum());
        System.out.println("Average of elements");
        System.out.println(firstContainer.getAverage());

        System.out.println("Second container");
        ContainerInt secondContainer = new ContainerInt(secondArray);
        System.out.println(secondContainer.toString());

        System.out.println("Are they equals?");
        System.out.println(firstContainer.equals(secondContainer));

        System.out.println("Does first container contain second?");
        System.out.println(firstContainer.containsAll(secondContainer));

        System.out.println("Join");
        firstContainer.join(secondContainer);
        System.out.println(firstContainer.toString());

        System.out.println("Does first container contain second?");
        System.out.println(firstContainer.containsAll(secondContainer));

        System.out.println("---------------------------------------------");
        System.out.println("Add some random numbers to first container");
        Random random = new Random();
        for (int i=0; i<50000; i++){
            firstContainer.add(random.nextInt(10000));
        }

        secondContainer = new ContainerInt(firstContainer.getArrayCopy());
        System.out.println(firstContainer.toString());

        System.out.println("Sort with quick sort");
        long start = System.currentTimeMillis();
        firstContainer.sort();
        long end = System.currentTimeMillis();
        double timeSortSeconds = (end - start);//1000;
        System.out.println(firstContainer.toString());
        System.out.println("Sorted in " + timeSortSeconds + " milliseconds");

        System.out.println("Sort with bubbles sort");
        long start2 = System.currentTimeMillis();
        secondContainer.bubbleSort();
        long end2 = System.currentTimeMillis();
        double timeSortSeconds2 = (end2 - start2);//1000;
        System.out.println(secondContainer.toString());
        System.out.println("Sorted with bubbles in " + timeSortSeconds2 + " milliseconds");



    }
}
