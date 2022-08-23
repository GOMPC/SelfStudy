import java.io.*;
import java.util.*;

public class Main2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		List<Member> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(stk.nextToken());
			String name = stk.nextToken();
			list.add(new Member(age, name));
		}
		
		
		
	}

}

class Member{
	int age;
	String name;
	
	Member(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	
}