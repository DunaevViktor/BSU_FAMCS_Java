package pkg66_1;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) {
         try{
        
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            
        String inf = br.readLine();
        StringTokenizer st = new StringTokenizer(inf," ");
        int N = Integer.parseInt(st.nextToken());//vershini
        
        int[] mas = new int[N+1];
        for(int i = 1;i<N+1;i++){
            mas[i] = 0;
        }
     
      String s;
      int count = 1;
      int[] str = new int[N+1];
        while(br.ready()){
                    s = br.readLine();
                    st = new StringTokenizer(s," ");
                    for(int i=1;i<N+1;i++){
                        str[i] = Integer.parseInt(st.nextToken());
                    }
                  
                    for(int i=1;i<N+1;i++){
                        if(str[i] == 1){
                           mas[i] = count;
                        }
                    }     
                    count++;  
        } 
      
      for(int i = 1;i<N+1;i++){
            bw.write(mas[i] + " ");
        }
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
