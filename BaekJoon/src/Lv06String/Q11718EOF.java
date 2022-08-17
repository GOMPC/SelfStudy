package Lv06String;

import java.io.*;

public class Q11718EOF {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input;
		
		while((input=br.readLine()) != null && !input.isEmpty()){
			bw.write(input);
			bw.newLine();
		}
		bw.close();
		
	}

}
