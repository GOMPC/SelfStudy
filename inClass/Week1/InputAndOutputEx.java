package Week1;

import java.util.*;
// 3자리 정수 입력받아 abc로 각각 100의 자리 10의 자리 1의 자리 수
// 최대값은 무엇일까요?

public class InputAndOutputEx {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        sc.close();

        String s = sc.nextLine();

        // int a = s.charAt(0)-'0';
        // int b = s.charAt(1)-'0';
        // int c = s.charAt(2)-'0'; 쉽게 가는 방법?

        int num = Integer.parseInt(s);

        int a1 = num/100;
        int b1 = (num - a1*100) / 10;
        // int b2 = (num/10)%10;
        // int b3 = (num%100)/10; 여러가지 종류가 있을 수 있다. 방법!
        int c1 = num%10;

        if((a1>b1)&&(a1>c1)) System.out.println(a1);
         else if((b1>a1)&&(b1>c1)) System.out.println(b1);
         else System.out.println(c1);

    }
    
}
