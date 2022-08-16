package CollectionFramework;

import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();

        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            list1.add(0, String.valueOf(i)); // 일부러 인덱스 0에 집어넣어서 순서대로 안넣고 ArrayList 빡치게 만듬 ㅎ
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList 걸린 시간 : " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            list2.add(0, String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.currentTimeMillis();
        System.out.println("LinkedList 걸린 시간 : " + (endTime - startTime));

    }
    
}
