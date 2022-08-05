package JavaLangPackage;

import java.util.HashMap;

public class KeyEx {
    
    public static void main(String[] args) {
        
        HashMap<Key, String> hashMap = new HashMap<>();

        hashMap.put(new Key(1), "KINGPC");

        String value = hashMap.get(new Key(1));

        System.out.println(value);

    }

}
