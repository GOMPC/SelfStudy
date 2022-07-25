package Lv09Factorial;

import java.io.*;

public class Q10870 {

    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		Fibonacci fibo = new Fibonacci();
		
		bw.write(Integer.toString(fibo.fibo(n)));
		bw.close();
	}
    
}

class Fibonacci{
	public int fibo(int a) {
		if(a==0) return 0;
		else if (a==1) return 1;
		else return (fibo(a-1)+fibo(a-2));
	}
}