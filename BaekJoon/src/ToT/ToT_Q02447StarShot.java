package ToT;

import java.io.*;
import java.util.*;

public class ToT_Q02447StarShot {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		
		
		int n = Integer.parseInt(br.readLine());
		
		starShot(n);
		bw.close();
		
	}
	
	public static void starShot(int a) throws IOException {
		
		int n = a*a;
		int cnt = 0;
		int middle = n/2+1;
		
		if(a==3) {
			for(int i=0;i<n;i++) {
				
				cnt++;
				
				if(cnt==middle) {
					bw.write(" ");
					continue;
				}
				
				bw.write("*");
				
				if(cnt%a==0) {
					bw.newLine();
				}
				
			}
		} else if(a==9){
			for(int i=0;i<n;i++) {
				
				cnt++;
				
				if(cnt == middle) {
					bw.write(" ");
					continue;
				}
				
				bw.write("*");
				
				if(cnt%a == 0) {
					bw.newLine();
				}
			}
			
		}
		
	}

}
