import Interface_form.ArrayList;

public class PrimeNumber {

    public static void main(String[] args) {
        
        int N = 4000000; // N까지 한번 구해보자!

        boolean[] prime = new boolean[N+1]; // 0부터 N까지
        ArrayList<Integer> prime_numbers = new ArrayList<>(); // 소수 한번 담아보까

        prime[0] = prime[1] = true;

        for(int i = 2; i * i <= N; i++){ // 제곱근까지만 돌자!
            if(prime[i]) continue;
            else{
                for(int j = i * i; j <= N; j += i){ // 제곱부터 배수를 샥샥 더해가면서 컷!
                    prime[j] = true;
                }
            }
        }

        for(int i=0;i<prime.length;i++){
            if(!prime[i]) prime_numbers.add(i);
        }

        int count = prime_numbers.size(); // 소수의 개수
        for(int i=0;i<count;i++){
            System.out.print(prime_numbers.get(i) + " "); // 한번 뽑아보까~
        }


    }
    
}


