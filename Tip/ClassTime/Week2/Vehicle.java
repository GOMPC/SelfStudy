package Week2;

public class Vehicle {
    public void run(){
        System.out.println("차량이 달립니다");
    }
}

class Bus extends Vehicle{
    @Override
    public void run() {
        super.run();
        System.out.println("버스 응애~");
    }
}

class Taxi extends Vehicle{
    @Override
    public void run() {
        super.run();
        System.out.println("택시 응애~");
    }
}

class SportCar extends Vehicle{
    @Override
    public void run() {
        super.run();
        System.out.println("다 비켜 응애애애~~~~");
    }
}
