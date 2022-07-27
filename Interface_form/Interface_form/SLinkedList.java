package Interface_form;

import java.util.NoSuchElementException;

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

    public void add(int index, E value){ // 오버라이딩 맨~
        //범위 좀 제대로 짜라
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) { // 그냥 addFirst할것이지
            addFirst(value);
            return;
        }

        if(index == size){ // 그냥 addLast하라고!
            addLast(value);
            return;
        }

        Node<E> prev_Node = search(index-1); // 전남친 하이
        Node<E> next_Node = prev_Node.next; // 전여친 바이
        Node<E> newNode = new Node<E>(value); // 새친구 등장!

        //노드를 이쁘게 연결해주자

        prev_Node.next = null;
        prev_Node.next = newNode;
        newNode.next = next_Node;
        size++;

    }
    
    public E remove() {

        Node<E> headNode = head;

        if(headNode == null) throw new NoSuchElementException(); // 똥멍청이야!

        E element = headNode.data; // 없앤거 반환할거에욤 public E잖아 ^0^

        Node<E> nextNode = head.next;

        head.data = null;
        head.next = null;

        head = nextNode;
        size--;

        if(size==0) tail = null;

        return element;

    }

    public E remove(int index){
        //1빠를 지울거에요 (그럼 그냥 remove를 해!)
        if(index == 0) return remove();

        //범위 좀 제대로 짜라고!!
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> prevNode = search(index-1); // 전여친
        Node<E> removedNode = prevNode.next; // 전여친 찾으면 바로 나오죠? search 굳이 여러번 안하죠?
        Node<E> nextNode = removedNode.next; // 헤으응

        E element = removedNode.data; // 보여줄게 마지막 데이터

        prevNode.next = nextNode; // 환승 맨~

        if(prevNode.next == null){ // 환승할 애가 없어ㅠ
            tail = prevNode;
        }

        removedNode.next = null; // 가버렷~
        removedNode.data = null;
        size--;

        return element; // 유품

    }

    //remove(Object)의 상황. 불가능할땐(요소에 Object가 없으면) 걍 exception 띄우면 안되낭?
    public boolean remove(Object value){

        Node<E> prevNode = head;
        boolean hasValue = false;
        Node<E> x = head; // removedNode?

        for(;x!=null;x=x.next){ // 와 이렇게 for문을 쓰네?
            if(value.equals(x.data)){
                hasValue = true;
                break;
            }
            prevNode = x;
        }

        // 일치하지 않을 때 라고 설명이 되어 있는데
        if(x==null) return false; // ㅇㅅㅇ? x가 첨에 head라고 잡앗는데 null일 수 있나?
        // for문 돌면서 x.next 자꾸 조져서 결국에 없으면 아하! for문의 처리 순서 기억해!

        if(x.equals(head)){ // 대가리였으면 그냥 remove() 때려!
            remove();
            return true;
        } else {
            prevNode.next = x.next;
            if(prevNode.next == null) tail = prevNode;
            x.data = null;
            x.next = null;
            size--; // 가버렷~
            return true;
        }
        
    }

    public E get(int index){
        return search(index).data;
    } // 중괄호 잘 보자 ^^...

    public void set(int index, E value){
        Node<E> replaceNode = search(index);
        replaceNode.data = null;
        replaceNode.data = value;
    }

    public int indexOf(Object value){
        int index = 0;

        for(Node<E> x = head; x != null; x = x.next){
            if(value.equals(x.data)) return index;
            index++;
        }
        return -1; // 여기 그런사람 안살아요
    }

    public boolean contains(Object item){ // 그냥 boolean만 반환이니께~
        return indexOf(item) >=0;
    }

    public int size(){ // size 형님의 큰 그림 오늘도 배워갑니다
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        for(Node<E>x = head; x != null; ){ // ㄹㅇ 별 희안한 방법으로 for문을 다 쓰네
            Node<E> nextNode = x.next;
            x.data = null;
            x.next = null;
            x = nextNode;
        } // for마지막에 x = x.next를 넣어도 똑같지 않나? null로 잡아서 next가 안되넹 ^0^
    }     // 이때 객체 자체를 null 해주기 보다는 모든 노드를 하나 하나 null로 다 잡아줘야 GC가 알아먹...ㅠ
    

}
