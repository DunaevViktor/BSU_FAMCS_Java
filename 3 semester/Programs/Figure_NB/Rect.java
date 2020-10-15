/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package figure;

/**
 *
 * @author fpm.dunaev
 */
public class Rect extends Shape
{
    double a;
    double b;
    Rect(double q,double w)
    {
        a=q;
        b=w;
    }
    

   public double SQ()
     {  
       return a*b;
     }
public double PR()
   {
      return 2*(a+b);
   }
public void print()
  {
double s = SQ();
double p = PR();
System.out.println(s + " " + p);
  }
}
