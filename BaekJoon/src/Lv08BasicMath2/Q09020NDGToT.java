package Lv08BasicMath2;

import java.io.*;
import java.util.*;

public class Q09020NDGToT {

    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] prime = new boolean[10001];
		prime[0] = prime[1] = true;
		
		for(int i=2;i*i<prime.length;i++) {
			if(!prime[i])
				for(int j=i*i;j<prime.length;j+=i) {
				prime[j] = true;
				}
		}
		
		ArrayList<Integer> primeList = new ArrayList<>();
		
		for(int i=0;i<prime.length;i++) {
			if(!prime[i]) primeList.add(i);
		}
		
		int cycle = Integer.parseInt(br.readLine());
		int n;
		int a, b;
		int idx=0;
		int min = 10000;
		
		for(int i=0;i<cycle;i++) {
			n = Integer.parseInt(br.readLine());
			ArrayList<Integer> answerList = new ArrayList<>();
			for(int j=0;j<primeList.size();j++) {
				a = primeList.get(j);
				if(a*2>n) break;
				for(int k=j;k<primeList.size();k++) {
					b = primeList.get(k);
					if(b>n) break;
					if(a+b==n) {
						answerList.add(a);
						answerList.add(b);
					}
				}
			}
//			ArrayList<Integer> diffList = new ArrayList<>();
//			for(int j=0;j<answerList.size();j+=2) {
//				if(answerList.get(j)>answerList.get(j+1)) {
//					diffList.add(answerList.get(j)-answerList.get(j+1));
//				} else {
//					diffList.add(answerList.get(j+1)-answerList.get(j));
//				}
//			}
//			for(int j=0;j<diffList.size();j++) {
//				if(diffList.get(j)<min){
//					min = diffList.get(j);
//					idx = j;
//				}
//			}
			
			bw.write(Integer.toString(answerList.get(answerList.size()-2)) + " " + Integer.toString(answerList.get(answerList.size()-1)));
			bw.newLine();
			
			min = 10000;
		}
		
		bw.close();
		
	}
    // 이 방식 말고, n을 반띵해서 a,b로 두고 ++ -- 하면서 둘다 맞으면 제일 가까운 수지.....허허허허허허
}
