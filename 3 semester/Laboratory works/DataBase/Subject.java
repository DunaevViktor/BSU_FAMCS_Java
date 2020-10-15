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
public class Subject {
   
    String name;
    int hours;
    int type;
    int sessionNum;
    void getName(String name1)
    {
        name = name1;
    }
    public void getHours(int hours1)
    {
        hours = hours1;
    }
    public void getType(int type1)
    {
        type = type1;
    }
    public void getSessionNum(int SN1)
    {
       sessionNum = SN1;
    }
    public Subject[] getSubject(InputFile I)
    {
        StringTokenizer st;int n;    
        Subject[] S ;
        try
        {
           n = I.intTake();
           S = new Subject[n];
           for(int i=0;i<n;i++)
           {
               S[i] = new Subject();
           }
        }
        catch (IOException e)
        {
            System.out.println("Ошибка чтения5");
            S = new Subject[1];
            S[0] = new Subject();
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
                     S[i].getName(d);
                 }
                 else
                 {
                     S[i].getName(""); 
                 }
                 if(st.hasMoreTokens())
                 {
                    S[i].getHours(Integer.parseInt(st.nextToken()));
                 }
                 else
                 {
                     S[i].getHours(0);
                 }
                 if(st.hasMoreTokens())
                 {
                    S[i].getType(Integer.parseInt(st.nextToken())); 
                 }
                 else
                 {
                     S[i].type = -1;
                 }
                 if(st.hasMoreTokens())
                 {
                    S[i].getSessionNum(Integer.parseInt(st.nextToken())); 
                 }
                 else
                 {
                     S[i].getSessionNum(-1);
                 }
             }              
       return S;
    }
    public void outFunc ()
    {
        System.out.println("name = " + name + ", hours =  " + hours + ", sessionNum =  " + sessionNum + ", type = " + type);
    }
}
