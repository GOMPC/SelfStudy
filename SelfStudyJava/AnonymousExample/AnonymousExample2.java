package AnonymousExample;

public class AnonymousExample2 {
    public static void main(String[] args) {
        AnonymousForInterface anony = new AnonymousForInterface();
        anony.field.run();
        anony.method1();
        anony.method2(new Vehicle() {

            @Override
            public void run() {
                System.out.println("Truck");
            }
            
        });
    }
}
