package Lv11Alignment;

import java.io.*;
import java.util.*;

public class Q11650ComparePractice {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cycle = Integer.parseInt(br.readLine());
		ArrayList<XY> arr = new ArrayList<>();
		
		for(int i=0;i<cycle;i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			arr.add(new XY(a,b));
		}
		
		Collections.sort(arr);
		
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
		
	}

}


class XY implements Comparable<XY>{
	int x;
	int y;
	
	XY(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(XY o) {
		if(this.x > o.x) return 1;
		else if(this.x == o.x && this.y > o.y) return 1;
		else return -1;
	}
	
	@Override
	public String toString() {
		return this.x + " " + this.y;
	}
	
}