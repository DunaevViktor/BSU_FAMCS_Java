package graph;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Graph {

   
    public static void main(String[] args)throws IOException {
        
       Graph_Func g = new Graph_Func();
       g.InputGraph("In.txt");
       g.PrintGraph();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String MyString1;
        String MyString2;
        System.out.println("Input City 1 and City 2: ");
        MyString1 = in.readLine();
        MyString2 = in.readLine();
       
       
       g.m.searchMinimalPath(MyString1,MyString2);
    }
    
}
