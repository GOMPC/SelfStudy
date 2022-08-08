package Week3;

import java.util.Scanner;

public class ClassExampleMain {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int length;
        int setCar;
        int realMember;
        int optionNum;

        System.out.println("이동할 지역을 선택하세요");
        System.out.println("1.부산 2.대전 3.강릉 4.광주");
        length = Integer.parseInt(sc.nextLine());

        switch(length){
            case 1 : length = 400;
            case 2 : length = 150;
            case 3 : length = 200;
            case 4 : length = 300;
        }

        System.out.println("이동할 승객 수를 입력하세요");
        realMember = Integer.parseInt(sc.nextLine());

        System.out.println("이동할 차량을 선택하세요");
        System.out.println("1.스포츠카 2.승용차 3.버스");
        setCar = Integer.parseInt(sc.nextLine());
        Car car = new Car();

        switch(setCar){
            case 1 : car = new SportCar();
            case 2 : car = new NormalCar();
            case 3 : car = new Bus();
        }

        System.out.println("부가기능의 ON/OFF를 선택하세요");
        System.out.println("1.ON 2.OFF");
        optionNum = Integer.parseInt(sc.nextLine());
        if(optionNum == 1) car.option();
        sc.close();

        int cycle = realMember / car.maxMember; // 한바퀴. 
        
        // 총 거리만 잘 세운다면 이 문제는 끝이다.
        int realLength;
        if(realMember%car.maxMember==0) {
            realLength = length*2*cycle - length;
        } else {
            realLength = length*2*cycle + length;
        }

        int fullTime = realLength / car.speed;
        if(realLength % car.speed != 0){
            fullTime++;
        }
        int totalOil = realLength / car.perLiter;
        if(realLength % car.perLiter != 0){
            totalOil++;
        }
        int totalFill = totalOil / car.oiltank;
        if(totalOil % car.oiltank != 0){
            totalFill++;
        }

        System.out.println("총 비용 : " + (totalOil * 2000));
        System.out.println("주유 횟수 : " + totalFill);
        System.out.println("총 시간 : " + fullTime);

    }

}
