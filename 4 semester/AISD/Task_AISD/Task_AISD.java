package task_aisd;

import java.io.*;
import java.util.StringTokenizer;

public class Task_AISD {
    
    public static int numberOfFiles(int N, int K){
       
       int mas[] = new int[N+1];
       mas[1]=K;
       mas[2]=K*K;
       int sum = 0;
       int t=3;
       while(t<=N){
           mas[t] = mas[t-1]*K + mas[t-2]*K;
           t++;
       }
       
       for(int i=1;i<N+1;i++){
               sum  = sum + mas[i];
           }
       
       return sum;
    
    }

    public static void main(String[] args) {

        try{
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            int K;//количество букв
            int N;//максимальная длинна
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str," ");

            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            
            if(K < 1 || K > 13){ System.out.println("Error with K!");}
            if(N < 1 || N > 50){ System.out.println("Error with N!");}
            
            int result;
            result = numberOfFiles(N,K);
            
            System.out.println(result + " ");
            
            bw.write(result + "");
            bw.close();

      }

    catch(IOException e){
        System.out.println("Error with write.");
        }

    }
    
}

