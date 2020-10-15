package spisk_smezn;
import java.io.*;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Spisk_Smezn {
    public static void main(String[] args) {
       try{
        
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            
        String inf = br.readLine();
        StringTokenizer st = new StringTokenizer(inf," ");
        int N = Integer.parseInt(st.nextToken());//vershini
        int M = Integer.parseInt(st.nextToken());//rebra
        
        List[] versh = new List[N];
        for(int i=0;i<N;i++){
            versh[i] = new ArrayList<Integer>();
            versh[i].add(0);
        }
                
        String s;
        int a = 0;
        int b = 0;
            while(br.ready()){
                    s = br.readLine();
                    st = new StringTokenizer(s," ");
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    
                    versh[a-1].add(b);
                    versh[b-1].add(a);
                    
                    versh[a-1].set(0, (int)versh[a-1].get(0) + 1);
                    versh[b-1].set(0, (int)versh[b-1].get(0) + 1);
                }
            
            for(int i=0;i<N;i++){
                for(Object zna : versh[i]){
                   bw.write(zna + " "); 
                }
                bw.newLine();
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
