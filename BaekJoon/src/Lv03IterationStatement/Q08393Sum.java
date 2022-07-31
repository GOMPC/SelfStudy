package Lv03IterationStatement;

import java.io.*;

public class Q08393Sum {
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        br.close();
        int sum = n*(n+1)/2;
        
        bw.write(Integer.toString(sum));
        bw.close();

	}
}
