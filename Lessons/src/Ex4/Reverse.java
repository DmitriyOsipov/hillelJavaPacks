package Ex4;

/*Развернуть число (123456 -> 654321)
 */
import utilClasses.UserConsoleReader;

public class Reverse {
    public static void main(String[] args) throws Exception{
        UserConsoleReader userConsoleReader = new UserConsoleReader();
        do{
            System.out.println("Input your number");
            int inputNumber = userConsoleReader.readInt(0);
            System.out.println("Input is: " + inputNumber);

            System.out.println("Reversed: " );
            reverseNumber(inputNumber);
            System.out.println();
        }while (userConsoleReader.isRepeatYes());
    }

    public static int reverseNumber(int input){
        if (input<10){
            System.out.print(input);
            return input;
        }
        System.out.print(input%10);
        return reverseNumber(input/10);
    }

}
