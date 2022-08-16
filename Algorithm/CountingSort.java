public class CountingSort {
    public static void main(String[] args) {
        

        int[] array = new int[100]; // 100개 정렬 함 해보까?
        int[] counting = new int[31]; // 0~30까지 숫자!
        int[] result = new int[100]; // 드가자~

        for(int i=0;i<array.length;i++){
            array[i] = (int)(Math.random()*31); // 올만이야 랜덤
        }

        // 1단계
        for(int i=0;i<array.length;i++){
            counting[array[i]]++; // 실제로 종종 써봤을 법한 방법
        }

        // 2단계
        for(int i=1;i<counting.length;i++){
            counting[i] += counting[i-1]; // 인덱스 값 알아내버리기~
        }

        // 3단계
        for(int i=array.length-1;i>=0;i--){
            int value = array[i]; // 왜 역순으로 돌까? 정순으로 한번 돌려봐?
            counting[value]--; // 1뺀값을 집어 넣기 위해! 모르겠다면 다시 복습해라
            result[counting[value]] = value;
        }
        // 이게 끝!

        // 원래 랜덤맨
        System.out.println("array[]");
        for(int i=0;i<array.length;i++){
            if(i%10 == 0) System.out.println(); // 줄바꿈 맨~
            System.out.print(array[i] + "\t"); // 이스케이프도 큰따 안에 넣어야하네? escape니까!
        }
        System.out.println("\n\n");

        // 카운팅 맨
        System.out.println("counting[]");
        for(int i=0;i<counting.length;i++){
            if(i%10==0)System.out.println();
            System.out.print(counting[i] + "\t");
        }
        System.out.println("\n\n");

        // 정렬 맨
        System.out.println("result[]");
        for(int i=0;i<result.length;i++){
            if(i%10==0) System.out.println();
            System.out.print(result[i] + "\t");
        }
        System.out.println("\n\n");


        // 스겜을 위한 방법?!
        int[] arr = new int[101]; // 수 범위만큼 맹글어

        for(int i=0; i<50; i++){ // 50개짜리 배열이엇네?
            arr[(int)(Math.random()*101)]++; // 드가자~
        }

        for(int i=0;i<arr.length;i++){
            while(arr[i]-- > 0){
                System.out.print(i + " "); // 카운팅 된거 나오자~
            }
        }

    }
}
