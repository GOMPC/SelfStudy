package CollectionFramework;

import java.util.*;

public class HashMapExample2 {
    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<>();

        map.put(new Student(1, "KINGPC"), 100);
        map.put(new Student(1, "KINGPC"), 99);

        System.out.println(map.size()); // 호에에엥?
        Set<Student> keySet = map.keySet();
        Iterator<Student> iterator = keySet.iterator();
        while(iterator.hasNext()){
            Student key = iterator.next();
            int value = map.get(key);
            System.out.println("몇점일까요? " + value + "점입니다!");
        }
    }
    
}

class Student{
    public int num;
    public String name;

    public Student(int num, String name){
        this.num = num;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student){
            Student student = (Student) obj;
            return (num == student.num) && name.equals(student.name);
        } else return false;
    }

    @Override
    public int hashCode() {
        return num + name.hashCode();
    }

}