package com.lessons.Ex4;

/**
 *
 */
import com.lessons.utilClasses.UserConsoleReader;
public class MassParser {
    public static void main(String[] args) throws Exception{
        UserConsoleReader userConsoleReader = new UserConsoleReader();
        System.out.println("Input weight:");
        double num = userConsoleReader.readDoublePositive();
        char unit = '3';
        System.out.println("Input your unit: ");
        System.out.println("1 - tonnes");
        System.out.println("2 - kilograms");
        System.out.println("3 - grams");
        System.out.println("4 - milligrams");

        switch (userConsoleReader.readChar()){
            case '1':{
                System.out.println("Unit is tonnes.");
                num = num * 1_000_000;
            }break;
            case '2':{
                System.out.println("Unit is kilograms");
                num = num * 1_000;
            }break;
            case '4':{
                System.out.println("Unit is milligrams");
                num = num / 1_000;
            }break;
            default:{
                System.out.println("Unit is grams");
            }break;
        }

        System.out.println();
        String parcedWeight = parceIntPart(num, 1);
        parcedWeight += parceFraction(num);
        System.out.println(parcedWeight);
    }

    public static String parceIntPart(double weight, int pow){
        weight = Math.round(weight);
        String result = "";
        double tmp = weight % 1000;
        //System.out.println(tmp);
        if (tmp!=0) {
            result = String.valueOf(tmp).replace(".0", "");
            switch (pow) {
                case 1: {
                    result = result + " grams ";
                }
                break;
                case 2: {
                    result = result + " kilograms ";
                }
                break;
                case 3: {
                    result = result + " tonnes ";
                }
                break;
                default: {

                }
                break;
            }
        }
        if (pow==3){
            return result;
        }
        result = parceIntPart(weight/1000, pow+1) + result;
        return result;
    }
    public static String parceFraction(double weight){
        String res = String.valueOf(weight % 1);
        res = res.substring(res.indexOf('.')+1, res.indexOf('.')+4) + " milligrams";
        return res;
    }

}
