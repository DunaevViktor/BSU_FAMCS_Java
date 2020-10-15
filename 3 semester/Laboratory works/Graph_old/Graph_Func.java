package graph;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Graph_Func {
    
    private TreeMap<String,Integer> citiesList;
    private TreeMap<Integer,String> citiesListByCode;
    private int citiesQuautity;
    int INF = 10000000;
    MinRast m = new MinRast();
    
    Graph_Func(){
        citiesList = new TreeMap<>();
        citiesListByCode = new TreeMap<>();
    }
    public class Connection{
        
        public int vertice;
        public int distance;
            Connection(int inVertice, int inDistance){
                vertice = inVertice;
                distance = inDistance;
            }
    }
    
    private ArrayList<ArrayList<Connection>>graph;
    private ArrayList<Connection> tempList;
    
        public void InputGraph(String filename) throws IOException {
            
                FileReader filereader = new FileReader(filename);
                BufferedReader br = new BufferedReader(filereader);
                String temp = br.readLine();
                int n=0;
                
                int index;
                StringTokenizer tk = new StringTokenizer(temp," |;");
                
              while(tk.hasMoreTokens()){
                    String temp2 = tk.nextToken();
                   
                    index=n;
                    citiesList.put(temp2,index);
                    citiesListByCode.put(index,temp2);
                  
                    n++; //2
                
                }       
                
                 tempList = new ArrayList<Connection>();
                 graph = new  ArrayList<ArrayList<Connection>>();
                 citiesQuautity = n; 
                 
                 
                for(int i=0;i<n;i++){ 
                    temp = br.readLine();
                    StringTokenizer tk2 = new StringTokenizer(temp," ");
                    ////////??????
                    for(int j=0;j<n;j++){
                        String s = tk2.nextToken();
                        int tempDistance = Integer.parseInt(s);
                        
                       if(tempDistance!=0){
                            tempList.add(new Connection(i,tempDistance));//j
                        }
                  }               
                    graph.add(tempList);
                } 
}
public void PrintGraph(){
        for(int i = 0;i<citiesQuautity;i++){
            System.out.println(citiesListByCode.get(new Integer(i)));
            System.out.println("Connected to: ");

              for(int j=0;j<graph.get(i).size();j++){ 
                    Connection temp = graph.get(i).get(j);
                  if(temp.distance!=0)
                    System.out.println("(" + citiesListByCode.get(new Integer(temp.vertice))
                    + "," + temp.distance + ")");
                }
            }
        }  

public class MinRast {
    
    public void searchMinimalPath(String str, String str2) {
        
        int[] array = new int[citiesQuautity];
        int[] p = new int[citiesQuautity];
        boolean[] u = new boolean[citiesQuautity];
        
        for (int i = 0; i < citiesQuautity; i++) {
            array[i] = INF;
        }
        
        int s = citiesList.get(str);
        array[s] = 0;
        for (int i = 0; i < citiesQuautity; ++i) {
            int v = -1;
            for (int j = 0; j < citiesQuautity; ++j)
                if (!u[j] && (v == -1 || array[j] < array[v]))
                    v = j;
            if (array[v] == INF)
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
            if (citiesListByCode.get(new Integer(j)).compareTo(str2) == 0) {
                System.out.println("The shortest way from " + str + " to " + str2 
                        + " is " + " - " + array[j]);
                for (int v = j; v != s; v = p[v])
                    path.add(v);
                path.addElement(s);
                Collections.reverse(path);
            }
           
        }   
    }
}




}
