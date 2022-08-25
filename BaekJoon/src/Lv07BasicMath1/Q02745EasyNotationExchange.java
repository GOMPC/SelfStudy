package Lv07BasicMath1;

import java.io.*;
import java.util.*;

public class Q02745EasyNotationExchange {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        String s = stk.nextToken();
        int n = Integer.parseInt(stk.nextToken());
        
        long answer = Long.parseLong(s, n);

        bw.write(Long.toString(answer));
        bw.close();
        
	}
}
