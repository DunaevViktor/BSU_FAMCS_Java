package lab5_2;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {
    private Map<String, Integer> citiesList = new TreeMap<String, Integer>();
    private Map<Integer, String> citiesListByCode = new TreeMap<Integer, String>();
    int citiesQuantity;
    int INF = 10000000;

    public class Connection {
        int vertice;
        int distance;

        Connection(int n, int m) {
            vertice = n;
            distance = m;
        }
    }

    private ArrayList<ArrayList<Connection>> graph = new ArrayList<ArrayList<Connection>>();

    public void InputGraph() throws IOException {
        FileReader fr = new FileReader("cities.txt");
        BufferedReader br = new BufferedReader(fr);
        String temp = br.readLine();
        Integer n = 0;
        StringTokenizer st = new StringTokenizer(temp, "; \n");
        while (st.hasMoreTokens()) {
            String temp2 = st.nextToken();
            //Integer index = new Integer(n);
            citiesList.put(temp2, n);
            citiesListByCode.put(n, temp2);
            n++;
        }
        citiesQuantity = n;
        for (int i = 0; i < n; i++) {
            ArrayList<Connection> templist = new ArrayList<Connection>();
            temp = br.readLine();
            StringTokenizer tokenizer2 = new StringTokenizer(temp, ", \t");
            for (int j = 0; j < n; j++) {
                String s = tokenizer2.nextToken();
                int tempDistanse = Integer.parseInt(s);
                if (tempDistanse != 0) {
                    templist.add(new Connection(j, tempDistanse));
                }
            }
            graph.add(templist);
        }
    }

    public void PrintGraph() {
        for (int i = 0; i < citiesQuantity; i++) {
            System.out.println(citiesListByCode.get(new Integer(i)) + " " + "connected to: ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                Connection temp = graph.get(i).get(j);
                System.out.print("(" + " " + citiesListByCode.get(new Integer(temp.vertice)) + " " + temp.distance + " " + ")");
            }
            System.out.println();
        }
    }

    public void searchMinimalPath(String start, String finish){
        int[] array = new int[citiesQuantity];
        int[] p = new int[citiesQuantity];
        boolean[] u = new boolean[citiesQuantity];
        for (int i = 0; i < citiesQuantity; i++) {
            array[i] = INF;
        }
        int s = citiesList.get(start);
        array[s] = 0;

        boolean flag = false;
        for (int i = 0; i < citiesQuantity; ++i) {
            int v = -1;
            for (int j = 0; j < citiesQuantity; ++j)
                if (!u[j] && (v == -1 || array[j] < array[v]))
                    v = j;
            if (array[v] ==INF)
                break;
            u[v] = true;

            for (int j = 0; j < graph.get(v).size(); ++j) {
                Connection temp = graph.get(v).get(j);
                int len = temp.distance;
                int to = temp.vertice;
                if (array[v] + len < array[to]) {
                    array[to] = array[v] + len;
                    p[to] = v;
                }

            }
        }

            Vector<Integer> path = new Vector<Integer>();
            for (int j = 0; j < array.length; j++) {
                if (citiesListByCode.get(new Integer(j)).compareTo(finish) == 0 && array[j] != INF) {
                    System.out.println("Самое короткое расстояние от " + start + " до " + finish + " это " + " - " + array[j]);
                    for (int v = j; v != s; v = p[v])
                        path.add(v);
                    path.addElement(s);
                    Collections.reverse(path);
                    flag = true;
                }

            }
            if(flag == false){
                System.out.println("Пути нет");
            }


            for (int i = 0; i < path.size(); i++) {
                System.out.print(citiesListByCode.get(path.get(i)) + " ");
            }


    }
}
