package kopilka_main;

public class Kopilka_Main {
    
    
    
    public static void main(String[] args) {
  
       
        
        Kopilka K = new Kopilka();
        K.getVar("input.txt");
        if(K.FF>=K.E){
        int res = K.minSummPrice();
       
        
        int res1 = K.maxSummPrice();
        
         
         if(res==-1){
             System.out.println("This is impossible!"  + " ");
         }
         else 
             System.out.println(res + " ");
        if(res1==-1){
             System.out.println("This is impossible!"  + " ");
         }
        else 
            System.out.println(res1 + " ");
    }
        else {
             System.out.println("This is impossible!"  + " ");
        }
    }
    
}
