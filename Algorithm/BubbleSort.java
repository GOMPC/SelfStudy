public class BubbleSort {
    
    public static void bubbleSort(int[] a){
        bubbleSort(a, a.length);
    }

    private static void bubbleSort(int[] a, int size){

        for(int i=1; i<size; i++){ // 왜 1부터 하냐? 두개씩 교환하면서 바꾸니까 한번 줄일 수 있다!

            boolean swapped = false;

            for(int j=0; j<size-i; j++){ // 왜 size - i이냐? 뒤에 쭉쭉 차니까 앞쪽만 비벼보면 된다!
                if(a[j] > a[j+1]){
                    swap(a, j, j+1);
                    swapped = true; // 돌았어용~
                }
            }

            if(!swapped) break; // 안돌았으면 이미 정렬이 된거 아니겠나! 컷!

        }
        
    }

    private static void swap(int[]a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
