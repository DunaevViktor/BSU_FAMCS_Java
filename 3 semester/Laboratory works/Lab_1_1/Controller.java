
package javaapplication1;

public class Controller {

    double sum ;
    double sl ;
    int count;

    public double Summ(double x, double e1)
    {
         sum = 1.0;
         sl = x * (-0.5); 
         count = 2;

        while(Math.abs(sl)>e1) 
        {
            sum = sum + sl; 
            sl = sl * x * (-1) * (count *2 - 1) / (count *2); 
            count ++;
        }
        return sum;
    }

}
