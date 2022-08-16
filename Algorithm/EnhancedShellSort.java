public class EnhancedShellSort {
    
    private static final int[] gap = // 왜 전부 이름 똑같이 해도 되냐? 중복되냐? 뭐지?
        {1, 4, 10, 23, 57, 132, 301, 701, 1750,
            3937, 8858, 19930, 44842, 100894, 227011, 510774,
            1149241, 2585792, 5818032, 13090572, 29453787, 
            66271020, 149109795, 335497038, 754868335, 1698453753};

    public static void shellSort(int[] a){ // 얘네들이야 뭐 
        shellSort(a, a.length);
    }

    private static int getGap(int length){
        int index = 0;
        int len = (int)(length / 2.25);
        while(gap[index] < len){
            index++;
        }
        return index;
    }

    private static void shellSort(int[] a, int size){
        int gapIndex = getGap(size);

        while(gapIndex >= 0){ // gap의 끝까지 달려~
            int step = gap[gapIndex--]; // 현재 gap

            for(int i=step;i<size;i++){
                for(int j=i;j>=step && a[j] < a[j-step];j-=step){
                    swap(a, j, j-step);
                }
            }
        }
    }

    private static void swap(int[] a, int i, int j){
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
