package Interface_form;

import java.util.Comparator;

public class test {

    public static void main(String[] args) {
    
        SLinkedList<Student> list = new SLinkedList<>();

        list.add(new Student("김자바", 100));
        list.add(new Student("이씨플", 88));
        list.add(new Student("조씨샵", 72));
        list.add(new Student("파이손", 97));

        list.sort(); // Comparator customComp를 만들어서 넘기는 방법, Student에 Comparable을 구현하는 방법.

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

    static Comparator<Student> customComp = new Comparator<Student>() {
        @Override // 내맘대로 즐겨요~
        public int compare(Student o1, Student o2){
            return o2.score - o1.score;
        }
    };
    
}

class Student implements Comparable<Student> {
    String name;
    int score;

    Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String toString(){
        return "이름 : " + name + "\t 성적 : " + score; 
    }

    @Override
    public int compareTo(Student o){
        return o.score - this.score;
    }
}
