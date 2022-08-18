package Lv04Array;

import java.io.*;
import java.util.*;

public class Q02738BasicArray {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[][] arr = new int[Integer.parseInt(stk.nextToken())][Integer.parseInt(stk.nextToken())];	
		
		for(int i=0;i<arr.length;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] += Integer.parseInt(stk.nextToken());
				bw.write(Integer.toString(arr[i][j]) + " ");
			}
			bw.newLine();
		}
		
		bw.close();
		
	}

}
