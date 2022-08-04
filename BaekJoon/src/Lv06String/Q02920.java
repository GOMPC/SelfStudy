package Lv06String;

import java.io.*;

public class Q02920 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		String ascending = "1 2 3 4 5 6 7 8";
		String descending = "8 7 6 5 4 3 2 1";
		
		if(s.equals(ascending)) {
			bw.write("ascending");
		} else if(s.equals(descending)){
			bw.write("descending");
		} else {
			bw.write("mixed");
		}
		
		bw.close();
		
	}

}