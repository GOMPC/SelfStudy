package Lv11Alignment;

import java.io.*;
import java.util.*;

public class Q02750PriorityQueue {

    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> challenge = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			challenge.add(Integer.parseInt(br.readLine()));
		}
		
		for(int i=0;i<n;i++) {
			bw.write(Integer.toString(challenge.poll()));
			bw.newLine();
		}
		bw.close();
		
	}
    
}
