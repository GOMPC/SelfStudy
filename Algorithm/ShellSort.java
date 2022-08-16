public class ShellSort {
    
    private final static int[] gap = // 이것이 갭이여~ 경험상 최고의 성능을 뽑는 갭!
        { 1, 4, 10, 23, 57, 132, 301, 701, 1750, // 이거 이상으로는 걍 2.25 곱해서 ㅇㅋ?
          3937, 8858, 19930, 44842, 100894, 227011, 510774,
          1149241, 2585792, 5818032, 13090572, 29453787, 
          66271020, 149109795, 335497038, 754868335, 1698453753}; // 이거 이상은 int값 벗어나죠? Java 배열 범위 벗어나죠? 여기까지~
    
    public static void shellSort(int[] a){
        shellSort(a, a.length);
    }

    private static int getGap(int length){ // 갭을 어떤거부터 써볼까요~
        int index = 0;
        int len = (int)(length / 2.25); // 최소한 부분 배열의 원소가 2개씩은 비교되도록 나눠준다? 부분이 2개는 최소한 생기도록! 2.25로 곱하는 형식이니 2.25로 조지면 ㅅㅅ
        while(gap[index] < len){
            index++;
        }
        return index;
    }

    private static void shellSort(int[] a, int size){
        int index = getGap(size); // 첫 갭 누구니~

        for(int i = index; i >= 0; i--){ // gap[index]부터 gap[0]까지 드가자잇
            for(int j = 0; j < gap[i]; j++){ // gap으로 나뉜 친구들의 삽입띠~
                insertionSort(a, j, size, gap[i]);
            }
        }
    }

    private static void insertionSort(int[] a, int start, int size, int gap){
        
        for(int i = start + gap; i < size; i += gap){ 

            int target = a[i];
            int j = i - gap;

            while(j >= start && target < a[j]){
                a[j + gap] = a[j];
                j -= gap;
            }

            a[j + gap] = target;
        }
    }

}
