package Week3;

import java.io.*;
import java.util.*;

public class PCRoomCuttingNum {
    
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] isPlay = new boolean[101];
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		StringTokenizer stk = new StringTokenizer(s);
		int seat;
		int cnt = 0;
		
		for(int i=0;i<n;i++) {
			seat = Integer.parseInt(stk.nextToken());
			if(!isPlay[seat]) isPlay[seat] = true;
			else cnt++;
		}
		
		bw.write(Integer.toString(cnt));
		bw.close();
	}

}
