package Interface_form;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class LinkedListDeque<E> implements Queue<E>, Cloneable {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedListDeque(){
        head = null;
        tail = null;
        size = 0;
    }

    public boolean offerFirst(E value){
        Node<E> newNode = new Node<E>(value);
        newNode.next = head;

        if(head!=null){
            head.prev = newNode;
        }

        head = newNode;
        size++;

        if(head.next==null){
            tail = head;
        }
        return true;
    }

    @Override
    public boolean offer(E value) {
        return offerLast(value);
    }

    public boolean offerLast(E value){
        if(size==0){
            return offerFirst(value);
        }

        Node<E> newNode = new Node<E>(value);

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;

        return true;
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    public E pollFirst(){
        if(size==0){
            return null;
        }

        E element = head.data;

        Node<E> nextNode = head.next;

        head.data = null;
        head.next = null;

        if(nextNode!=null){
            nextNode.prev = null;
        }

        head = null;
        head = nextNode;
        size--;

        if(size==0){
            tail = null;
        }

        return element;
    }

    public E remove(){
        return removeFirst();
    }

    public E removeFirst(){
        E element = poll();

        if(element == null){
            throw new NoSuchElementException();
        }
        return element;
    }

    public E pollLast(){
        if(size==0){
            return null;
        }

        E element = tail.data;

        Node<E> prevNode = tail.prev;

        tail.data = null;
        tail.prev = null;

        if(prevNode!=null){
            prevNode.next = null;
        }

        tail = null;
        tail = prevNode;

        size--;

        if(size==0){
            head = null;
        }
        return element;
    }

    public E removeLast(){
        E element = pollLast();

        if(element == null){
            throw new NoSuchElementException();
        }

        return element;
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    public E peekFirst(){
        if(size == 0){
            return null;
        }

        return head.data;
    }

    public E peekLast(){
        if(size==0){
            return null;
        }

        return tail.data;
    }

    public E element(){
        return getFirst();
    }

    public E getFirst(){
        E item = peek();

        if(item == null){
            throw new NoSuchElementException();
        }
        return item;
    }

    public E getLast(){
        E item = peekLast();

        if(item == null){
            throw new NoSuchElementException();
        }
        return item;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean contains(Object value){
        for(Node<E> x = head; x!=null; x=x.next){
            if(value.equals(x.data)){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        for(Node<E> x = head; x!=null;){
            Node<E> next = x.next; // 복습 하이

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
        for(Node<E> x = head; x!=null; x=x.next){
            array[idx++] = (E) x.data;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a){
        if(a.length<size){
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int i = 0;
        Object[] result = a;
        for(Node<E> x = head; x!=null;x=x.next){
            result[i++] = x.data;
        }
        return a;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        @SuppressWarnings("unchecked")
        LinkedListDeque<E> clone = (LinkedListDeque<E>) super.clone();
        clone.head = null;
        clone.tail = null;
        clone.size = 0;

        for(Node<E> x = head; x!=null; x=x.next){
            clone.offerLast(x.data);
        }
        return clone;

    }

    public void sort(){
        sort(null);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public void sort(Comparator<? super E> c){
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);

        int i = 0;
        for(Node<E> x = head; x!=null; x=x.next, i++){
            x.data = (E) a[i];
        }
    }
}
