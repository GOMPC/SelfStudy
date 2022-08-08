package Week3;

import java.io.*;

public class OctalNumToBinaryNum {
    public static void main(String[] args) throws IOException {
		
		// 첫 입력 수는 8진법으로 이루어진 수이다. >> Math.pow로 ㅇㅇ
		// 이것을 2진법으로 변환하여 출력하시오.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int sum = 0;
		int back = s.length()-1;
		
		for(int i=0;i<s.length();i++, back--) {
			sum += (s.charAt(back)-'0') * (int)Math.pow(8, i);
		}
		
		String binaryString = Integer.toBinaryString(sum);
		
		System.out.println(binaryString);
		
	}
}
