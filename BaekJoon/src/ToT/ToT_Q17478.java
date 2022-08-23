package ToT;

import java.io.*;
import java.util.*;

public class ToT_Q17478 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static String a = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n"; // 한번만.
	static String b = "\"재귀함수가 뭔가요?\"\r\n";
	static String c = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\r\n";
	static String d = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\r\n";
	static String e = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"; // 0부터 n-1까지
	static String f = "\"재귀함수가 뭔가요?\"\r\n"; // 이놈을 n일때
	static String g = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\r\n";
	static String h = "라고 답변하였지.\n"; // 이걸 n ... 0까지 재귀
	
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		cryingA(n);
		bw.close();
		
		
	}
	
	static int cryingA(int n) throws IOException {
		bw.write(a);
		return cryingB(n);
	}
	static int cryingB(int n) throws IOException {
		for(int i=0;i<cnt;i++) {
			bw.write("____");
		}
		bw.write(b);
		for(int i=0;i<cnt;i++) {
			bw.write("____");
		}
		bw.write(c);
		for(int i=0;i<cnt;i++) {
			bw.write("____");
		}
		bw.write(d);
		for(int i=0;i<cnt;i++) {
			bw.write("____");
		}
		bw.write(e);
		cnt++;
		
		if(cnt == n) return cryingC(n);
		else return cryingB(n);
	}
	static int cryingC(int n) throws IOException {
		for(int i=0;i<cnt;i++) {
			bw.write("____");
		}
		bw.write(f);
		for(int i=0;i<cnt;i++) {
			bw.write("____");
		}
		bw.write(g);
		return cryingD(n);
	}
	static int cryingD(int n) throws IOException {
		for(int i=0;i<cnt;i++) {
			bw.write("____");
		}
		bw.write(h);
		cnt--;
		if(cnt == 0) return 1;
		else return cryingD(n);
	}

}
