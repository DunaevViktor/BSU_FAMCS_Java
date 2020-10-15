
package lab4;

import java.io.*;
import java.io.IOException;
import java.util.StringTokenizer;

public class Teacher {
    String name;
    String subj;
    int group;
    int session;
    int zachet;
    Teacher(){
        name="нетимени";
        subj="нетпредмета";
        group=0;
        session=0;
        zachet=0;
    }
    Teacher[] input(String file) throws IOException{
        InputFile input = new InputFile(file);
        int count = input.intTake();
        Teacher[] res = new Teacher[count];
        for(int i=0;i<count;i++)
           {
               res[i] = new Teacher();
           }
        StringTokenizer st;
        /*try{
        st = new StringTokenizer(input.stringTake()," ");
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
                String d = st.nextToken();
                res[i].name=(d);
            }
            if(st.hasMoreTokens()){
                String d = st.nextToken();
                res[i].subj=(d);
            }
            if(st.hasMoreTokens()){
                res[i].group=(Integer.parseInt(st.nextToken()));
            }
            if(st.hasMoreTokens()){
                res[i].session=(Integer.parseInt(st.nextToken()));
            }
            if(st.hasMoreTokens()){
                res[i].zachet=(Integer.parseInt(st.nextToken()));
            }
        }
        return res;
    }
    public void outFunc ()
    {
        System.out.println("Имя = " + name + ", Предмет =  " + subj + ", Количество сессий =  " + session + ", Тип = " + zachet + ", Группа = "+ group);
    }
    Teacher searchName(Teacher[]T, String name1)
    { 
        Teacher res;
        for(int i=0;i<T.length;i++)
        {
            if(T[i].name==name1){
                res=T[i];
                return res;
            }
        }
        return null;
    }
    /*Teacher search(Teacher[]T, String subj1, int group1, int session1){
        Teacher res;
        for(int i=0;i<T.length;i++)
        {
            if((T[i].subj.compareTo(subj1)==0) && (T[i].group==group1) && (T[i].session==session1)){
                res=T[i];
                return res;
            }
        }
        return null;
    }*/
    Teacher search(Teacher[]T, String subj1, int session1){
        Teacher res;
        for(int i=0;i<T.length;i++)
        {
            if((T[i].subj.compareTo(subj1)==0) && (T[i].session==session1)){
                res=T[i];
                return res;
            }
        }
        return null;
    }
}
