package Lv07BasicMath1;

import java.io.*;

public class Q02292 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int i = 0;
		
		Flex flex = new Flex();
		
		while(true) {
			i++;
			if(flex.route(i) >= n) {
				break;
			}
		}
		bw.write(Integer.toString(i));
		bw.flush();

    }
    
}

class Flex{

	public int route(int a) {
		if(a == 1) return 1; 
		else {
			return route(a-1) + 6*(a-1);
		}
	}
	
}
