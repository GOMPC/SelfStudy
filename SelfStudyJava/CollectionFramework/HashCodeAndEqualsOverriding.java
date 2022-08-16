package CollectionFramework;

import java.util.*;

public class HashCodeAndEqualsOverriding {
    public static void main(String[] args) {
        Set<Member> set = new HashSet<>();

        set.add(new Member("GOMPC", 32));
        set.add(new Member("GOMPC", 32));

        System.out.println(set.size());
    }
}

class Member{
    public String name;
    public int age;

    public Member(String name, int age){ // 클래스는 디폴트인데 생성자는 public이 되네?
        this.name = name;
        this.age = age;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member){
            Member member = (Member) obj;
            return member.name.equals(name) && (member.age == age);
        } else return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode()/* String의 hashCode 잠깐 쓸게요~ */ + age; 
    }

}
