package Week1;

public class PrintAlignTip {
    
    public static void main(String[] args) {

        for(int i=1;i<101;i++){
            System.out.printf("%4d", i);
            if(i%10==0) System.out.println(); // 10개마다 단락을 바꿔줘요!
        }

        // 1~1000 7의 배수 출력. + 10개씩 단락바꿈
        for(int i=1;i<1001;i++){
            if(i%7==0) System.out.printf("%4d", i);
            if((i%7==0)&&(i%70==0)) System.out.println(); // 왜 이렇게 했는가!
        }// 아니면 cnt 잡아서 7값 잡을때마다 위에 저놈처럼 (cnt%10==0) ㅋㅋㅋ
    }
    
}
