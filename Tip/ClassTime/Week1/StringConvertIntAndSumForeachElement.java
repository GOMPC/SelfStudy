package Week1;

import java.util.Scanner;

// N개의 숫자가 공백없이 입력됩니다. 12374897120957891234
// 다 더해.

public class StringConvertIntAndSumForeachElement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int sum = 0;

        for(int i=0;i<s.length();i++){
            sum += s.charAt(i)-'0';
        }

        System.out.println(sum);
        
    }
    
}
