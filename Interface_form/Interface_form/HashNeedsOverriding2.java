package Interface_form;

public class HashNeedsOverriding2 {
    
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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Custom && obj != null){
            if(obj == this){
                return true;
            }
            Custom other = (Custom) obj;

            if(str == null){
                if(other.str == null){
                    return other.val == val;
                }
                return false;
            }
            if(other.str.equals(str) && other.val == val){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        
        final int prime = 31; // 소수로 하는게 좋대. 왜?

        int result = 17;

        result = prime * result * val;
        result = prime * result * (str != null ? str.hashCode() : 0);
        return result;
    }
}