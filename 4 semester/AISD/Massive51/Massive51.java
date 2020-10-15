package massive51;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Random;

public class Massive51 {

    private static Random generator = new Random();

    public static void qSort(int[] array, int l, int r) {
        int i = l;
        int j = r;
        int x = array[l + generator.nextInt(r - l + 1)];
        while (i <= j) {
            while (array[i] < x) {
                i++;
            }
            while (array[j] > x) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (l<j){
            qSort(array, l, j);
        }
        if(i<r){
            qSort(array, i, r);
        }
    }
     
    public static void main(String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String inf = br.readLine();
        StringTokenizer st = new StringTokenizer(inf," ");
        int N = Integer.parseInt(st.nextToken());//количество массивов
        int M = Integer.parseInt(st.nextToken());//длинна каждого из массивов
        
        //System.out.println(N + " " + M);
        int res[] = new int [N*M];
        
        String s;
        int count = 0;
        while(br.ready()){
            for(int j = 1;j<N+1;j++){
                    s = br.readLine();
                    st = new StringTokenizer(s," ");
                    for(int i=count;i<M*j;i++){
                        res[i] = Integer.parseInt(st.nextToken());
                        //System.out.print(res[i] + " ");
                    }
                    count = count + M;
                    //System.out.println();
            } 
        }
          
      /*  for(int i=0;i<N*M;i++){
            System.out.print(res[i] + " ");
        } */
        
       // System.out.println();
        int C = (N*M)-1;    
        qSort(res,0,C);
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        int cou = 0;
        for(int i=0;i<N*M;i++){
            cou++;
            if(cou<N*M){
            bw.write(res[i] + " ");
            }
            if(cou==(N*M)){
                bw.write(res[i] + "");
            }
        } 
        
        bw.close();
    }
    
}
