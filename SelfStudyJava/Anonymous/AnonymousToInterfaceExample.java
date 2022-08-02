package Anonymous;

public class AnonymousToInterfaceExample {
    public static void main(String[] args) {
        AnonymousToInterface anony = new AnonymousToInterface();

        anony.field.turnOn();

        anony.method01();

        anony.method02(
            new RemoteControl() {
                @Override
                public void turnOn(){
                    System.out.println("PC On");
                }
                @Override
                public void turnOff(){
                    System.out.println("Power Down");
                }
            }
        );
    }
}
