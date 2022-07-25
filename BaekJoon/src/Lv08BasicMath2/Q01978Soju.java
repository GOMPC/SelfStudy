package Lv08BasicMath2;

import java.io.*;
import java.util.*;

public class Q01978Soju {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int[] intArr = new int[n];
		
		for(int i=0;i<n;i++) {
			intArr[i] = Integer.parseInt(stk.nextToken());
			if(soju(intArr[i])) {
				cnt++;
			}
		}
		
		bw.write(Integer.toString(cnt));
		bw.close();

    }
    
    public static boolean soju(int a) {
		boolean soju = true;
		
		if(a==1)return !soju;
		if(a==2)return soju;
		
		for(int i=2;i<a;i++) {
			if(a%i==0) soju = false;
		}
		return soju;
		
//		int num = Integer.parseInt(br.readLine());
//        int cnt = 2;
//
//        for(int i=2;i<num;i++){
//            if(num%i == 0) break;
//            else cnt++;
//            if(cnt==num) bw.write(Integer.toString(num)); 
//        }
//        bw.close(); 
//		cnt로 소주찾기~
	}

}
