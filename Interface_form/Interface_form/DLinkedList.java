package Interface_form;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

import Interface_form.List;

public class DLinkedList<E> implements List<E> {

    private Node<E> head; // 대가리
    private Node<E> tail; // 꼬랑지
    private int size; // 큰그림 형님
    
    public DLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private Node<E> search(int index){
        // 서치부터 시작하네?

        if(index < 0 || index >= size){ // 이건 중복 어케 좀 못줄이나
            throw new IndexOutOfBoundsException();
        }

        if(index > size/2){ // 꼬리부터 드가자~
            Node<E> x = tail;
            for(int i=size-1;i>index;i--){
                x = x.prev;
            }
            return x;
        } else {
            Node<E> x = head;
            for(int i=0;i<index;i++){
                x = x.next;
            }
            return x;
        }
    }

    public void addFirst(E value){
        Node<E> newNode = new Node<E>(value);
        newNode.next = head; // 이젠 익숙하지?

        if(head!=null){ // 대가리가 없는 경우도 있어~ head가 null인데 head.prev가 있을 수가 없잖아~
            head.prev = newNode;
        }

        head = newNode;
        size++;

        if(head.next == null){ // 이건 굳이 왜 넣는걸까? 잘 생각해보렴?
            tail = head;
        }
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value){
        Node<E> newNode = new Node<E>(value); // 선수 입장~

        if(size==0){ // 마수걸이 입장~
            addFirst(value);
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public void add(int index, E value){

        // 잘못된 인덱스 좀 그만 넣어!
        if(index > size || index <0){
            throw new IndexOutOfBoundsException();
        }

        // 이럴거면 addFirst를 해
        if(index==0){
            addFirst(value);
            return;
        }

        if(index==size){
            addLast(value);
            return;
        }

        Node<E> prev_Node = search(index-1); //for문 하나라도 덜돌려~
        Node<E> next_Node = prev_Node.next;
        Node<E> newNode = new Node<E>(value);

        prev_Node.next = null;
        next_Node.prev = null; // 바로 이해 못할까봐 명시적으로 한번 더 넣어드렸습니다^^

        prev_Node.next = newNode;
        newNode.prev = prev_Node;
        newNode.next = next_Node;
        next_Node.prev = newNode;
        size++;
    }

    public E remove() {
        Node<E> headNode = head;

        if(headNode == null){ // 멍청아
            throw new NoSuchElementException();
        }

        E element = headNode.data; // 마지막 잎새

        Node<E> nextNode = head.next;

        head.data = null;
        head.next = null; // 대가리니까 prev는 없어요~

        if(nextNode != null){ // 이 조건이 왜 생겼는지 고민해보세요. 이유가 있으니까 만든거 아니갓어?
            nextNode.prev = null;
        }

        head = nextNode;
        size--;

        if(size==0){
            tail = null;
        }

        return element;
    }

    @Override
    public E remove(int index) {

        if(index >= size || index <0){ // 제발..
            throw new IndexOutOfBoundsException();
        }

        if(index==0){ // 변태들아 그냥 remove()를 해
            E element = head.data;
            remove();
            return element;
        }

        Node<E> prevNode = search(index-1); // 한바퀴라도 줄이자
        Node<E> removedNode = prevNode.next;
        Node<E> nextNode = removedNode.next;

        E element = removedNode.data; // 잎새 맨~

        prevNode.next = null; // 가버렷~
        removedNode.prev = null;
        removedNode.next = null;
        removedNode.data = null;
        // nextNode.prev = null; 이건 왜 여기서 안할까요?

        if(nextNode != null){ // 왜 여기서 굳이 검사까지 할까요? 이정도면 다알려줌
            nextNode.prev = null;

            nextNode.prev = prevNode;
            prevNode.next = nextNode;
        } else {
            tail = prevNode;
        }

        size--;

        return element;
    }

    @Override
    public boolean remove(Object value) {
        Node<E> prevNode = head;
        Node<E> x = head; // removedNode

        for(; x!=null; x=x.next){
            if(value.equals(x.data)){
                break;
            }
            prevNode = x; // 이건 무슨뜻일까? 반복문은 어떤 순서로 돌지?
        }

        if(x==null){ // 그거 엄서용 ㅠ.ㅠ
            return false;
        }

        if(x.equals(head)){ // 이건 인정해준다 ㅡㅡ
            remove();
            return true;
        } else {
            Node<E> nextNode = x.next;

            prevNode.next = null;
            x.data = null;
            x.next = null;
            x.prev = null; // 잘가~

            if(nextNode != null){
                nextNode.prev = null;

                nextNode.prev = prevNode;
                prevNode.next = nextNode;
            } else {
                tail = prevNode;
            }

            size--;
            return true;
        }

    }

    @Override
    public E get(int index){
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {
        Node<E> replaceNode = search(index);
        replaceNode.data = null; // 잘 이해하도록 한번 그냥 써줬어^^
        replaceNode.data = value;
    }

    // 그냥 함수 파라미터로 index를 받을 경우 알아서 예외 던져주게 해주는
    // 메소드 만들면 안되나 ㅡㅡ 중복 빡쳐

    @Override
    public int indexOf(Object o) {
        int index = 0;

        for(Node<E> x = head; x != null; x = x.next){
            if(o.equals(x.data)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object o){ // 이 친구는 꼬리도 있다구~
        int index = size; // 여기서 의아할 수 있지만

        for(Node<E> x = tail; x != null; x = x.prev){
            index--; // 여기서 선제적으로 빼버렷어용 ><
            if(o.equals(x.data)){
                return index;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object item) {
        return indexOf(item) >= 0; // 날먹 개꿀 그냥 타입만 boolean 개꿀
    }

    @Override
    public int size() { // 빅픽쳐형님 오늘도 등장
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for(Node<E> x = head; x != null;){ // 왜 3번째 추가식이 없을까요~ 하하 호호 히히 
            Node<E> nextNode = x.next; // x.next도 컷 해버리기 때문이죠~ 그러니 미리 여기서 잡아부려
            x.data = null;
            x.next = null;
            x.prev = null;
            x = nextNode;
        }
        head = tail = null;
        size = 0;
    }

    public Object clone() throws CloneNotSupportedException{

        @SuppressWarnings("unchecked")
        //엄마 잘쓸게~
        DLinkedList<? super E> clone = (DLinkedList<? super E>) super.clone();

        clone.head = null;
        clone.tail = null;
        clone.size = 0;

        for(Node<E> x = head; x != null; x = x.next){
            clone.addLast(x.data); // size는 알아서 키워줍니다 ^0^
        }

        return clone;
    }

    // toArray() 쓰기 전, 이게 어떻게 이렇게 되는건지 SLinked를 떠올리며 다시 생각해봅시다.
    public Object[] toArray(){
        Object[] array = new Object[size];
        int idx = 0;
        for(Node<E> x = head; x != null; x = x.next){
            array[idx++] = (E) x.data; // E라고 강제타입변환 굳이? 어차피 E타입 아니냐
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a){
        if(a.length < size){
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }   // Array.newInstance(컴포넌트 타입, 생성할 크기)
        int i = 0;
        Object[] result = a;
        for(Node<E> x = head; x != null; x=x.next){
            result[i++] = x.data; // 왜 a에 바로 안집어넣고 result로 한번 조졌을까요? 하하
        }
        return a;
    }
    
    // sort()하기 전, 또 복습타임. Comparable 구현하고 compareTo가 있느냐, 아니면 Comparator를 넘겨주느냐!
    public void sort(){
        sort(null); // 카운터 말고 저쪽 키오스크에서 주문해주세요 고갱님~
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void sort(Comparator<? super E> c){
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);

        int i = 0;
        for(Node<E> x = head; x != null; x = x.next, i++){
            x.data = (E) a[i];
        }
    }

}
