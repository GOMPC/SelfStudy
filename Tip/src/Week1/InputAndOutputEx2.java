package Week1;

import java.io.*;

public class InputAndOutputEx2 {

    public static void main(String[] args) throws IOException {
        //정수 n을 입력받아 n*n크기의 행렬을 출력하시오

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=1;i<=n*n;i++){
            System.out.printf("%3d", i);
            if(i % n == 0) System.out.println();
        }

        //스캐너 String s = sc.next() < 공백까지.
        int a = System.in.read();
        System.out.println(a); // ㅁㅊ char값으로 받네

        //equalsIgnoreCase() 대소문자 구분하지 않고 확인해!
        
    }
    
}
