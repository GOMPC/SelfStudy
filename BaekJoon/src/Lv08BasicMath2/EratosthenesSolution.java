package Lv08BasicMath2;

import java.util.ArrayList;

public class EratosthenesSolution {

    static boolean prime[] = new boolean[4000001]; //배열은 0부터 시작하니 N+1의 값
	static ArrayList<Integer> prime_numbers = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
		
		// 구하고자 하는 숫자 범위
        int N = 4000000;
        
        // 소수는 false
        // 1은 소수가 아니므로 제외
        prime[0] = prime[1] = true;
        
        for(int i=2; i*i<=N; i++){
        	// prime[i]가 소수라면
            if(!prime[i]){ // 초기값이 false니까 다 돌아버리는거야. 근데 왜 i*i까지일까? 100을 예시로 하고 11을 하면 ????? 제곱까지 다 없앤다는 의미인가? - 
            	// prime[j] 소수가 아닌 표시
            	for(int j=i*i; j<=N; j+=i) prime[j]=true; // 어차피 i*i부터 +i +i 이렇게 다 지울테니까? 어떤 미친사람이 이걸 생각하고 증명했나 ㅡㅡ
            }
        }
        
        // 소수 출력
        for(int i=1; i<=N;i++){
        	if(!prime[i]) prime_numbers.add(i);    
        }
        
        // 4000000까지 소수 개수
        System.out.println(prime_numbers.size());
        // 소수 확인 
        for(int i=1; i<=40; i++) {
        	System.out.println(prime_numbers.get(i));
        }
        
    }
    
}
