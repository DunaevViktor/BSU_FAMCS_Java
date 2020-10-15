package aisd_schitalka;

import java.io.*;
import java.util.StringTokenizer;

public class AISD_schitalka {

    public static class PersonInfo{
        PersonInfo nextP;
        PersonInfo prevP;
        int items;
        
        PersonInfo(){
            nextP = null;
            prevP = null;
            items = 0;
        }
        
        PersonInfo(PersonInfo nextP_1,PersonInfo prevP_1,int items_l){
            nextP = nextP_1;
            prevP = prevP_1;
            items = items_l;
        }  
    }
    
    
    public static void main(String[] args) {
    try{
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
        
        String inf = br.readLine();
        StringTokenizer st = new StringTokenizer(inf," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        PersonInfo mas[] = new PersonInfo[N];
        for (int i = 0; i < N; i++) {   
            mas[i] = new PersonInfo();
            mas[i].items = i;
        }
        
        if(N>1){
            //для первого элемента
            mas[0].nextP = mas[1];
            mas[0].prevP = mas[N - 1];
            //для последнего элемента
            mas[N - 1].nextP = mas[0];
            mas[N - 1].prevP = mas[N - 2];
            //для остальных элементов
            for (int i = 1; i < N - 1; i++) {
            mas[i].nextP = mas[i + 1];
            mas[i].prevP = mas[i - 1];
            }
        }
        
        PersonInfo thisis = new PersonInfo();
        thisis = mas[0];
        
        int M1 = M;
        for(int i=0;i<N-1;i++){
            int N1 = N - i;
                if (M1 >= N1) {
                    M = M1%N1;
                }
                if (M == 0) {
                    M = M + N1;
                }
            for(int j=0;j<M-1;j++){
                thisis = thisis.nextP;
            }
            thisis.prevP.nextP = thisis.nextP;
            thisis.nextP.prevP = thisis.prevP;
            thisis = thisis.nextP;
        }
        
        int otv = 0;
        otv = thisis.items + 1;
        
        bw.write(otv + "");
        bw.newLine();
       
    int F1 = otv;
    int F2 = L;
    int S2 = 0;
    
        int R = F2 - F1;//Math.abs
        S2 = R + 1;
            if(S2<=0){
                S2 = N - Math.abs(S2);
            } 
   
        bw.write(S2 + "");
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
