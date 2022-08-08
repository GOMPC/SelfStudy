package Week3;

public class SportCar extends Car {

    SportCar(){
        this.speed = 250;
        this.perLiter = 8;
        this.oiltank = 30;
        this.maxMember = 2;
        this.name = "SportCar";
    }
    SportCar(String name){
        this.speed = 250;
        this.perLiter = 8;
        this.oiltank = 30;
        this.maxMember = 2;
        this.name = name;
    }
    
    @Override
    void option() {
        speed = 300;
    }
}
