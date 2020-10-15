package zabastyle;

import java.io.*;
import java.util.StringTokenizer;

public class ZabaStyle {

    public static class KuvshinkaEPTA{
    
        int elem;
        int sum;
        
        KuvshinkaEPTA(){
            elem = 0;
            sum = 0;
        }
        
        KuvshinkaEPTA(int elem_1, int sum_1){
            elem = elem_1;
            sum = sum_1;
        }
        
}
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            
            int N = Integer.parseInt(br.readLine());
            KuvshinkaEPTA mas[] = new KuvshinkaEPTA[N];
            
            String kuvshiks = br.readLine();
            StringTokenizer st = new StringTokenizer(kuvshiks," ");
            
            for(int i=0;i<N;i++){
                mas[i] = new KuvshinkaEPTA();
                mas[i].elem = Integer.parseInt(st.nextToken());
            } 
            
         /*  for(int j=0;j<N;j++){
                System.out.print(mas[j].elem + " ");
            } */
            
            
           for(int i=0;i<N;i++){
               
               if(i==0){mas[i].sum = mas[i].elem;}
               if(i==1){mas[i].sum = -1;}
               if(i==2){mas[i].sum = mas[0].sum + mas[2].elem;}
               if(i>=3){
               
               int sum1step;
               int sum2step;
               ////////////////////////////////
               if(mas[i-2].sum != -1){
                   sum1step = mas[i-2].sum + mas[i].elem;
               }
               else{
                   sum1step = -1;
               }
               ////////////////////////////////
               if(mas[i-3].sum != -1){
                   sum2step = mas[i-3].sum + mas[i].elem;
               }
               else{
                   sum2step = -1;
               }
               ////////////////////////////////
               
               if(sum1step > sum2step){
                   mas[i].sum = sum1step;
               }
               else{
                   mas[i].sum = sum2step;
               }
               
            }    //if i>=3
        } //for
           
           
           //System.out.println(mas[N-1].sum + " ");
           
            bw.write(mas[N-1].sum + "") ; 
            bw.close();

      }

    catch (NullPointerException ex){
            System.out.println("Error with mas.");
        }
    catch(IOException e){
        System.out.println("Error with write.");
        }
        
        
    }
    
}
