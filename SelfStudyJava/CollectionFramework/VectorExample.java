package CollectionFramework;

import java.util.*;

public class VectorExample {
    public static void main(String[] args) {
        
        List<Board> list = new Vector<>();
        
        list.add(new Board("주제1", "내용1", "저자1"));
        list.add(new Board("주제2", "내용2", "저자2"));
        list.add(new Board("주제3", "내용3", "저자3"));
        list.add(new Board("주제4", "내용4", "저자4"));
        list.add(new Board("주제5", "내용5", "저자5"));

        list.remove(2);
        list.remove(3);

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        
    }
}

class Board{
    String subject;
    String content;
    String writer;

    public Board(String subject, String content, String writer){
        this.subject = subject;
        this.content = content;
        this.writer = writer;
    }

    @Override
    public String toString() {
        return subject + " " + content + " " + writer;
    }
}
