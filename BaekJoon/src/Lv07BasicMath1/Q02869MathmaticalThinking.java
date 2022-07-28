package Lv07BasicMath1;

import java.io.*;
import java.util.*;

public class Q02869MathmaticalThinking {
    
    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer stk = new StringTokenizer(s);
		
		int run = Integer.parseInt(stk.nextToken());
		int down = Integer.parseInt(stk.nextToken());
		int height = Integer.parseInt(stk.nextToken());
		
		int dayrun = run-down;
		int lastrun = height - run;
		double ans = (double)lastrun / dayrun +1;
		int answer = (int)ans;
		if(ans>answer) answer++;
		
		bw.write(Integer.toString(answer));
		bw.close();
		
		// (run - down)x + run = height
		// answer = x+1
		// x = (height - run)/(run-down)
	}
    
}
