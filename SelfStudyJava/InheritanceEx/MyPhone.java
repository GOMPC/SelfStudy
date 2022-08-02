package InheritanceEx;

public class MyPhone extends Phone {
    int age;

    MyPhone(String model, String color, int age){
        this.model = model;
        this.color = color;
        this.age = age;
    }

    @Override // 이걸 표시해주는게 개발하는 너의 입장에서도 편안할거다. rimg로 잘못 쳣다가 왜 안되지? 이런 일 없으려면 ^^
    void ring() {
        System.out.println("애응");
    }

}
