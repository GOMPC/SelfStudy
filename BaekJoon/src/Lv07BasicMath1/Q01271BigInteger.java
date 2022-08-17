package Lv07BasicMath1;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q01271BigInteger {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());

		BigInteger money = new BigInteger(stk.nextToken());
		BigInteger intel = new BigInteger(stk.nextToken());
		
		String s = money.divide(intel).toString();
		System.out.println(s);
		s = money.remainder(intel).toString();
		System.out.println(s);
		
	}

}
