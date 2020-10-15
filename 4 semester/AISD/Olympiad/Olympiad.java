package olympiad;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Olympiad {

    static int n; //количество вершин в орграфе
    int m; //количество дуг в орграфе
    private ArrayList<Integer> adj[]; //список смежности
    private boolean used[]; //массив для хранения информации о пройденных и не пройденных вершинах
    private Queue<Integer> queue; //очередь для добавления вершин при обходе в ширину
   
    // private BufferedReader cin;
    // private PrintWriter cout;
    //private StringTokenizer tokenizer;
    
    //процедура обхода в ширину
    private void bfs(int v) {
        System.out.println("bfs working");
        if (used[v]) { //если вершина является пройденной, то не производим из нее вызов процедуры
            return;
        }
        queue.add(v); //начинаем обход из вершины v
        used[v] = true; //помечаем вершину как пройденную
        while (!queue.isEmpty()) {
            v = queue.poll(); //извлекаем вершину из очереди
            //cout.print((v + 1) + " ");
            //System.out.print((v + 1) + " ");
            //запускаем обход из всех вершин, смежных с вершиной v
            for (int i = 0; i < adj[v].size(); ++i) {
                int w = adj[v].get(i);
                //если вершина уже была посещена, то пропускаем ее
                if (used[w]) {
                    continue;
                }
                queue.add(w); //добавляем вершину в очередь обхода
                used[w] = true; //помечаем вершину как пройденную
            }
        }
    } 
    
    //процедура считывания входных данных с консоли
    private void readData() throws IOException {
        System.out.println("read working");
        //cin = new BufferedReader(new InputStreamReader(System.in));
        //cout = new PrintWriter(System.out);
        //tokenizer = new StringTokenizer(cin.readLine());
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String inf = br.readLine();
        StringTokenizer st = new StringTokenizer(inf," ");
        int n = Integer.parseInt(st.nextToken());//vershini
        
        //n = Integer.parseInt(tokenizer.nextToken()); //считываем количество вершин графа
        //m = Integer.parseInt(tokenizer.nextToken()); //считываем количество ребер графа
       
        //инициализируем список смежности графа размерности n
        adj = new ArrayList[n+1];
        for (int i = 1; i < n+1; ++i) {
            adj[i] = new ArrayList<Integer>();
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
        int lol = 0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
               // System.out.print(str[i][j] + " ");
                if(str[i][j]==1){
                    lol++;
                }
            }
          //  System.out.println();
        }
        //System.out.println(lol + " ");
        m = lol/2;
       
        //считываем граф, заданный списком ребер
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(str[i][j]==1){
                adj[i].add(j);
                }
            }
        } 
     /*   for (int i = 0; i < m; ++i) {
            tokenizer = new StringTokenizer(cin.readLine());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            v--;
            w--;
            adj[v].add(w);
            adj[w].add(v);
        } */
       
        used = new boolean[n];
        Arrays.fill(used, false);
       
        queue = new LinkedList<Integer>();
    }
    
    private void run() throws IOException {
        System.out.println("working run DO");
   
        int v=1;
        bfs(v);
       /* for (int v = 1; v < n+1; v++) {
            System.out.println("working run in FOR");
            bfs(v);
        } */
       System.out.println("working run after FOR");
       // cin.close();
        //cout.close();
    } 
    
    
    
    public static void main(String[] args)throws IOException {
        Olympiad solution = new Olympiad();
        System.out.println("main start");
        //solution.run();
        solution.readData();
        solution.run();
    }
    
}
