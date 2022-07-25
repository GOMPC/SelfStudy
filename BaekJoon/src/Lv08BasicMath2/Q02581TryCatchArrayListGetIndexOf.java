package Lv08BasicMath2;

import java.io.*;
import java.util.*;

public class Q02581TryCatchArrayListGetIndexOf {

    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int min = Integer.parseInt(br.readLine());
		int max = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> intArr = new ArrayList<>();
		
		for(int i=min;i<=max;i++) {
			if(soju(i)) intArr.add(i);
		}
		
		int sum = 0;
		
		for(int i : intArr) {
			sum += i;
		}
		
		try {
			intArr.get(0);
			bw.write(Integer.toString(sum));
			bw.newLine();
			bw.write(Integer.toString(intArr.get(0)));
		} catch(IndexOutOfBoundsException e) {
			bw.write("-1");
		}
		
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
	}
    
}
