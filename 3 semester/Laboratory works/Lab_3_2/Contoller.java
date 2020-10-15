

package javaapplication4;

import java.io.*;
import java.io.IOException;

public class Contoller {

    int k;

    public String FuncK(BufferedReader br){
        String k1 = new String();
 
        try
        {
            k1 = br.readLine();
            k1 = k1.toLowerCase();
        }
        catch(IOException e)
        {
            System.out.println("Ошибка чтения с клавиатуры");
        }

        return k1;
    }
    
}

