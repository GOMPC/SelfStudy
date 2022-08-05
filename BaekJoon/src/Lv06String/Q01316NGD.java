package Lv06String;

import java.io.*;

public class Q01316NGD {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cycle = Integer.parseInt(br.readLine());
		int cnt = cycle;
		
		all : for(int k=0;k<cycle;k++) {
			String s = br.readLine();
			char[] cNum = s.toCharArray();
			
			for(int i=1;i<cNum.length;i++) {
				if(cNum[i]!=cNum[i-1]) {
					for(int j=0;j<i;j++) {
						if(cNum[j]==cNum[i]) {
							cnt--;
							continue all;
						}
					}
				}
			}
		}
		
		bw.write(Integer.toString(cnt));
		bw.close();
		
	}

}
