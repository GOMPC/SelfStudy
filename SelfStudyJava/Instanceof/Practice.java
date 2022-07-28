package Instanceof;

public class Practice {
    
    public static void main(String[] args) {
        
        Tv tv = new Tv();
        Control cnt = tv;
        tv.remote();
        cnt.remote();
    }
}
