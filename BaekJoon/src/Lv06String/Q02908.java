package Lv06String;

import java.io.*;
import java.util.*;

public class Q02908 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		StringTokenizer stk = new StringTokenizer(s);
		
		String a = stk.nextToken();
		String b = stk.nextToken();
		
		char[] cNum1 = a.toCharArray();
		char[] cNum2 = b.toCharArray();
		
		String num1 = "";
		String num2 = "";
		
		for(int i=cNum1.length-1;i>-1;i--) {
			num1 += cNum1[i];
			num2 += cNum2[i];
		}
		
		int num11 = Integer.parseInt(num1);
		int num22 = Integer.parseInt(num2);
		
		if(num11>num22) {
			bw.write(Integer.toString(num11));
		} else {
			bw.write(Integer.toString(num22));
		}
		bw.flush();
		
    }
    
}
