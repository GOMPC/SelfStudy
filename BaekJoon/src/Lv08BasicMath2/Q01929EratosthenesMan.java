package Lv08BasicMath2;

import java.io.*;
import java.util.*;

public class Q01929EratosthenesMan {
    
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer stk = new StringTokenizer(s);
		
		int min = Integer.parseInt(stk.nextToken());
		int max = Integer.parseInt(stk.nextToken());
		
		boolean[] boolArr = new boolean[max+1];
		
		boolArr[0] = boolArr[1] = true;
		
		for(int i=2;i*i<=max;i++) {
			if(!boolArr[i]) {
				for(int j=i*i;j<=max;j+=i) {
					boolArr[j] = true;
				}
			}
		}
		
		for(int i=min;i<=max;i++) {
			if(!boolArr[i]) {
				bw.write(Integer.toString(i));
				bw.newLine();
			}
		}
		
		bw.close();
	}

}
