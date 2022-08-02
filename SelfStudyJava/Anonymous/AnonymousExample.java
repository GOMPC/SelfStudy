package Anonymous;

public class AnonymousExample {
    public static void main(String[] args) {
        Anonymous anony = new Anonymous(); // 익명씨 필드에 등장

        anony.field.wake(); // 익명 객체 로컬 변수 사용

        anony.method1(); // 익명 객체 매개값 사용

        anony.method2(
            new Person(){ // 매개값으로 익명 객체 대입
                void study(){
                    System.out.println("공부합니다");
                }
                @Override
                void wake(){
                    System.out.println("8시에 일어납니다");
                    study();
                }
            }
        );
    }
}
