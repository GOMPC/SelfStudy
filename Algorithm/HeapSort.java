public class HeapSort {
    
    private static int getParent(int child){ // 엄마 어딨어~ 힙이랑 살짝은 다르다. index 0이 있으니까!
        return (child - 1) / 2;
    }

    private static void swap(int[] a, int i, int j){ // 바꿔~
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void heapify(int[] a, int parentIdx, int lastIdx){

        int leftChildIdx = 2 * parentIdx + 1; // 첫째
        int rightChildIdx = 2 * parentIdx + 2; // 둘째
        int largestIdx = parentIdx; // 엄마

        if(leftChildIdx < lastIdx && a[largestIdx] < a[leftChildIdx]){
            largestIdx = leftChildIdx;
        }

        if(rightChildIdx < lastIdx && a[largestIdx] < a[rightChildIdx]){ // 더 큰 자식놈이 있으면 바꿔치기한다.
            largestIdx = rightChildIdx;
        }

        if(parentIdx != largestIdx){ // 같지 않다 -> 부모가 제대로 되지 않는다!
            swap(a, largestIdx, parentIdx); // 그러니 스왑~
            heapify(a, largestIdx, lastIdx); // 재귀 맨~
        }
    }

    public static void heapSort(int[] a){
        int size = a.length;

        if(size < 2){ // 요소가 0, 1, 2개면 굳이 이거 쓸 필요도 없잖아? 그리고 getParent / heapify에서 음수 나와서 망할수도 있다.
            return;
        }

        int parentIdx = getParent(size-1); // 마지막 친구의 부모!

        for(int i = parentIdx; i >= 0; i--){
            heapify(a, i, size-1); // 마지막 부모부터 쭉 하나씩 도는거야. 젤 큰놈 찾으려고 ㅇㅇ
        }

        for(int i = size - 1; i > 0; i--){
            swap(a, 0, i); // 젤 큰놈 맨뒤로 가~
            enhancedHeapify(a, 0, i-1); // 남은애들 또 뺑이치면서 계속 집어 넣어~
        }
    }

    // 근데 heapify의 마무리가 재귀 호출이라, 최악엔 트리의 깊이만큼 재귀 > StackOverFlow > 메모리 꺼억
    // 이걸 반복문으로 삭 고쳐볼까?

    private static void enhancedHeapify(int[] a, int parentIdx, int lastIdx){

        int leftChildIdx;
        int rightChildIdx;
        int largestIdx; // 엄마

        while((parentIdx * 2) + 1 <= lastIdx){ // 왼쪽 자신을 기준으로 해야합니다. 완전이진트리더라도 마지막 부모가 왼쪽만 차있을 수도 있잖아!
            leftChildIdx = (parentIdx * 2) + 1;
            rightChildIdx = (parentIdx * 2) + 2;
            largestIdx = parentIdx;

            if(a[leftChildIdx] > a[largestIdx]){
                largestIdx = leftChildIdx;
            }
            if(rightChildIdx <= lastIdx && a[rightChildIdx] > a[largestIdx]){ // 자식이 하나일 수도 있으니까 왼쪽 수식도 넣음 ㅇㅇ
                largestIdx = rightChildIdx;
            }

            if(largestIdx != parentIdx){
                swap(a, parentIdx, largestIdx);
                parentIdx = largestIdx;
            } else {
                return; // 이러면 바로 꺼지는거 아님? 실험해보자.
            }
        }
    }
}
