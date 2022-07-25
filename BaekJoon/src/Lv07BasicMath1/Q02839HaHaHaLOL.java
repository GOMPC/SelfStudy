package Lv07BasicMath1;

import java.io.*;

public class Q02839HaHaHaLOL {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int hope = n/5;
		int sub, cnt;
		
		for(int i=hope;i>=0;i--) {
			sub = n-(i*5);
			cnt = i;
			if(sub%3==0) {
				cnt += sub/3;
				bw.write(Integer.toString(cnt));
				break;
			}
			if((i==0) && (sub%3!=0)) {
				bw.write("-1");
			}
		}
		
		bw.close();
        
    }
    
}
