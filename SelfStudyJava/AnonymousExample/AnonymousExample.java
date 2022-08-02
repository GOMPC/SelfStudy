package AnonymousExample;

public class AnonymousExample {
    public static void main(String[] args) {
        Anonymous anony = new Anonymous();
        anony.field.start();
        anony.method1();
        anony.method2(
            new Worker(){ // 엄마 이름으로 불러라 ㅇㅇ
                @Override
                public void start(){
                    System.out.println("Testing");
                }
            }
        );
    }
}
