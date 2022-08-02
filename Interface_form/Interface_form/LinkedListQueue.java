package Interface_form;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements Queue<E>, Cloneable{
    
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public boolean offer(E value) {
        Node<E> newNode = new Node<E>(value);

        if(size==0){
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail; // 양방향일 경우 추가 (내가 함)
        }

        tail = newNode;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if(size==0){
            return null;
        }

        E element = head.data;

        Node<E> nexthead = head.next;

        head.data = null;
        head.next = null;
        nexthead.prev = null; // 양방향일 경우 추가 (내가 함)

        head = nexthead;
        size--;

        return element;
    }

    public E remove(){ // remove와 poll은 같은 일을 하지만 같은 결과를 도출해도 반환방식이 서로 다르다. 왜 그럴까 찾아보도록
        E element = poll(); // java API에서 insert remove examine 각각 두가지씩 존재하고 예외 도출이 다르다.

        if(element == null){
            throw new NoSuchElementException();
        }

        return element;
    }

    @Override
    public E peek() {
        if(size==0){
            return null;
        }
        return head.data;
    }

    public E element(){
        E element = peek();

        if(element==null){
            throw new NoSuchElementException();
        }
        return element;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean contains(Object value){
        for(Node<E> x = head;x!=null;x=x.next){
            if(value.equals(x.data)){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        for(Node<E> x = head; x!=null; ){
            Node<E> next = x.next;
            x.data = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        size = 0;
        head = tail = null;
    }

    public Object[] toArray(){
        Object[] array = new Object[size];
        int idx = 0;
        for(Node<E> x = head;x!=null;x=x.next){
            array[idx++] = (E) x.data;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a){
        if(a.length < size){
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;

        Object[] result = a; // 얕복 맨
        for(Node<E> x = head; x!=null; x=x.next){
            result[i++] = x.data;
        }
        return a;
    }

    @Override
    protected Object clone() {
        
        try{
            @SuppressWarnings("unchecked")
            LinkedListQueue<E> clone = (LinkedListQueue<E>) super.clone();
            clone.head = null;
            clone.tail = null;
            clone.size = 0;

            for(Node<E> x = head; x!=null; x=x.next){
                clone.offer(x.data);
            }
            return clone;
        }
        catch(CloneNotSupportedException e){
            throw new Error(e);
        } // 그냥 super까지 안하고 새거 하나 만들어서 for문 돌려도 되지않음?
    }

    public void sort(){
        sort(null);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void sort(Comparator<? super E> c){
        Object[] a = this.toArray();
        Arrays.sort(a,(Comparator) c);

        int i = 0;
        for(Node<E> x = head; x!=null; x=x.next,i++){
            x.data = (E) a[i];
        }
    }

}
