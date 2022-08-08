package Interface_form;

public class HashNeedsOverriding {
    
    public static void main(String[] args) {
        
        Custom a = new Custom("aaa", 10);
        Custom b = new Custom("aaa", 10);

        HashSet<Custom> set = new HashSet<>();

        set.add(a);
        if(set.add(b)){
            System.out.println("오잉? 이게 되면 안되는데");
        } else {
            System.out.println("겹친다구!");
        }
    }
}

class Custom{
    String str;
    int val;
    
    public Custom(String str, int val){
        this.str = str;
        this.val = val;
    }
}
