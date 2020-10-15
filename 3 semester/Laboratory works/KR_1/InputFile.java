package contrwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class InputFile {
    String a;
    int b;
    FileReader fr;
    BufferedReader br;
    String nameFile;
    InputFile(String name)
    {
        try
        {
        fr = new FileReader(name);        
        br = new BufferedReader(fr);
        nameFile=name;
        }
        catch (IOException e)
		{
			System.out.println("Ошибка чтения");
		}
    }
     public String stringTake() 
    {       
        a=new String();
        try
	{
            a=br.readLine();
        }
       catch (IOException e)
		{
			System.out.println("Ошибка чтения с клавиатуры");
		}
        return a;
        
    }
    public int intTake()// throws IOException
    {
        b=0;        
        try
	{
        String line = br.readLine();
        b = Integer.parseInt(line);      
        }
        catch (NumberFormatException e) 
                    
                {
			System.out.println("Не целое число");
		}
		catch (IOException e)
		{
			System.out.println("Ошибка чтения с клавиатуры");
		}
        return b;
    }
}
