package Lv09Factorial;

import java.io.*;

public class Q10872Factorial {
    
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		Factorial fact = new Factorial();
		
		bw.write(Integer.toString(fact.fact(n)));
		bw.close();
		
	}

}

class Factorial{
	public int fact(int a) {
		if(a<2) return 1;
		else return fact(a-1)*a;
	}
}
