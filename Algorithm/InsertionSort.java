public class InsertionSort {
    
    public static void insertionSort(int[] a){
        insertionSort(a, a.length);
    }

    private static void insertionSort(int[] a, int size){

        for(int i=1; i<size; i++){ // 앞에꺼랑 비교할거니까 1부터 시작!

            int target = a[i]; // 타겟~ 등장!

            int j = i-1;

            while(j >= 0 && target < a[j]){ // 타겟이 작니?
                a[j+1] = a[j]; // 한칸씩 뒤로 가!
                j--; // 쭉쭉 드가자~
            }

            a[j+1] = target; // 이제 while 탈출했으니 target은 a[j]보다 같거나 크잖아? 뒤에 서렴^^
        }
    }
    
}
