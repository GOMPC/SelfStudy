package Lv07BasicMath1;

import java.io.*;

public class Q01193 {

    public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Function function = new Function();
		
		int a = Integer.parseInt(br.readLine());
		int i = 0;
		
		while(true) {
			i++;
			if(function.count(i) >= a)
				break;
		}
		
		int maxNum = function.count(i);
		int diff = maxNum - a;
		
		if(i%2==0) {
			bw.write( Integer.toString(i-diff)+ "/" + Integer.toString(i - (i-1) + diff));
		} else {
			bw.write( Integer.toString(i - (i-1) + diff) + "/" + Integer.toString(i-diff));
		}
		
		bw.flush();

//		1. 1/1
//		2. 1/2
//		3. 2/1
//		4. 3/1
//		5. 2/2
//		6. 1/3
//		7. 1/4
//		8. 2/3
//		9. 3/2
//		10. 4/1
//		11. 5/1
//		12. 4/2
//		13. 3/3
//		
//		1, 2, 3, 4, 등차수열. i로 몇번째인지 구하기. i+1 = (분자+분모)
			
// i%2했을때로 나눠서 정방향 역방향 조지자.
// i만큼의 크기가 있네? 이제 그 필드 안의 순서를 이쁘게 찾아보자.
// 그럼 count(i)만 구해도 되겠다. 그리고 그 차이, 거기에 슥쇽샥
    }
    
}

class Function{
	
	public int count(int n) {
		if(n==1) {
			return 1;
		} else {
			return count(n-1) + n;
		}
		
	}
}
