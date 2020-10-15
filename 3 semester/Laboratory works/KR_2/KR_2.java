package kr_2;

import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class KR_2 {
    
 Integer password, password2;
 ArrayList<Integer> answ = new ArrayList<Integer> ();
 
    boolean check(int[] symb,int len){
       int check = 0;
       int answer = 0;
       for(int i=0;i<len;i++){
           check+=symb[i];
           answer+=(symb[i]*(int)Math.pow(10, len-i-1));
       }
      
       if((check%9==0) && !answ.contains(answer) && answer!=password2){
           answ.add(answer);
           System.out.println(answer);
           return true;
       }
       else 
           return false;
    }
    public void init() throws FileNotFoundException{
        Scanner in = new Scanner(new File("input.txt"));
        password = in.nextInt();
        password2= password;
        //Если число в заданном промежутке
        if(password>=1 && password<=Math.pow(10, 9)){
            String str = password.toString();
            int len = str.length();
            int[] symb = new int[len];
            //массив из цифр числа
            for(int i=len-1;i>=0;i--){
                symb[i]=password % 10;
                password/= 10;
            }
            
            for(int i=0;i<len;i++)
                for(int j=0;j<10;j++){
                    int temp = symb[i];
                    symb[i]=j;
                    if(symb[0]!=0){
                        check(symb,len);
                }
                    symb[i] = temp;
            }
                
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        
        KR_2 T = new KR_2();
        T.init();
    }
    
}
