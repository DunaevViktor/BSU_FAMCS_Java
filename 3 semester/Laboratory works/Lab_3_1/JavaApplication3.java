package javaapplication3;
import java.io.*;
import java.io.IOException;
public class JavaApplication3 {

    public static void main(String[] args) {
          InputStreamReader isr = new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(isr);
          Controller l = new Controller();
          String s = new String();
          String s1 = new String();
          String s2 = new String();
          System.out.println("Input 3 Strings: ");
          s = l.FuncK(br);
          s1 = l.FuncK(br);
          s2 = l.FuncK(br);
            
        
        String ALF = new String("qwertyuiopasdfghjklzxcvbnm");
        boolean []A = new boolean[26];
        for (int i =0;i<26;i++){
            A[i] = false;
        }
        
        for (int i=0;i<s.length();i++)
        {
            char x;
            int a;
            x =s.charAt(i);
            a = ALF.indexOf(x);
            A[a] = true;
        }
        
        boolean []B = new boolean[26];
         for (int i =0;i<26;i++){
            B[i] = false;
        }
         
        for (int i=0;i<s1.length();i++)
        {
            char x;
            int j;
            x = s1.charAt(i);
            j = ALF.indexOf(x);
            B[j] = true;
        }
        
        
         boolean []D = new boolean[26];
         for (int i =0;i<26;i++){
            D[i] = false;
        }
         
        for (int i=0;i<s2.length();i++)
        {
            char x;
            int j;
            x = s2.charAt(i);
            j = ALF.indexOf(x);
            D[j] = true;
        }
        
        
        boolean []C = new boolean[26];
         for (int i =0;i<26;i++){
            C[i] = false;
        }
          int h=0;
        for (int i =0;i<26;i++)
        {
            if(A[i]==true && B[i]==true && D[i]==true){
                C[i]=true;
            }
            else{
                C[i]=false;
            }
           
            if(C[i]==true){ 
                h++;
                System.out.println("Bukva is ---- " + ALF.charAt(i) + " ");
            }
        }
        if(h==0){
            System.out.println("No elements!");
        }
    
}
}
