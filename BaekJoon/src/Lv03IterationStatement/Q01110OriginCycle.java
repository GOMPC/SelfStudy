package Lv03IterationStatement;

import java.io.*;

public class Q01110OriginCycle {
    public static void main(String[] args) throws IOException {
		
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(bf.readLine());
        int nn = n;
        int cycle = 1;
	    
		while(true) {
			int a = n/10;
		    int b = n-a*10;
		    int c = a+b;
		    int d = c/10;
		    int e = c-d*10;
		    int f = b*10+e;
		    if(nn==f) break;
		    n = f;
			cycle++;
		}
		bw.write(Integer.toString(cycle));
		bw.flush();
		
	}
}
