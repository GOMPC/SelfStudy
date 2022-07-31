package Lv03IterationStatement;

import java.util.*;
import java.io.*;

public class Q10951EOF {
    public static void main(String[] args) throws IOException {
		
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String input = ""; // 왜 여기서 input을 잡았을까요? ㅎㅎ
        
        while((input = bf.readLine()) != null) {
        	
    	    StringTokenizer st = new StringTokenizer(input);
    	        
    	    int a = Integer.parseInt(st.nextToken());
    	    int b = Integer.parseInt(st.nextToken());
    	    
    	    bw.write(Integer.toString(a+b));
    		bw.newLine();
    		
        	
        }
        
		bw.flush();	
		
	}
}
