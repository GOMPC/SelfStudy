package CollectionFramework;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("GOMPC", 99);
        map.put("KINGPC", 100);
        map.put("egoing", 77);
        map.put("신용권", 88);
        System.out.println("몇개? " + map.size() + "개");

        System.out.println("\tKINGPC의 점수는 ? " + map.get("KINGPC"));
        System.out.println();

        Set<String> keySet = map.keySet(); // 키를 쭉 뽑아서
        Iterator<String> keyIterator = keySet.iterator(); // 반복자로 드가자~
        while(keyIterator.hasNext()){
            String key = keyIterator.next();
            Integer value = map.get(key);
            System.out.println("\t" + key + " : " + value);
        }
        System.out.println();

        map.remove("신용권");
        System.out.println("몇개? " + map.size() + "개");

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet(); // 와 이거 첨인데 신기하네! String Integer를 담는 Entry를 감싼 Set?
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();

        while(entryIterator.hasNext()){
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("\t" + key + " : " + value); // 그냥 반복자는 위에 방법이 그나마 편할듯 ㅇㅅㅇ.. 꺼내는것도 넣는것도 다 더 번거롭네
        }
        System.out.println();

        map.clear(); // 마무리!


    }
}
