package D1;

import java.io.*;
import java.util.*;

public class Q02071 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cycle = Integer.parseInt(br.readLine());
		int sum = 0;
		int num;
		double avg;
		long avg2;
		
		for(int i=1;i<=cycle;i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				num = Integer.parseInt(stk.nextToken());
				sum += num;
			}
			avg = sum / 10.0;
			avg2 = Math.round(avg);
			bw.write("#"+Integer.toString(i)+" "+Long.toString(avg2));
			bw.newLine();
			sum = 0;
		}
		
		bw.close();
		
	}
	
}