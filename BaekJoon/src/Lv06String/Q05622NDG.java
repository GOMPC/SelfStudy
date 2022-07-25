package Lv06String;

import java.io.*;

public class Q05622NDG {

    public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		String[] strArr = s.split("");
		int runtime = 0;
		
		for(String e : strArr) {
			if(e.equals("A")|e.equals("B")|e.equals("C")) {
				runtime += 3;
			} else if(e.equals("D")|e.equals("E")|e.equals("F")) {
				runtime += 4;
			} else if(e.equals("G")|e.equals("H")|e.equals("I")) {
				runtime += 5;
			} else if(e.equals("J")|e.equals("K")|e.equals("L")) {
				runtime += 6;
			} else if(e.equals("M")|e.equals("N")|e.equals("O")) {
				runtime += 7;
			} else if(e.equals("P")|e.equals("Q")|e.equals("R")|e.equals("S")) {
				runtime += 8;
			} else if(e.equals("T")|e.equals("U")|e.equals("V")) {
				runtime += 9;
			} else {
				runtime += 10;
			} 
			
		}
		bw.write(Integer.toString(runtime));
		bw.flush();

    }
    
}
