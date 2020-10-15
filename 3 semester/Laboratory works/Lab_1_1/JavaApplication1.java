
package javaapplication1;
import java.text.*;

    public class JavaApplication1 {

    public static void main(String[] args) {

        lol l = new lol();

        double res;
        int koef;
        double ix;
        int format;

        System.out.print("Input k: ");
        koef = l.FuncK();
        System.out.print("Input how much numbers after point: ");
        format = l.FuncK();
        System.out.print("Input X, when X (-1,1): ");
        ix = l.FuncX();

        if(ix<=(-1) || ix>=1)
        {
            System.out.println("No in interval !");
        }
         else
        {
            double e1 = Math.pow(10, -koef-2);

            Controller cont = new Controller();
            res = cont.Summ(ix, e1);

            NumberFormat formatter = NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(format);
            System.out.print("Summ po function: ");
            System.out.println(formatter.format(res));
            
            System.out.print("Kontrol Summ: ");
            System.out.println((1 / Math.sqrt(1 + ix)) + " ");
        }
    }
}
