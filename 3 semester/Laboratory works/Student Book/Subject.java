
package lab4;

import java.io.*;
import java.io.IOException;
import java.util.StringTokenizer;


public class Subject {
    String name;
    int hours; 
    int session;
    int zachet;
    
    Subject[] input(String file) throws IOException{
        InputFile input = new InputFile(file);
        int count = input.intTake();
        Subject[] res = new Subject[count];
        for(int i=0;i<count;i++)
           {
               res[i] = new Subject();
           }
        //System.out.println(count);
        StringTokenizer st;
        /*try{
        st = new StringTokenizer(input.stringTake()," \n");
        }
        catch (IOException e)
		{
			System.out.println("Ошибка чтения");
                        st=new StringTokenizer(""," ");
		}*/
        for(int i=0;i<count;i++){
            String a=input.stringTake();
            st= new StringTokenizer(a," ");
            if(st.hasMoreTokens()){
                //System.out.println(st.nextToken());
                String d = st.nextToken();
                res[i].name=d;
            }
            if(st.hasMoreTokens()){
                //System.out.println(st.nextToken());
                res[i].hours=(Integer.parseInt(st.nextToken()));
            }
            if(st.hasMoreTokens()){
                //System.out.println(st.nextToken());
                res[i].session=(Integer.parseInt(st.nextToken()));
            }
            if(st.hasMoreTokens()){
                //System.out.println(st.nextToken());
                res[i].zachet=(Integer.parseInt(st.nextToken()));
            }
        }
        return res;
    }
    public void outFunc ()
    {
        System.out.println("name = " + name + ", hours =  " + hours + ", sessionNum =  " + session + ", type = " + zachet);
    }
    Subject[] searchSession(Subject[]S, int session){
        int count=0;
        for(int i=0;i<S.length;i++)
        {
            if(S[i].session==session){
                count++;
            }
        }
        Subject[] res = new Subject[count];
        int j=0;
        for(int i=0;i<S.length;i++)
        {
            if(S[i].session==session){
                res[j]=S[i];
                j++;
            }
        }
        return res;
    }
}
