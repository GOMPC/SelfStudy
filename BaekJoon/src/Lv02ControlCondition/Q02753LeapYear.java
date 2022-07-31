package Lv02ControlCondition;

import java.util.*;

public class Q02753LeapYear {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		sc.close();
		
		if(A%4==0 && A%100!=0) {
			System.out.println("1");
		} else if(A%400==0) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}
}
