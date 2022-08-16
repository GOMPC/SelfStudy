package CollectionFramework;

import java.util.*;

public class HashTableExample {
    public static void main(String[] args) {
        Map<String, String> map = new Hashtable<>();

        map.put("Spring", "345");
        map.put("Summer", "678");
        map.put("Fall", "91011");
        map.put("Winter", "1212");

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("ID, PW plz");
            System.out.print("ID : ");
            String id = sc.nextLine();

            System.out.print("PW : ");
            String pw = sc.nextLine();
            System.out.println();

            if(map.containsKey(id)){
                if(map.get(id).equals(pw)){
                    System.out.println("Hello");
                    break;
                } else {
                    System.out.println("Confirm your PW");
                }
            } else {
                System.out.println("Confirm your ID");
                System.out.println();
            }
        }
        sc.close();
    }
}
