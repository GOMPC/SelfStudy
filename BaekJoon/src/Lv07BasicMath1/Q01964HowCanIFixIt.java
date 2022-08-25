package Lv07BasicMath1;

import java.io.*;

public class Q01964HowCanIFixIt {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long zeom = 5 + (n-1)*4;
        for(int i=1;i<n;i++) {
        	zeom += 3*i;
        }
        
        System.out.println(zeom%45678);
        
	}
}
