package lab11_final;


public class Lab11_final {

    
    public static void main(String[] args) {
  
        Thread go = new Thread(new MainThread(),"Main");
        go.start();
        //Thread t12 = new Thread(new CThread(),"t12");
    }
    
}
