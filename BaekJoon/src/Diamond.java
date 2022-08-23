import java.io.*;
import java.util.*;

public class Diamond {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int k = Integer.parseInt(br.readLine());
		
		// 제곱ㄴㄴ수 = 1을 제외한 제곱수로 나뉘어지지 않는 수
		// k가 주어지면 k번째 제곱ㄴㄴ수 출력.
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=1; i<Integer.MAX_VALUE; i++) {
			
		}
		
		bw.write(Integer.toString(list.get(k-1)));
		bw.close();
	}

}