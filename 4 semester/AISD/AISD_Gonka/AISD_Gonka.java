package aisd_gonka;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AISD_Gonka {
    
        public static ArrayList<Integer> smeznost[];
        public static boolean used[];
        public static Queue<Integer> queue;
        
        public int bfs(int v) {
        
        if (used[v]) {
            return 0;
        }
        
        queue.add(v);
        used[v] = true;
        
        while (!queue.isEmpty()) {
            v = queue.poll(); //извлекаем вершину из очереди
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
        return 0;
    }
    
    public static void main(String[] args)throws IOException  {
         
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String inf = br.readLine();
        StringTokenizer st = new StringTokenizer(inf," ");
        int n = Integer.parseInt(st.nextToken());//вершины
        
        ArrayList<Integer> massA = new ArrayList();
        ArrayList<Integer> massB = new ArrayList();
         
        //инициализируем список смежности графа размерности n
        smeznost = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            smeznost[i] = new ArrayList<Integer>();
        }
        
       
        int zn;  
        String s;
        for(int i=0;i<n;i++){
            s = br.readLine();
            st = new StringTokenizer(s," ");
               while(st.hasMoreTokens()){
               zn = Integer.parseInt(st.nextToken());
              if(zn != -2){
              smeznost[i].add(zn);
              }
            }
        } 
      
        used = new boolean[n];
        Arrays.fill(used, false);
       
        queue = new LinkedList<Integer>();
  ///////////////////////////////////////////////////////////////////////     
        
        
        
        
    int v = 0;  
    AISD_Gonka g = new AISD_Gonka();
for(int j=1;j<n-1;j++){
        
    smeznost[j] = null;
    g.bfs(v);
       for(int i=0;i<n;i++){
           if(used[i]==true){
               massA.add(i);
           }
           else{
               massB.add(i);
           }
       }
       
       int f = n-1;
       for(int i=0;i<massB.size();i++){
                if(f == massB.get(i)){
                    System.out.println(j +" ");
                }
        }
       //System.out.print(massA + " ");
       //System.out.print(massB + " ");
       
}
        
           
    }
    
}
