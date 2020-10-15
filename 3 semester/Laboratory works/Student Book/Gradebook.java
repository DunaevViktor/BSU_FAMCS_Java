
package lab4;

import java.io.IOException;
import java.util.StringTokenizer;

public class Gradebook {
    String studName;
    int helloYear;
    int group;
    int gbNumber;
    Session[] sessMass;
    
    Gradebook(){
        studName="";
        helloYear = 0;
        group = 0;
        gbNumber = 0;
    }
    Gradebook(String name, int year, int group1, int num){
        studName = name;
        helloYear = year;
        group = group1;
        gbNumber = num;
    }
    
    Gradebook[] input(String file) throws IOException{
        InputFile input = new InputFile(file);
        int count = input.intTake();
        Gradebook[] res = new Gradebook[count];
        for(int i=0;i<count;i++)
           {
               res[i] = new Gradebook();
           }
        StringTokenizer st;
        for(int i=0;i<count;i++){
            String a=input.stringTake();
            st= new StringTokenizer(a," ");
            if(st.hasMoreTokens()){
                String d = st.nextToken();
                res[i].studName=(d);
            }
            if(st.hasMoreTokens()){
                res[i].helloYear=(Integer.parseInt(st.nextToken()));
            }
            if(st.hasMoreTokens()){
                res[i].group=(Integer.parseInt(st.nextToken()));
            }
            if(st.hasMoreTokens()){
                res[i].gbNumber=(Integer.parseInt(st.nextToken()));
            }
        }
        return res;
    }
    void createSess(Session[] S){
        int count=0;
        for(int y=helloYear;y<helloYear+4;y++){
            for(int i=0;i<S.length;i++){
                if (S[i].year==y)
                    count++;
            }
        }
        sessMass = new Session[count];
        count=0;
        for(int y=helloYear;y<helloYear+4;y++){
            for(int i=0;i<S.length;i++){
                if (S[i].year==y){
                    sessMass[count]=S[i];
                    count++;
                }
            }
        }
    }
    void giveMark(String subj, int sess, int mark){
        sessMass[sess-1].giveMark(subj, mark);
    }
    void outFunc(){
        System.out.println("Номер зачетки = " + gbNumber + ", Имя = " + studName 
                + ", Год зачисления = " + helloYear + ", Группа = " + group 
                + ", Удачные сессии = "+ sessMass.length + ":");
        for(int i=0;i<sessMass.length;i++){
            sessMass[i].outFunc();
            System.out.println();
        }
    }
}
