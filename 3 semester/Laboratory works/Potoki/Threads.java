package lab11_final;

import java.util.Comparator;
import java.util.*;


class Comp1 implements Comparator<Integer>{
    public int compare(Integer P1, Integer P2){
        return (P1-P2);
    }
}
class Comp2 implements Comparator<Integer>{
    public int compare(Integer P1, Integer P2){
        return -(P1-P2);
    }
}

class MainThread extends Thread{
    public int comp;
    ArrayList<Integer> list;
    @Override
    public void run(){
        System.out.println("Begin - "+Thread.currentThread().getName());
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        int num = in.nextInt();
        list = new ArrayList<Integer>(num);
        for(int i=1;i<=num;i++)
            list.add(i);
        for(Integer i : list){
            System.out.println(i + " ");
        }
        System.out.print("Input 1 for norm comp, 2 for reverse comp: ");
        comp = in.nextInt();
        SortThread S = new SortThread(comp, list);
        Thread sort = new Thread(S,"Sort"); //sort
        try{
            sort.start();
            sort.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        for(Integer i : S.list){
            System.out.println(i + " ");
        }
        System.out.println("End - "+Thread.currentThread().getName());
    }
}
class SortThread extends Thread{
    public int comp;
    ArrayList<Integer> list;
    SortThread(int comp1, ArrayList<Integer> list1){
        this.comp = comp1;
        this.list = list1;
    }
    @Override
    public void run(){
        System.out.println("Begin - "+Thread.currentThread().getName());
        Comp1 c1 = new Comp1();
        Comp2 c2 = new Comp2();
        System.out.println("Sort is "+ comp);
        if(comp==1){
            list.sort(c1);
        }
        if(comp==2){
            list.sort(c2);
        }
        
        System.out.println("End - "+Thread.currentThread().getName());
    }
  
}
