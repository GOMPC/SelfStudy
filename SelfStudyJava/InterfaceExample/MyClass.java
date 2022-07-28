package InterfaceExample;

public class MyClass {
    
    RemoteControl rc = new Television(); // 필드부터 그냥 인터페이스 변수 박아버려

    MyClass(){}
    MyClass(RemoteControl rc){ // 생성자의 파라미터로 구현 객체를 넣을 수 있다. new Television(); 이나 new Audio(); 이런거?
        this.rc = rc;
    }

    void methodA(){
        RemoteControl rc = new Audio(); // 메소드의 로컬 변수로도 인터페이스 변수가 올 수 있다.
        rc.turnOn();
        rc.setVolume(5);
    }

    void methodB(RemoteControl rc){ // 생성자 파라미터랑 똑같이 ㅇㅇ
        rc.turnOn();
        rc.setVolume(7);
    }
}
