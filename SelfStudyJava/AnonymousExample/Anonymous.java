package AnonymousExample;

public class Anonymous {
    Worker field = new Worker(){
        @Override
        public void start(){
            System.out.println("Design");
        }
    };

    void method1(){
        Worker localVar = new Worker(){
            @Override
            public void start() {
                System.out.println("Programming");
            }
        };
        localVar.start();
    }

    void method2(Worker worker){
        worker.start();
    }
}
