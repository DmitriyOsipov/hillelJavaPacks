package Ex4;


import utilClasses.UserConsoleReader;

public class Palindrome {
    public static void main(String[] args) throws Exception{
        long num;
        UserConsoleReader userConsoleReader = new UserConsoleReader();
        do {
            System.out.println("Input number");
            num = userConsoleReader.readLong(0);
            System.out.println("=============Simple===============");
            if (checkPalindromeSimple(num)) {
                System.out.println("Number is palindrome");
            } else {
                System.out.println("Number is not palindrome");
            }
            System.out.println("=============Recursive============");
            System.out.println(checkPalindromeRec(String.valueOf(num)));
            System.out.println();
        }while (userConsoleReader.isRepeatYes());
    }

    public static boolean checkPalindromeSimple(long number){
        String num = String.valueOf(number);
        int numLastInd = num.length() - 1;
        boolean result = true;
        for (int i=0; ((i < numLastInd/2) && result); i++){
            if (num.charAt(i)!=num.charAt(numLastInd-i)){
                result = false;
            }
        }
        return result;
    }

    public static String checkPalindromeRec(String numStr){
        if (numStr.length()==1){
            return "Number is palindrome";
        }
        else{
            if (numStr.charAt(0) == numStr.charAt(numStr.length() - 1)){
                if (numStr.length()==2){
                    return "Number is palindrome";
                }else{
                    return checkPalindromeRec(numStr.substring(1, numStr.length()-1));
                }
            }
            else {
                return "Number is not palindrome";
            }
        }
    }
}
