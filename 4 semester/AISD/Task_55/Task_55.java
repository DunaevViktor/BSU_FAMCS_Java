package task_55;
import java.io.*;
import java.util.StringTokenizer;

public class Task_55 {

    public static void main(String[] args) {
       try{
        
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
            
        String inf = br.readLine();
        StringTokenizer st = new StringTokenizer(inf," ");
        int N = Integer.parseInt(st.nextToken());
        int count = 0;
        while(N>0){
            if(N%2 == 1){   
                bw.write(count + "");
                bw.newLine();
            }
            count++;
            N = N/2;
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
