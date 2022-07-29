package Week2;

import java.io.*;

public class AddressEx {
    
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		// 기본 앞뒤 1개씩
		// 숫자 사이 한칸씩 공백
		// 1은 2칸 0은 4칸 나머지는 3칸
		// 몇칸이겠냐
		// 120을 예로 들면 앞뒤2칸 + 1의 2칸 + 2의 3칸 + 0의 4칸 + 사이 2칸 
		
		String s = br.readLine();
		int margin = s.length()-1; // 글자 사이니까 -1
		int origin = 2; 		   // 앞 뒤 여백
		int basic = s.length()*3;  // 기본 3칸 추가요
		
		// 0이면 +1 1이면 -1
		if(s.contains("0"))
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)==0) basic++;
			}
		if(s.contains("1"))
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)==1) basic--;
			}
		
		int answer = margin + origin + basic;
		bw.write(Integer.toString(answer));
		bw.newLine();
		
	}

}
