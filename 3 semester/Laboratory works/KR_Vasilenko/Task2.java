package main;

//import sun.plugin.javascript.navig.Array;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    List<String> array = new ArrayList<String>();
    MyComparato comp = new MyComparato();

    public void method() throws IOException {
        Scanner sc = new Scanner(new File("in.txt"));
        FileWriter writer = new FileWriter("out2.txt");
        writer.write("(Task 2) ");
        writer.append("\n");
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if(str.charAt(0)=='A'){
                array.add(str);
            }
        }
        Collections.sort(array,comp);
        for(String s:array){
            writer.write(s + " ");
            writer.append("\n");
        }
        writer.close();
    }
}
