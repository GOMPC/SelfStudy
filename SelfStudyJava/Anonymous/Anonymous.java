package Anonymous;

public class Anonymous {
    Person field = new Person(){
        void work(){
            System.out.println("출근합니다");
        }
        @Override
        void wake(){
            System.out.println("6시에 일어납니다");
            work();
        }
    }; // 필드에 쳐들어와부렸어요~ 근데 상속 안하는디 어케 됨?

    void method1(){
        Person localVar = new Person(){ // 로컬 변수에 쳐들어왔어요~
            void walk(){
                System.out.println("산책합니다");
            }
            @Override
            void wake(){
                System.out.println("7시에 일어납니다");
                walk();
            }
        };
        localVar.wake(); // 로컬 변수 사용
    }

    void method2(Person person){
        person.wake();
    }
}
