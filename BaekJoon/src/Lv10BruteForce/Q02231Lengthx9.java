package Lv10BruteForce;

import java.io.*;
import java.util.*;

public class Q02231Lengthx9 {

    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		boolean right = false;
		for(int i=1;i<n;i++) {
			if(marine(i)==n) {
				bw.write(Integer.toString(i));
				right = true;
				break;
			}
		}
		if(!right) bw.write("0");
		bw.close();
		
	}
	
	static int marine(int a) {
		String s = Integer.toString(a);
		ArrayList<Integer> arr = new ArrayList<>();
		int sum = a;
		for(int i=0;i<s.length();i++) {
			arr.add(s.charAt(i)-'0');
		}
		for(int e : arr) {
			sum += e;
		}
		return sum;
	}
    
}
