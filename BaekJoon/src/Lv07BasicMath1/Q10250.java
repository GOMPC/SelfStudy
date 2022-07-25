package Lv07BasicMath1;

import java.io.*;
import java.util.*;

public class Q10250 {

    public static void main(String[] args) throws IOException{
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCycle = Integer.parseInt(br.readLine());
		
		for(int i=0;i<testCycle;i++) {
			String s = br.readLine();
			StringTokenizer stk = new StringTokenizer(s);
			
			int floor = Integer.parseInt(stk.nextToken());
			stk.nextToken();
			int guest = Integer.parseInt(stk.nextToken());
			
			int firstNum = guest % floor;
			int lastNum = (guest / floor) + 1;
			String lastNum2;
			String roomNum;
			
			if(firstNum == 0) {
				firstNum = floor;
				lastNum = guest / floor;
			}
			
			if(lastNum<10) lastNum2 = "0" + lastNum;
			else lastNum2 = Integer.toString(lastNum);
			
			roomNum = Integer.toString(firstNum) + lastNum2;
			
			bw.write(roomNum);
			bw.newLine();
			
//			String lastNum2;
//			String roomNum;
//			
//			if(firstNum==0) {
//				roomNum = Integer.toString(floor) + Integer.toString(lastNum-1);
//				if(lastNum<10) {
//					lastNum2 = "0" + lastNum;
//					roomNum = Integer.toString(floor) + lastNum2;
//				}
//			} else {
//				if(lastNum<10) lastNum2 = "0" + lastNum;
//				else lastNum2 = Integer.toString(lastNum);
//				roomNum = Integer.toString(firstNum) + lastNum2;
//			}
//			bw.write(roomNum);
//			bw.newLine();
			
//			String roomNum;
//			String lastNum2;
//			
//			if(firstNum==0) {
//				roomNum = Integer.toString(floor) + "01";
//			} else {
//				if(lastNum<10) lastNum2 = "0" + lastNum;
//				else lastNum2 = Integer.toString(lastNum);
//				roomNum = Integer.toString(firstNum) + lastNum2;
//			}
//			
//			bw.write(roomNum);
//			bw.newLine();
		}
		bw.flush();

    }
}
