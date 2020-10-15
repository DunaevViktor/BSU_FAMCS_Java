package matr_smezn;

import java.io.*;
import java.util.StringTokenizer;

public class Matr_Smezn { 
    
    public static class Info{
    int znach;
    Info i;
    
    Info(){
        znach = 0;
        i = null;
    }
}
    
    public static void main(String[] args){
        try{
        
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            
        String inf = br.readLine();
        StringTokenizer st = new StringTokenizer(inf," ");
        int N = Integer.parseInt(st.nextToken());//vershini
        int M = Integer.parseInt(st.nextToken());//rebra
        
        Info[] mas = new Info[N];
        
        int[] count = new int[N];
        
        for(int i = 0;i<N;i++){
            mas[i] = new Info();
        }
            
            String s;
            int a = 0;
            int b = 0;
                while(br.ready()){
                    s = br.readLine();
                    st = new StringTokenizer(s," ");
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                           //spisoki        
                }
            //write to file
        bw.close();       
    } 
    catch(IOException e){
        System.out.println("Error with write.");
        }
    catch (NullPointerException ex){
            System.out.println("Error with mas.");
        }
    }  
}
