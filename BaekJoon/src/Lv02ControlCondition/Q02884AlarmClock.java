package Lv02ControlCondition;

import java.util.Scanner;

public class Q02884AlarmClock {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int M = sc.nextInt();
		sc.close();
		int MinuteTime = H*60 + M;
		int WakeTime = MinuteTime - 45;
		int Wh = WakeTime/60;
		int Wm = WakeTime%60;
		
		if(Wh==0 && Wm<0) {
			Wh += 23;
			Wm += 60;
		}
		
		System.out.println(Wh);
		System.out.println(Wm);
		

	}
}
