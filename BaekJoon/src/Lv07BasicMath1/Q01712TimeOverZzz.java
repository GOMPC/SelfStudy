package Lv07BasicMath1;

import java.io.*;
import java.util.*;

public class Q01712TimeOverZzz {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer stk = new StringTokenizer(s);
		
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		int earn = c-b;
		int count = 0;
		try {
			count = a/earn+1;
		} catch (ArithmeticException e) {
		}
		
		
		if(b>=c) bw.write("-1");
		else{
			bw.write(Integer.toString(count));
		}
		bw.close();
        
    }
    
}
