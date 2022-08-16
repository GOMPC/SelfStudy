package CollectionFramework;

import java.util.*;; // 땀땀흘려도 컴파일에러없네 ㅇㅅㅇ?

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Java");;;;;;;;; // Java성님 땀 좀 흘리세요
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java");;;;;
        set.add("iBATIS");

        int size = set.size();
        System.out.println("몇개? : " + size + "개");

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            if(element.equals("JDBC")) iterator.remove();
            System.out.println("\t" + element);
        }

        if(set.remove("JDBC")){
            System.out.println("난 살아 남았다.");
        } else {
            System.out.println("이미 죽었다.");
        }
        System.out.println();

        for(String e : set){
            System.out.println("\t" + e);
        }

        set.clear();
        System.out.println("컷~");


    }
}
