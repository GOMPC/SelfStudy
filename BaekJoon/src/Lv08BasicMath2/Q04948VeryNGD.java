package Lv08BasicMath2;

import java.io.*;

public class Q04948VeryNGD {

    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			int cnt = 0;
			
			boolean[] prime = new boolean[2*n+1];
			prime[0] = prime[1] = true;
			
			for(int i=2;i*i<=2*n;i++) {
				if(!prime[i]) {
					for(int j=i*i;j<=2*n;j+=i) {
						prime[j] = true;
					}
				}
			}
			
			for(int i=n+1;i<=2*n;i++) {
				if(!prime[i]) {
					cnt++;
				}
			}
			bw.write(Integer.toString(cnt));
			bw.newLine();
		}
		bw.close();

    }
    
}
