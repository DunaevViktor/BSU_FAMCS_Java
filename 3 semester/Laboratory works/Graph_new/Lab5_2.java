package lab5_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.IOException;
import java.io.FileReader;
import java.io.*;
import java.util.*;

public class Lab5_2 {

   
    public static void main(String[] args) throws IOException {


        Graph g = new Graph();
        g.InputGraph();
        g.PrintGraph();
       /* BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String MyString1;
        String MyString2;
        System.out.println("Input City 1 and City 2: ");
        MyString1 = in.readLine();
        MyString2 = in.readLine();
        g.searchMinimalPath(MyString1,MyString2); */
        
        g.searchMinimalPath("Гродно", "Могилев");

        //200 -> 2000 
    }
    
}
