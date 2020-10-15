/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZachetnayaKnijka;
import java.io.*;
import java.util.StringTokenizer;
/**
 *
 * @author Лев
 */
public class TeacherClass {
    String name;
    String subjName;
    int groop;
    int type;
    int sessionNum;
    void getName(String name1)
    {
        name = name1;
    }
    void getSubjName (String SN1)
    {
        subjName = SN1;
    }
    void getGroop(int groop1)
    {
        groop = groop1;
    }
    void getType(int type1)
    {
        type = type1;
    }
    void getSessionNum(int SN1)
    {
        sessionNum = SN1;
    }
    
    public TeacherClass[] getTeacherList(InputFile I)
    {
        StringTokenizer st; int n;
        TeacherClass[] T;
        try
        {
           n = I.intTake();
           T = new TeacherClass[n];
           for(int i=0;i<n;i++)
           {
               T[i] = new TeacherClass();
           }
        }
        catch (IOException e)
        {
            System.out.println("Ошибка чтения5");
            T = new TeacherClass[1];
            T[0] = new TeacherClass();
            n=1;
        }
        
        for(int i =0;i<n;i++)
            {
                 try
                 {
                     String a = I.stringTake();
                     st = new StringTokenizer(a," ");
                 }
                 catch (IOException e)
                 {
                     System.out.println("Ошибка чтения 2");
                     st=new StringTokenizer(""," ");
                 } 
                 if(st.hasMoreTokens())
                 {
                     String d = st.nextToken();
                     T[i].getName(d);
                 }
                 else
                 {
                     T[i].getName(""); 
                 }
                 if(st.hasMoreTokens())
                 {
                     String d = st.nextToken();
                     T[i].getSubjName(d);
                 }
                 else
                 {
                     T[i].getSubjName(""); 
                 }
                 if(st.hasMoreTokens())
                 {
                    T[i].getGroop(Integer.parseInt(st.nextToken()));
                 }
                 else
                 {
                     T[i].getGroop(0);
                 }
                 if(st.hasMoreTokens())
                 {
                    T[i].getType(Integer.parseInt(st.nextToken())); 
                 }
                 else
                 {
                     T[i].type = -1;
                 }
                 if(st.hasMoreTokens())
                 {
                    T[i].getSessionNum(Integer.parseInt(st.nextToken())); 
                 }
                 else
                 {
                     T[i].getSessionNum(-1);
                 }
             }              
       return T;
    }
    public void outFunc ()
    {
        System.out.println("name = " + name + ", subjName =  " + subjName + ", sessionNum =  " + sessionNum + ", type = " + type + ", groop = "+ groop);
    }
    public String returnName(TeacherClass[] T,String subjName1, int sessionNum1, int type1, int groop1)
    {
        for(int i = 0; i<T.length;i++)
        {
            if((T[i].groop == groop1)&(T[i].sessionNum == sessionNum1)&(T[i].type == type1)&(T[i].subjName == subjName1))
            {
                return T[i].name;
            }
        }
        return "";
    }
}
