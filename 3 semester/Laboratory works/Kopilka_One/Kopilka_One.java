package kopilka_one;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Kopilka_One {
    

    
    public int FF;//копилка с монетами
    public int E;//копилка пустая
    public int n;//кол-во видов монет
    public int[]price;//цена монет
    public int[]weight;//вес монет
    private int M;//FF-E
    private int[]F;//значения целевой фун-ии
    int minW;//минимальный вес
    
    public void getVar(String filename){
        try{
       
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int tempMinWeight = 20000;
        int tempPrice = 0;
        
       String a;
       a = br.readLine();
       StringTokenizer st = new StringTokenizer(a," ");
       E=Integer.parseInt(st.nextToken());
       FF=Integer.parseInt(st.nextToken());
       M = FF-E;
       if(M>=0){
       a = br.readLine();
       n = Integer.parseInt(a);
       
       price = new int[n];
       weight = new int[n];
       
       for(int i=0;i<n;i++){
            a = br.readLine();
            StringTokenizer st1 = new StringTokenizer(a," ");
            price[i]=Integer.parseInt(st1.nextToken());
            weight[i]=Integer.parseInt(st1.nextToken());
            //min
            if(tempMinWeight>weight[i]){
                
                tempMinWeight=weight[i];
                tempPrice = price[i];
            }
       }
       minW = tempMinWeight;
       
      
       F = new int[M+1];
       for(int i=0;i<M+1;i++){
           F[i]=-1;
       }
       F[0]=0;
       if(M>=minW){
       F[minW]=tempPrice;
       }
       }
    }
        catch (IOException e){
       System.out.println("Error read!");
        }
    }
    //Приём исходных данных FF,E,n.Выделяет память под price 
    //и weight(размерности n).Находит minW и nweight.Выделяет память
    //под F(размерности M+1),инициализирует все "-1", а потом 
    //F[0]=0; F[minW]=price[nweight].
    
    public int minSummPrice(){
        
        for(int x=minW+1;x<=M;x++){
            int MIN = 50000*M/minW;
            int MAXINT = 2000000000;
            for(int i=0;i<n;i++){
            if((x>=weight[i])&&(F[x-weight[i]]!=-1)){
                if(MIN>F[x-weight[i]]+price[i]){
                    MIN=F[x-weight[i]]+price[i];
                }
            }
        }
            if(MIN==MAXINT){
                F[x]=-1;
            }
            else{
                F[x]=MIN;
            }
        }
        return F[M];
    }
    
    public int maxSummPrice(){
        
        for(int x=minW+1;x<=M;x++){
            int MAX = 0;
            int MAXINT = 0;
            for(int i=0;i<n;i++){
            if((x>=weight[i])&&(F[x-weight[i]]!=-1)){
                if(MAX<F[x-weight[i]]+price[i]){
                    MAX=F[x-weight[i]]+price[i];
                }
            }
        }
            if(MAX==MAXINT){
                F[x]=-1;
            }
            else{
                F[x]=MAX;
            }
        }
        return F[M];
    }

    

    
    public static void main(String[] args) {
     Kopilka_One K  = new Kopilka_One();
        K.getVar("input.txt");
        if(K.FF>=K.E){
        int res = K.minSummPrice();
       
        
        int res1 = K.maxSummPrice();
        
         
         if(res1==-1){
             System.out.println("This is impossible.");
         }
         else 
             System.out.println(res + " "+ res1);
        
    }
        
    }
    
}
