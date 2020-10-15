package javaapplication4;
import java.io.*;
import java.util.*;
import java.io.IOException;

public class JavaApplication4 {

    
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(isr);
          Contoller l = new Contoller();
          String s = new String();
          System.out.println("Input String: ");
          s = l.FuncK(br);
          StringTokenizer st = new StringTokenizer(s,"qwertyuiopasdfghjklzxcvbnm");
      
            String s1 = new String();
            if(st.hasMoreTokens()){
                
                s1 = st.nextToken();
                System.out.println("String is: " + s1);
            }
            else 
            {
                System.out.println("No string!");
            }   
        }     
    }   
    
   
