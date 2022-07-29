package Week1;

public class DataTypeTip {
    
    public static void main(String[] args) {
        char grade = 'A'; //Must 작은 따옴표
        byte value = 128-1; //호에에엥 왜 이렇게 될까요오

        //초기화 없이 선언만 할 경우 쓰레기 값이 들어갈 수도 있다?
        //snake 표기법 ( 파이썬 맨~ tax_rate )

        int var1 = 0b1010;
        int var2 = 0206;
        int var3 = 365;
        int var4 = 0x83a7; // 16진법. 디자이너 RGB생각. FFFFFF 000000 기억나잖슴? FF가 한 바이트로 처리가 된다.

        //println은 데이터 타입에 따라서 알아서 오버라이딩 세팅이 되어있어요~
        //printf는 니가 서식에 맞추는 ㅇㅋ?

        long score = 39393939393939l;
        System.out.printf("스코어 : %d\n", score);
        // 이스케이프 \b : 백스페이스
        // 이스케이프 \r : ?

        System.out.println(grade+value+var1+var2+var3+var4);
        //숫자로 나오네?
        System.out.println(grade+1);
        //grade만 치면 char니까 A가 나오고 grade+1을 하면 int로 변환되서 int로 나오는건가?

    }
    
}
