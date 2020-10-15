

package javaapplication1;

import java.io.*;
import java.io.IOException;
public class lol {

    int k;
    double x;

    public int FuncK(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try
        {
            String k1 = br.readLine();
             k = Integer.parseInt(k1);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Не целое число");
        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения с клавиатуры");
        }

        return k;
    }

    public double FuncX(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try

        {
            String k1 = br.readLine();
            x = Double.parseDouble(k1);
        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения с клавиатуры");
        }

        return x;
    }
}


