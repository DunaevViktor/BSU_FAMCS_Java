package task_51_massive;
import java.io.*;
import java.util.StringTokenizer;

public class Task_51_Massive {

    public static class Heap{
        
        int[] h;
        int HeapSize;
        
        Heap(int N){
          h = new int[N];
          HeapSize = 0;  
        }
        
        boolean isEmpty(){
            if(HeapSize!=0){
                return false;
            }
            else{
                return true;
            }
        }
        
        void addelem(int n){
            int i, parent;
            i = HeapSize;
            h[i] = n;
            parent = (i-1)/2;
             while(parent >= 0 && i > 0)  {
                if(h[i] < h[parent]) {  //> min (max) heap
                    int temp = h[i];
                    h[i] = h[parent];
                    h[parent] = temp;
                }
                i = parent;
                parent = (i-1)/2;
            }
                HeapSize++;
        }
        
        void heapify(int i){
            int left, right;
            int temp;
            left = 2*i+1;
            right = 2*i+2;
                if(left < HeapSize) {
                    if(h[i] > h[left]) { //<
                        temp = h[i];
                        h[i] = h[left];
                        h[left] = temp;
                        heapify(left);
                    }
                }
                if(right < HeapSize) {
                    if(h[i] > h[right]) { //<
                        temp = h[i];
                        h[i] = h[right];
                        h[right] = temp;
                        heapify(right);
                    }
                }
        }
        
        int getmin(){
            int x;
                x = h[0];
                h[0] = h[HeapSize-1];
                HeapSize--;
                heapify(0);
            return(x);
        }
        
        void outHeap(){
            int i = 0;
            int k = 1;
                while(i < HeapSize) {
                    while((i < k) && (i < HeapSize)) {
                    System.out.print(h[i] + " ");
                    i++;
                }
                System.out.println();
                k = k * 2 + 1;
            }
        }
        
        void out(){
            for(int i=0; i< HeapSize; i++) {
            System.out.print(h[i] + " ");
            }
            System.out.println();
        }
        
        
    }
    
     
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String inf = br.readLine();
        StringTokenizer st = new StringTokenizer(inf," ");
        int N = Integer.parseInt(st.nextToken());//количество массивов
        int M = Integer.parseInt(st.nextToken());//длинна каждого из массивов
       
        String s;
        int[][] str = new int[N][M];
        
        while(br.ready()){
            for(int i=0;i<N;i++){
                    s = br.readLine();
                    st = new StringTokenizer(s," ");
                    for(int j=0;j<M;j++){
                        str[i][j] = Integer.parseInt(st.nextToken());
                    }        
            }                    
        }
        
        int[] profil = new int[N];
        for(int i=0;i<N;i++){
            profil[i] = str[i][0];
        }
        
        int k;
        Heap heap = new Heap(N);//+1
        for(int i=0;i<N;i++){ //+1
            k = profil[i];
            heap.addelem(k);
        }
       
        int[] last = new int[N];
        for(int i=0;i<N;i++){
            last[i]=0;
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        int cou = 0;
        //////////////////////////////////////////////////////////
        while(heap.isEmpty()!= true){
            int otv = heap.getmin();
            cou++;
            if(cou<N*M){
            bw.write(otv + " ");}
            if(cou==N*M){
                bw.write(otv + "");
            }
            
        for(int i=0;i<N;i++){ 
            if(profil[i] == otv && (last[i]+1)<M){
                profil[i] = str[i][last[i]+1];
                heap.addelem(str[i][last[i]+1]);
                last[i]++;
            }
        }
    }
        ////////////////////////////////////////////////////////////
        bw.close();    
    }
    
}
