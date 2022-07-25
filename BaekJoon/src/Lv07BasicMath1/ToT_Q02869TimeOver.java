package Lv07BasicMath1;

import java.io.*;
import java.util.*;

public class ToT_Q02869TimeOver {

    public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		StringTokenizer stk = new StringTokenizer(s);
		
		int run = Integer.parseInt(stk.nextToken());
		int down = Integer.parseInt(stk.nextToken());
		int height = Integer.parseInt(stk.nextToken());
		
		int dayrun = run-down;
		int day = height/dayrun;
		int dayrunning = height%dayrun;
		
		if(run>dayrunning) {
			bw.write(Integer.toString(day-run+1));
		} else {
			bw.write(Integer.toString(day));
		}
		bw.close();
        
    }
    
}
