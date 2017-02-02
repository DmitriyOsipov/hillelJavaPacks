package Ex2;


public class MyAverage {

    public double calcAverage(double[] arr){
        double res = 0;

        for (int ind=0; ind < arr.length; ind ++)
            res += arr[ind];
        res = res / arr.length;

        return res;
    }

    public double calcAverage(double num){
        double res = this.calcSum(num);

        res = res / num;
        return res;
    }

    private double calcSum(double number){
        double res = 0;

        if (number == 1)
            return 1;
        else
            res = number + calcSum(number-1);
        return res;
    }
}

