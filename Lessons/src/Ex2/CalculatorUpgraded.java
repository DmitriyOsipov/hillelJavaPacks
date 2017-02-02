package Ex2;

/**
 * Задание 0
 *Новое требование от заказчика калькулятора -
 *переделать калькулятор, чтобы при неправильном вводе чисел программа запрашивала число заново
 *и пользователь сам вводил операцию (+- * /)
 */
import utilClasses.*;

public class CalculatorUpgraded {
    public static void main(String[] args) throws Exception {

        double firstOperand, secondOperand;
        char operationType;
        UserConsoleReader userConsoleReader = new UserConsoleReader();
        do {

            firstOperand = userConsoleReader.readDouble("Input first operand");
            secondOperand = userConsoleReader.readDouble("Input second operand");
            System.out.println();

            System.out.println("Choose operation (+ - * /):");
            operationType = (char) System.in.read();
            switch (operationType) {
                case '+':{
                    System.out.println("Sum is " + (firstOperand + secondOperand));
                }
                break;
                case '-':{
                    System.out.println("Difference is " + (firstOperand - secondOperand));
                }
                break;
                case '*': {
                    System.out.println("Multiplication is " + (firstOperand * secondOperand));
                }
                break;
                case '/': {
                    if (secondOperand != 0) {
                        System.out.println("Division is " + (firstOperand / secondOperand));
                    }
                    else {
                        System.out.println("Division by zero is unacceptable");
                    }
                }
                break;
                default: {
                    System.out.println("No such operation!");
                }break;
            }
        }
        while ( userConsoleReader.isRepeatYes());
        System.out.println("Bye!");
    }
}
