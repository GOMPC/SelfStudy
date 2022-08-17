package CollectionFramework;

import java.util.ArrayList;
import java.util.List;

public class ListPractice {
    
    public static void main(String[] args) {

        BoardDao dao = new BoardDao();
        List<Board> list = dao.getBoardList();
        for(Board board : list){
            System.out.println(board.getTitle() + "-" + board.getContent());
        }
        
    }
}

class Board {
    private String title;
    private String content;

    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
}

class BoardDao{

    public List<Board> getBoardList() {
        List<Board> list = new ArrayList<>();
        list.add(new Board("T1", "C1"));
        list.add(new Board("T2", "C2"));
        list.add(new Board("T3", "C3"));
        return list;
    }

}
