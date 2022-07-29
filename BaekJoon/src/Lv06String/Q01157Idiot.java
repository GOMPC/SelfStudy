package Lv06String;

import java.io.*;

public class Q01157Idiot {
    
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		String a = s.toUpperCase();
		
		char[] cNum = a.toCharArray();
		int[] cnt = new int[100];
		
		for(char c='A';c<='Z';c++) {
			for(int i=0;i<cNum.length;i++) { // 이렇게 하지말고 그냥 cnt에 65빼서 아니면 97빼서 집어넣는게 훨 편함 ㅇㅇ
				if(c==cNum[i]) cnt[c]++;
			}
		}
		
		int max = 0;
		
		for(int i=0;i<cnt.length;i++) {
			if(cnt[i]>max) max = cnt[i];
		}
		
		int count = 0;
		int index = 0;
		
		for(int i=0;i<cnt.length;i++) {
			if(cnt[i]==max) {
				count++;
				index = i;
			}
		}
		
		char answer = (char) index;
		if(count>1) {
			bw.write("?");
		} else {
			bw.write(Character.toString(answer));
		}
		
		bw.close();
		
	}

}
