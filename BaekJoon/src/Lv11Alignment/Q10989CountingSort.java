package Lv11Alignment;

import java.io.*;

public class Q10989CountingSort {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cycle = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		
		int n;
		
		for(int i=0;i<cycle;i++) {
			n = Integer.parseInt(br.readLine());
			arr[n]++;
		}
		
		for(int i=0;i<arr.length;i++) {
			while(arr[i]-- > 0) {
				bw.write(Integer.toString(i));
				bw.newLine();
			}
		}
		
		bw.close();
		
	}

}