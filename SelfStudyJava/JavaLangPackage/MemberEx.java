package JavaLangPackage;

public class MemberEx {
    
    public static void main(String[] args) {
        
        Member obj1 = new Member("blue");
        Member obj2 = new Member("blue");
        Member obj3 = new Member("red");

        if(obj1.equals(obj2)){
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }

        if(obj1.equals(obj3)){
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }

    }
}
