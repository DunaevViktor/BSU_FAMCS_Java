package aisd_gonka_24;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AISD_Gonka_24 {

    //обход вершин
    private static void dfs(int v, int[][] smeznost, boolean[] used) {
        used[v] = true;
        for (int i = 0; i < smeznost.length; i++) {
            if (smeznost[v][i] == 1 && !used[i]) {
                dfs(i, smeznost, used);
            }
        }
    }

    public static void main(String[] args)throws Exception {
        
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String inf = br.readLine();
        StringTokenizer st = new StringTokenizer(inf," ");
        int N = Integer.parseInt(st.nextToken());//вершины
        
        ArrayList<Integer> massN = new ArrayList<>();//неизбежные
        ArrayList<Integer> massR = new ArrayList<>();//разбиение
        int[][] smeznost = new int[N][N];//матрица смежноси
        boolean[] used = new boolean[N];//массив посещений
        
        int[] smeznSAVE = new int[N];
        int[] smeznNULL = new int[N];
        for (int j = 0; j < N; j++) {
            smeznNULL[j] = 0;
        }
      
        //формируем матрицу смежности
        int i = 0;
        while (br.ready()) { 
            String s = br.readLine();
            String[] str = s.split(" ");
            for (int j = 0; j < str.length - 1; j++) {
                int val = Integer.valueOf(str[j]);
                smeznost[i][val] = 1;
            }
            i++;
        }
      
        //выполняем для всех вершин кроме старта и финиша
        for (int j = 1; j < N - 1; j++) {
            
            boolean flag = true;
            smeznSAVE = smeznost[j];
            smeznost[j] = smeznNULL;
            
            for (int p = 0; p < used.length; p++) {
                    used[p] = false;
            }
            dfs(0, smeznost, used);
            
            smeznost[j] = smeznSAVE;
            
            if (!used[N - 1]) { //если финиш не посещен
                massN.add(j);   
                for (int k = 0; k < N; k++) {
                    if (!used[k] || k == j) {
                        for (int l = 0; l < N; l++) {
                            if (used[l]) {
                                if (smeznost[k][l] == 1 && l != j) {
                                    flag = false;
                                }
                            }
                        }
                    }
                }
                if (flag) {
                    massR.add(j);
                }
            }     
        }
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        bw.write(massN.size() + "");
        for (int j = 0; j < massN.size(); j++) {
            bw.write(" " + massN.get(j));
        }
        bw.newLine();
        bw.write(massR.size() + "");
        for (int j = 0; j < massR.size(); j++) {
            bw.write(" " + massR.get(j));
        }
        bw.close();
             
    }    
}
