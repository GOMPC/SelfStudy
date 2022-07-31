package Lv03IterationStatement;

import java.io.*;

public class Q02439StarShotVer2 {
    public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int i = Integer.parseInt(bf.readLine());
        int n = i;
		
		for(int j=1;j<=i;j++) {
			n--;
			for(int l=0;l<n;l++) {
				bw.write(" ");
			}
			for(int k=0;k<j;k++) {
				bw.write("*");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
