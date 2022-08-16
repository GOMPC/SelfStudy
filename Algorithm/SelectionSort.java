public class SelectionSort {
    
    public static void selection_sort(int[] a){
        selection_sort(a, a.length);
    }

    private static void selection_sort(int[]a, int size){

        for(int i=0; i<size-1; i++){ // size까지 가지말고 size-1까지 가는 이유! 한바퀴라도 덜돌자!
            int minIndex = i;

            for(int j=i+1;j<size;j++){
                if(a[j] <  a[minIndex]){
                    minIndex = j; // 최소값 인덱스 어딨냐!!
                }
            }

            swap(a, minIndex, i);
        }

    }

    private static void swap(int[] a, int i, int j){ // 바꿔~
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
