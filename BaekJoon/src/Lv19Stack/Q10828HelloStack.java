package Lv19Stack;

import java.io.*;
import java.util.*;

public class Q10828HelloStack {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cycle = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<cycle;i++) {
			String s = br.readLine();
			if(s.contains("push")) {
				String[] st = s.split(" ");
				stack.push(Integer.parseInt(st[1]));
			}
			switch(s) {
			case "pop" : 
				try{
					bw.write(Integer.toString(stack.pop()));
					bw.newLine();
				} catch(EmptyStackException e) { 
					bw.write("-1");
					bw.newLine();
					} break;
			case "size" : 
				bw.write(Integer.toString(stack.size()));
				bw.newLine();
				break;
			case "empty" :
				if(stack.isEmpty()) {
					bw.write("1");
					bw.newLine();
				} else {
					bw.write("0");
					bw.newLine();
				} break;
			case "top" : 
				try {
					bw.write(Integer.toString(stack.peek()));
					bw.newLine();
				} catch(EmptyStackException e) {
					bw.write("-1");
					bw.newLine();
				}
			}
		}
		
		bw.close();

        // 그냥 스택을 구현해버릴걸.. 문제에도 나와있었네ㅠ
		
	}

}

