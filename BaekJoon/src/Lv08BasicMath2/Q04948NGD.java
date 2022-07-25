package Lv08BasicMath2;

import java.io.*;

public class Q04948NGD {
    
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] prime = new boolean[246913];
		
		prime[0] = prime[1] = true;
		
		for(int i=2;i*i<=246913;i++) {
			if(!prime[i])
				for(int j=i*i;j<=246913;j+=i) {
					prime[j] = true;
				}
		}
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0)break;
			int cnt = 0;
			
			for(int i=n+1;i<=n*2;i++) {
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
