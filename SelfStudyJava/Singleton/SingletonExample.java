package Singleton;

public class SingletonExample {
    
    public static void main(String[] args) {
        
        /*
        Singleton obj1 = new Singleton();
        Singleton obj2 = new Singleton(); 왜 안되는지 알겠지?
         */

        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        System.out.println(obj1==obj2);
        
    }
}
