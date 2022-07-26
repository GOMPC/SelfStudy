package Interface_form;

public class Node<E> {
    
    E data;
    Node<E> next; // 다음 노드객체를 가리키는 레퍼런스 변수
                  // 노드 객체를 가리켜야 하니 Node<E> 타입 ㅇㅋ?
    Node(E data) {
        this.data = data;
        this.next = null; 
    }
}
