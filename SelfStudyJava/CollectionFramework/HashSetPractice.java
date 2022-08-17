package CollectionFramework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetPractice {
    
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        
        set.add(new Student(1, "GOMPC"));
        set.add(new Student(2, "KINGPC"));
        set.add(new Student(1, "신용권"));

        Iterator<Student> iterator = set.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            System.out.println(student.studentNum + " : " + student.name);
        }
    }
}

class Student{
    public int studentNum;
    public String name;

    public Student(int studentNum, String name){
        this.studentNum = studentNum;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.studentNum;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student){
            Student student = (Student) obj;
            return this.studentNum == student.studentNum;
        } else return false;
    }
}