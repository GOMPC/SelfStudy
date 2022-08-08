package Week2;

public class ArrayAlignFromSelect { // 선택정렬
    
    public static void main(String[] args) {

        int[] arr = {9, 4, 3, 10, 5, 8, 7, 6, 2, 1};
        int tmp = 0;
        int min;

        for (int i = 0; i<arr.length; i++) {
            min = i;
            for (int j = i; j<arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        for(int i : arr) System.out.print(i + " ");
    }
    
    //버블 정렬은 그 머냐 for문 돌아서 비교연산자로 쓰르르륵 하는 것.
    //O(N^2)
}
