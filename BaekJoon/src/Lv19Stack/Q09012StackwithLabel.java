package Lv19Stack;

import java.io.*;
import java.util.*;

public class Q09012StackwithLabel {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cycle = Integer.parseInt(br.readLine());
		
		all : for(int j=0;j<cycle;j++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='(') {
					stack.push(s.charAt(i));
				} else {
					try{
						stack.pop();
					} catch(EmptyStackException e) {
						bw.write("NO");
						bw.newLine();
						continue all;
					}
				}
			}
			if(stack.isEmpty()) {
				bw.write("YES");
				bw.newLine();
			} else {
				bw.write("NO");
				bw.newLine();
			}
		}
		
		bw.close();
	}

}
