package Lv03IterationStatement;

import java.util.*;
import java.io.*;

public class Q10951EOFRough {
    public static void main(String[] args) throws IOException {
		
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(sc.hasNextInt()) {
    	        
    	    int a = sc.nextInt();
    	    int b = sc.nextInt();
    	    
    	    bw.write(Integer.toString(a+b));
    		bw.newLine();
    		
        }
        sc.close();
        bw.flush();
	}
}
