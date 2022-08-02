package AnonymousExample;

public class AnonymousForInterface {
    Vehicle field = new Vehicle() {

        @Override
        public void run() {
            System.out.println("Bike");
        }
        
    };

    void method1(){
        Vehicle localVar = new Vehicle() {

            @Override
            public void run() {
                System.out.println("Car");
                
            }
            
        };
        localVar.run();
    }

    void method2(Vehicle v){
        v.run();
    }
}
