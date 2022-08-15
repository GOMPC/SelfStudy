package Lv19Stack;

import java.io.*;
import java.util.*;

public class Q02108mid2FalseToT {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int cycle = Integer.parseInt(br.readLine());
        int[] arr = new int[cycle];
        int[] free = new int[8001];
        int sum = 0;
        int min = 4000;
        int max = -4000;
        
        for(int i=0;i<cycle;i++) {
        	int n = Integer.parseInt(br.readLine());
        	sum += n;
        	if(n<min) min = n;
        	if(n>max) max = n;
        	arr[i] = n;
        	free[n+4000]++;
        }
        
        Arrays.sort(arr);
        int mid = (int)Math.round((double)sum/cycle);
        int mid2 = arr[cycle/2]; // 이렇게 하면 안되요!
        int freq;
        int round = max-min;
        max = 0; min = 0;
        int index = 0;

        for(int i=0;i<free.length;i++) { // 최빈값 중 두번째로 작은 값 
        	if(free[i]>max) {
        		max = free[i];
        		index = i;
        	} else if(free[i]==max) {
        		index = -2;
        	}
        }
        
        if(index>-1) freq = index-4000;
        else {
        	for(int i=0;i<free.length;i++) {
        		if(free[i]==max && min == 1) index = i;
        		if(free[i]==max) min++;
        	}
        	freq = index - 4000;
        }
        
        bw.write(Integer.toString(mid));
        bw.newLine();
        bw.write(Integer.toString(mid2));
        bw.newLine();
        bw.write(Integer.toString(freq));
        bw.newLine();
        bw.write(Integer.toString(round));
        bw.close();
        
	}
}