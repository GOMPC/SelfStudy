package Lv08BasicMath2;

import java.io.*;

public class Q11653ForWhileToT {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		mach(n);
		
		bw.close();
		
	}
	
	public static int mach(int n) throws IOException {
		if(n==1) return 1;
		else {
			for(int i=2;i<=n;i++) { // i*i가 정말 좋은 띵킹이네 왜냐! for(int i = 2; i*i <= N; i++) 그 머시기 때문!
				if(n%i==0) {
					bw.write(Integer.toString(i));
					bw.newLine();
					return mach(n/i);
				}
			}
			return 1;
		}
	}
    
}
