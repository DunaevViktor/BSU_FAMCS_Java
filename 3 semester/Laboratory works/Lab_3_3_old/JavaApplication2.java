//Удалить первые k слов из каждой строки, сдвинув на их место последующие слова строки.
package javaapplication2;
import java.io.*;
import java.io.IOException;

public class JavaApplication2 {

    public static void main(String[] args)throws IOException {
      
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String MyString1;
        String MyString2;
        System.out.println("Input String 1 and String 2: ");
        MyString1 = in.readLine();
        MyString2 = in.readLine();
        Controller l = new Controller();
        int k;
        System.out.println("Input N: ");
        k=l.FuncKC();
          String[]BufferString1 = MyString1.split(" ",k+1);
          String[]BufferString2 = MyString2.split(" ",k+1);
          String FinishString1 = BufferString1[k];
          String FinishString2 = BufferString2[k];
          System.out.println("New String 1 --- " + FinishString1);
          System.out.println("New String 2 --- " + FinishString2);
    }
    
}
