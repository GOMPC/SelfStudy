package Week3;

public class Bus extends Car {

    Bus(){
        this.speed = 150;
        this.perLiter = 5;
        this.oiltank = 100;
        this.maxMember = 20;
        this.name = "Bus";
    }
    Bus(String name){
        this.speed = 150;
        this.perLiter = 5;
        this.oiltank = 100;
        this.maxMember = 20;
        this.name = name;
    }

    @Override
    void option() {
        oiltank = oiltank + 30;
    }
}
