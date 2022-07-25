package Lv06String;

import java.io.*;

public class ToT_Q01157 {
    
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = 0;
		int max = 0;
		String s = br.readLine();
		char a = 'a';
		
		for(int i=0;i<s.length();i++) {
			cnt = 0;
			for(int j=i;j<s.length();j++) {
				if(s.charAt(i) == s.charAt(j)) cnt++;
				if(max<cnt) {
					max = cnt;
					a = s.charAt(i);
				}
			}
		}
		
		System.out.println(a);	
		
		//정수 cnt 한개 조지고 같으면 cnt++
		//cnt 젤 높은 친구 max로 잡자. 
		//max값이 나오는 j가 있을거잖아. 근데 어케찾나? charAt(j) 로 찾을 수 있는데, 만약 두개가 max면?
		//
	}

}
