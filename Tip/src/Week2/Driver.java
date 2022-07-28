package Week2;
// 운전자 클래스
public class Driver {
    String name;

    public Driver(String name){
        this.name = name;
    }

    void drive(Vehicle vehicle){
        System.out.print(name + "의 ");
        vehicle.run();
    }
    
    public static void main(String[] args) {
        Driver gompc = new Driver("GOMPC");
        Bus bus441 = new Bus();
        Taxi kakao = new Taxi();
        SportCar wanted = new SportCar();

        gompc.drive(wanted);
    }

    // 애응~
}
