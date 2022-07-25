package Lv10BruteForce;

import java.io.*;
import java.util.*;

public class Q02798 {

    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String gameSet = br.readLine();
		String cardSet = br.readLine();
		
		StringTokenizer gmS = new StringTokenizer(gameSet);
		int cardNum = Integer.parseInt(gmS.nextToken());
		int wantNum = Integer.parseInt(gmS.nextToken());
		
		ArrayList<Integer> cardList = new ArrayList<Integer>();
		StringTokenizer cS = new StringTokenizer(cardSet);
		
		for(int i=0;i<cardNum;i++) {
			cardList.add(Integer.parseInt(cS.nextToken()));
		}
		
		//픽한 3장의 합이 wantNum을 넘지않고 가장 가깝게.
		int a, b, c, sum;
		int answer = 0;
		
		for(int i=0;i<cardList.size();i++) {
			a = cardList.get(i);
			for(int j=i+1;j<cardList.size();j++) {
				b = cardList.get(j);
				for(int k=j+1;k<cardList.size();k++) {
					c = cardList.get(k);
					sum = a+b+c;
					if((wantNum>=sum)&&(sum>answer)) {
						answer = sum;
					}
				}
			}
		}
		
		bw.write(Integer.toString(answer));
		bw.close();
		
	}
    
}
