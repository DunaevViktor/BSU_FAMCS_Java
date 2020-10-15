package contrwork;

import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class ContrWork {
    public static void main(String[] args) {
        InputFile IF = new InputFile("in.txt");
        String[] s;
        int count;
        count = IF.intTake();
        s = new String[count];
        StringTokenizer st,stg;
        for(int i=0;i<count;i++){
            int glascount=0; //kol glas
            String glasstr=null; //max glas word
            String a=IF.stringTake();
            st= new StringTokenizer(a," ,.;");
            while(st.hasMoreTokens()){
                String d = st.nextToken();
                stg = new StringTokenizer(d,"QWRTPSDFGHJKLZXCVBNMqwrtpsdfghjklzxcvbnm");
                if(d.length()>glascount){  //меняем на сравнение по длинне
                    glascount=d.length();
                    glasstr=d;
                }
            }
            System.out.println(glasstr);
            
           
        }
    }
    
}
