package Interface_form;

import Interface_form.List;

public class SLinkedList<E> implements List<E> {
    
    private Node<E> head; // 대가리
    private Node<E> tail; // 꼬다리
    private int size; // 크기

    public SLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // 특정 위치의 노드를 반환하는 메소드
    private Node<E> search(int index){

        //범위 좀 제대로 짜라
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> x = head; // 대가리부터 잡고

        for(int i=0;i<index;i++){
            x = x.next; // x 노드의 다음 노드들을 계속 x로 잡아
        }

        return x;
    }

    public void addFirst(E value){ // 왜 얘가 add중에 젤 먼저 왔을까요?

        Node<E> newNode = new Node<E>(value); // 새친구 하이!
        newNode.next = head; // 노드 연결
        head = newNode; // 대가리 지정
        size++; // 컷~

        if(head.next == null) tail = head; // 난 혼자야..
    }

    public boolean add(E value){ // 그냥 add 한놈으로 다 하면 안되나?
        addLast(value);
        return true;
    }

    public void addLast(E value){
        Node<E> newNode = new Node<E>(value); // 새 친구 하이~

        if(size==0){ // 사이즈가 0이다!
            addFirst(value);
            return;
        }

        tail.next = newNode;
        tail = newNode; // 꼬리물기
        size++;
    }
    


}
