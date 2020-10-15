package sample;
import java.io.*;
import java.io.IOException;

public class Controller {

    int k;

    public String FuncK(){
        String k1 = new String();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try
        {
            k1 = br.readLine();
        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения с клавиатуры");
        }

        return k1;
    }


    public int FuncKC(){
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
}
