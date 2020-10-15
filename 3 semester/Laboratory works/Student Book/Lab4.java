package lab4;

import java.io.*;
import java.io.IOException;

public class Lab4 {

  
    public static void main(String[] args) {
       
        Subject subj = new Subject();
        Teacher tea = new Teacher();
        Gradebook gb = new Gradebook();
        
        int numsess=2;
        Session[] ses = new Session[numsess];
        for(int i=0;i<numsess;i++){
            ses[i]=new Session(i+1);
        }

        try{
            Subject[] S = subj.input("insubject.txt");          
            Teacher[] T = tea.input("inteacher.txt");
            Gradebook[] G = gb.input("instud.txt"); 
            for(int i=0;i<numsess;i++){
                ses[i].create(S, T);
            }
            int year=2015;
            for(int i=0;i<numsess;i+=2){
                ses[i].giveYear(year);
                ses[i+1].giveYear(year);
                year++;
            }
            //System.out.println(G.length);
            for(int i=0;i<G.length;i++){
                G[i].createSess(ses);
                //G[i].outFunc();
            }
            DataBase base = new DataBase(G);
            base.outFunc();
            Gradebook stud = base.findStud();
            stud.outFunc();
        }
        catch(IOException e){
           System.out.println("Ошибка!");
        }
    }   
}
