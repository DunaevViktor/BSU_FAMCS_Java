

package figure;

class Circle extends Shape
{
    double o;
    Circle(double t)
    {
        o=t;
    }
    
    
   public double SQ()
     {  
       return o*o*Math.PI;
     }
   public double PR()
     {
       return 2*o*Math.PI;
     }
   public void print()
     {
double s = SQ();
double p = PR();
System.out.println(s + " " + p);
     }
}
