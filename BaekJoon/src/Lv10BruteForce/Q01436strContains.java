package Lv10BruteForce;

import java.io.*;

public class Q01436strContains {
    
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int answer;
		int i = 0;
		
		while(true) {
			i++;
			
			String strNum = Integer.toString(i);
			if(strNum.contains("666")) {
				cnt++;
			}
			
			if(cnt==n) {
				answer = i;
				break;
			}
		}
		
		bw.write(Integer.toString(answer));
		bw.close();
		
	}

}
