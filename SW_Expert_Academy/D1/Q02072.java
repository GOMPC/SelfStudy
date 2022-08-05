package D1;

import java.io.*;
import java.util.*;

public class Q02072 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cycle = Integer.parseInt(br.readLine());
		int sum = 0;
		int num;
		
		for(int i=1;i<=cycle;i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				num = Integer.parseInt(stk.nextToken());
				if(num%2==1) {
					sum += num;
				}
			}
			bw.write("#"+Integer.toString(i)+" "+Integer.toString(sum));
			bw.newLine();
			sum = 0;
		}
		
		bw.close();

	}

}
