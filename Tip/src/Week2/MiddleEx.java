package Week2;

import java.io.*;
import java.util.*;

public class MiddleEx {

    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
//		숫자 10개 입력
//		42로 나눈 나머지
//		다른 값이 몇개가 있을까요?
// 		배열에 ++하고 0이 아니면 cnt++;
		
		String s = br.readLine();
		StringTokenizer stk = new StringTokenizer(s);
		int[] rest = new int[42];
		int cnt = 0;
		
		for(int i=0;i<10;i++) {
			int n = Integer.parseInt(stk.nextToken());
			int a = n%42;
			rest[a]++;
		}
		
		for(int i=0;i<rest.length;i++) {
			if(rest[i]!=0) cnt++;
		}
		
		bw.write(Integer.toString(cnt));
		bw.close();
		
		
	}
    
}
