package NestedParty;

public class NestedClassExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        Car.Tire tire = myCar.new Tire(); // 이런 방식이고만~ 오호~~~
        Chatting chatting = new Chatting();
        // Chatting.Chat chat2 = chatting.new Chat(); // 이건 왜안댐? >> 로컬 클래스니까요~~ 허허허허허헣헣

        tire.roll();

        Car.Engine engine = new Car.Engine();

        
    }
}
