package Lv11Alignment;

import java.io.*;
import java.util.*;

public class Q11651CompareCompare {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cycle = Integer.parseInt(br.readLine());
		int[][] arr = new int[cycle][2];
		
		for(int i=0;i<cycle;i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(stk.nextToken());
			arr[i][1] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]!=o2[1]) return o1[1] - o2[1];
				else return o1[0] - o2[0];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(int[] e : arr) {
			sb.append(e[0]).append(" ").append(e[1]).append("\n");
		}
		
		System.out.println(sb);
		
	}

}