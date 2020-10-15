package task_56;

import java.io.*;
import java.util.StringTokenizer;

public class Task_56 {

    public static void main(String[] args) throws Exception{
        try{
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            
            int N = Integer.parseInt(br.readLine());
            int mas[] = new int[N];
            String nodes = br.readLine();
            
            StringTokenizer st = new StringTokenizer(nodes," ");
            
            for(int i=0;i<N;i++){
                mas[i]=Integer.parseInt(st.nextToken());
            }
          
            for(int j = N-1;j>0;j--){
                if(mas[j]<mas[(j-1)/2]){
                        bw.write("No");
                        bw.close();
                        return;
                }
            }
            
            bw.write("Yes");
            bw.close();
          
      }
        
    catch(IOException e){
        System.out.println("Error with write.");
        }
      
    }
        
}