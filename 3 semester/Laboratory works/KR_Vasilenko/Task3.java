package main;



import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Task3 {
    LinkedList<String> list;
    FileWriter writer = new FileWriter("out3.txt");

    public Task3() throws IOException {
    }


    public void method() throws IOException {
        list = new LinkedList<String>();
        Scanner sc = new Scanner(new File("in.txt"));
        writer.write("(Task 3) ");
        writer.append("\n");
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if(str.charAt(0)=='R'){
                StringTokenizer st = new StringTokenizer(str," ");
                String str2 = st.nextToken();
                String str3 = st.nextToken();
                goRun(str3);
            }
            else {
                StringTokenizer st = new StringTokenizer(str, " +");
                goAlt(st.countTokens()-1);
            }
        }
        writer.close();

    }

    public void goRun(String str) throws IOException {
        list.addFirst(str);
        writer.write(str);
        writer.append(" ");
    }

    public void goAlt(int tabs) throws IOException {
        if(tabs>=list.size()){
            tabs = tabs%list.size();
        }
        list.addFirst(list.get(tabs));
        list.remove(tabs+1);
        writer.write(list.get(0));
        writer.append(" ");
    }


}
