package CollectionFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapPractice {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        
        map.put("blue", 96);
        map.put("hong", 86);
        map.put("white", 92);

        String name = null;
        int max = 0;
        int sum = 0;

        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()){
            String key = keyIterator.next();
            int score = map.get(key);
            sum += score;
            if(score > max) {
                max = score;
                name = key;
            }
        }

        System.out.println("Avg : " + (int)(sum / 3.0));
        System.out.println("High : " + max);
        System.out.println("ID : " + name);
    }
}
