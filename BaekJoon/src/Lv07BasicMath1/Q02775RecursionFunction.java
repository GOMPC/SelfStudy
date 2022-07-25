package Lv07BasicMath1;

import java.io.*;

public class Q02775RecursionFunction {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Test test = new Test();
		int cycle = Integer.parseInt(br.readLine());
		
		for(int i=0;i<cycle;i++) {
			int floor = Integer.parseInt(br.readLine());
			int room = Integer.parseInt(br.readLine());
			
			bw.write(Integer.toString(test.test(floor, room)));
			bw.newLine();
		}
		br.close();
		bw.close();

    }
    
}

class Test{
	
	public int test(int a, int b) {
		if(a==0) {
			return b;
		} else if(b==1){ // 두개짜리 매개변수가 필요하니, 두개의 시작지점을 잡아야지.. 그래야 stackoverflow 안만난다 친구 ㅎ
			return 1;
		} else {
			return test(a-1, b) + test(a, b-1);
		}
	}
	
}