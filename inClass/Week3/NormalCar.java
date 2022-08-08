package Week3;

public class NormalCar extends Car {

    NormalCar(){
        this.speed = 200;
        this.perLiter = 12;
        this.oiltank = 45;
        this.maxMember = 4;
        this.name = "NormalCar";
    }
    NormalCar(String name){
        this.speed = 200;
        this.perLiter = 12;
        this.oiltank = 45;
        this.maxMember = 4;
        this.name = name;
    }

    @Override
    void option() {
        maxMember++;
    }

}
