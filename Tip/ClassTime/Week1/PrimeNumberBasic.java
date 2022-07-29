package Week1;

import java.io.*;

public class PrimeNumberBasic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int cnt = 2;

        for(int i=2;i<num;i++){
            if(num%i == 0) break; // 2부터 num까지 직접 노가다
                else cnt++;
            if(cnt==num) bw.write(Integer.toString(num)); // 입력 된 수가 소수일 경우 출력
        }
        bw.close();

    }

    public static void answer2(int a){
        boolean isPrime = true;
        for(int i=2;i<a;i++){
            if(a%i == 0) isPrime = false;
        }
        if(isPrime) System.out.println(a);
    }
    
}
