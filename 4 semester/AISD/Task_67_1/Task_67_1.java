package task_67_1;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Task_67_1 {

    private static int n;
    private ArrayList<Integer> smeznost[];
    private boolean used[];
    private Queue<Integer> queue;
    private static int[] metki;
    int met = 1;
     
    //процедура обхода в ширину
    private int bfs(int v) {
        int count = 0;
        
        if (used[v]) {
            return 0;
        }
        
        queue.add(v);
        used[v] = true;
        
        while (!queue.isEmpty()) {
            v = queue.poll(); //извлекаем вершину из очереди
            metki[v] = met;
            met++;
            count++;
            //запускаем обход из всех вершин, смежных с вершиной v
            for (int i = 0; i < smeznost[v].size(); ++i) {
                int w = smeznost[v].get(i);
                //если вершина уже была посещена, то пропускаем ее
                if (used[w]) {
                    continue;
                }
                queue.add(w); //добавляем вершину в очередь обхода
                used[w] = true; //помечаем вершину как пройденную
            }
        }
        return count;    
    }
   
    private int readInfo() throws IOException {
       
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String inf = br.readLine();
        StringTokenizer st = new StringTokenizer(inf," ");
        int n = Integer.parseInt(st.nextToken());//вершины
        
        //инициализируем список смежности графа размерности n
        smeznost = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            smeznost[i] = new ArrayList<Integer>();
        }
        
        String s;
        int[][] str = new int[n+1][n+1];
        
        while(br.ready()){
            for(int i=1;i<n+1;i++){
                    s = br.readLine();
                    st = new StringTokenizer(s," ");
                    for(int j=1;j<n+1;j++){
                        str[i][j] = Integer.parseInt(st.nextToken());
                    }        
            }                    
        }
       
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(str[i][j]==1){
                   int v = i;
                   int w = j;
                   v--;
                   w--;
                   smeznost[v].add(w);
                   smeznost[w].add(v);
                }
            }
        }
           
        used = new boolean[n];
        Arrays.fill(used, false);
       
        queue = new LinkedList<Integer>();
        
        return n;
    }
   
    private void run() throws IOException {
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        int n  = readInfo();
        metki = new int[n];
        for(int i=0;i<n;i++){
            metki[i] = 0;
        }
        int v = 0;
        
        int count = bfs(v);
        
        for(int i=0;i<n;i++){
            bw.write(metki[i] + " ");
        }
        bw.close();   
    }
    
    public static void main(String[] args)throws IOException {
        Task_67_1 otvet = new Task_67_1();   
        otvet.run();
    }
    
}
