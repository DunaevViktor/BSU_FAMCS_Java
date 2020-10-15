
package lab4;

import java.io.*;
import java.io.IOException;
import java.util.StringTokenizer;


public class DataBase {
    Gradebook[] base;
    BufferedReader br;
    Input in = new Input();
    DataBase(Gradebook[] g){
        base = new Gradebook[g.length];
        for(int i=0;i<g.length;i++){
            base[i] = g[i];
        }
    }
    /*void giveMark(){
        String name, subj;
        int sess, mark;
        System.out.println("Input student's name:");
        name = in.stringTake();
        System.out.println("Input subject's name:");
        subj = in.stringTake();
        System.out.println("Input sess number:");
        sess = in.intTake();
        System.out.println("Input mark:");
        mark = in.intTake();
        for(int i=0;i<base.length;i++){
            if(base[i].studName.compareTo(name)==0){
                System.out.println("Yep");
                base[i].giveMark(subj, sess, mark);
            }
        }        
    }*/
    Gradebook findStud(){
        String name;
        System.out.println("Введите имя студента ля поиска? :");
        name = in.stringTake();
        for(int i=0;i<base.length;i++){
            //System.out.println(base[i].studName);
                if(base[i].studName.compareTo(name)==0){
                    //System.out.println("Yep");
                    return base[i];
                }
        }
        return null;
    }
    void outFunc(){
        for(int i=0;i<base.length;i++){
            base[i].outFunc();
        }
    }
}
