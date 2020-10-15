package main;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Task1 {
    Set<String> set = new TreeSet<String>();

    public void method() throws IOException {
        Scanner sc = new Scanner(new File("in.txt"));
        FileWriter writer = new FileWriter("out1.txt");
        writer.write("(Task 1) ");
        writer.append("\n");

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.charAt(0) == 'R') {
                StringTokenizer st = new StringTokenizer(str, " ");
                String str2 = st.nextToken();
                String str3 = st.nextToken();
               set.add(str3);
            }
        }
        //System.out.print(set);
       // System.out.println();
        for(String s:set){
            writer.write(s);
            writer.append(" ");
        }
        writer.close();
    }
}
