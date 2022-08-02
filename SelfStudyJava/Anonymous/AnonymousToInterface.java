package Anonymous;

public class AnonymousToInterface {
    RemoteControl field = new RemoteControl() {

        @Override
        public void turnOn() {
            System.out.println("Turn it up!");
        }

        @Override
        public void turnOff() {
            System.out.println("Calm down~");
        }
        
    };

    void method01(){
        RemoteControl localVar = new RemoteControl() {

            @Override
            public void turnOn() {
                System.out.println("Audio On");
            }

            @Override
            public void turnOff() {
                System.out.println("Audio Off");
            }
            
        };
        localVar.turnOn();
    }

    void method02(RemoteControl rc){
        rc.turnOn();
    }
}
