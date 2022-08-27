package Lv07BasicMath1;

import java.util.*;
import java.io.*;

public class Q01297TriangleNGD {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        int length = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());
        
        double answera = length*length*Math.pow(x, 2) / (Math.pow(x, 2) + Math.pow(y, 2));
        int answer1 = (int)Math.sqrt(answera);
        double answerb = length*length*Math.pow(y, 2) / (Math.pow(x, 2) + Math.pow(y, 2));
        int answer2 = (int)Math.sqrt(answerb);
        
        bw.write(Integer.toString(answer1) + " " + Integer.toString(answer2));
        bw.close();
        
	}
}
