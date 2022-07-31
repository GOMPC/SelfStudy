package Lv03IterationStatement;

import java.util.*;
import java.io.*;

public class Q15552FastAplusB {
    public static void main(String[] args) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int i = Integer.parseInt(br.readLine());
		
		for(int j=0;j<i;j++) {
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
            
			bw.write(Integer.toString(a+b));
			bw.newLine();
		}
		bw.flush();

	}
}
