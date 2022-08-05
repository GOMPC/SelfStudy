package Lv06String;

import java.io.*;

public class Q02941StringReplace {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		s = s.replace("dz=", "a").replace("lj", "a").replace("nj", "a").replace("=", "").replace("-", "");
		
		bw.write(Integer.toString(s.length()));
		bw.close();
		
	}

}
