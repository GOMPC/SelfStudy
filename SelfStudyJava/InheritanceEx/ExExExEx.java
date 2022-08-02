package InheritanceEx;

public class ExExExEx {
    
    public static void main(String[] args) {
        
        Phone myphone = new MyPhone("S20", "Navy", 2);
        MyPhone yourPhone = new MyPhone("Flip", "black", 1);

        myphone.ring();
        // System.out.println(myphone.age); 신기하네 이거~ 메소드 오버라이딩은 잘해놓고 필드값은 날려먹었네 이거
        System.out.println("응애애애 나 " + yourPhone.age + "살 애기 응애");

    }
}
