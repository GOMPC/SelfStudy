package Interface_form;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Queue<E>, Cloneable {
    
    private static final int DEFAULT_CAPACITY = 64; // 하이

    private Object[] array;
    private int size;

    private int front; // 여기 빈공간이여요?
    private int rear;

    public ArrayDeque(){
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayDeque(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    private void resize(int newCapacity){

        int arrayCapacity = array.length;

        Object[] newArray = new Object[newCapacity];

        for(int i=1,j=front+1;i<=size;i++,j++){
            newArray[i] = array[j%arrayCapacity]; // 알지? 모르면 Queue보고와
        }

        this.array = null;
        this.array = newArray;

        front = 0;
        rear = size;
    }

    @Override
    public boolean offer(E item) {
        return offerLast(item);
    }

    public boolean offerLast(E item){
        if((rear+1)%array.length == front){ // 만나면 안되요~
            resize(array.length*2);
        }

        rear = (rear+1) % array.length;

        array[rear] = item;
        size++;

        return true;
    }

    public boolean offerFirst(E item){
        if((front - 1 + array.length) % array.length == rear){
            resize(array.length*2);
        }
        // front가 0일 경우 -1하면 조지기 때문에 차피 array.length로 나누니께 front-1+arraylength 해도 arraylength로 나눈 값은 같다.
        array[front] = item;
        front = (front - 1 + array.length) % array.length; 
        size++;

        return true;
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    public E pollFirst(){
        if(size == 0){
            return null;
        }

        front = (front+1) % array.length;

        @SuppressWarnings("unchecked")
        E item = (E) array[front]; // 유품
        array[front] = null; // 가버렷
        size--;

        if(array.length>DEFAULT_CAPACITY && size < (array.length / 4)){
            resize(Math.max(DEFAULT_CAPACITY, array.length/2));
        }

        return item;
    }

    public E remove(){
        return removeFirst();
    }

    public E removeFirst(){
        E item = pollFirst();

        if(item==null){
            throw new NoSuchElementException();
        }

        return item;
    }

    public E pollLast(){
        if(size == 0){
            return null;
        }

        @SuppressWarnings("unchecked")
        E item = (E) array[rear];
        array[rear] = null;
        rear = (rear - 1 + array.length) % array.length;
        size--;

        if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)){
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

        return item;
    }

    public E removeLast(){
        E item = pollLast();

        if(item == null){
            throw new NoSuchElementException();
        }

        return item;
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    public E peekFirst(){
        if(size == 0){
            return null;
        }

        @SuppressWarnings("unchecked")
        E item = (E) array[(front+1)%array.length];
        return item;
    }

    public E peekLast(){
        if(size==0){
            return null;
        }

        @SuppressWarnings("unchecked")
        E item = (E) array[rear];
        return item;
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
        int start = (front + 1) % array.length;

        for(int i=0,idx=start; i<size; i++, idx = (idx+1)%array.length){
            if(array[idx].equals(value)){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        for(int i=0;i<array.length;i++){
            array[i] = null;
        }

        front = rear = size = 0;
    }

    public Object[] toArray(){
        return toArray(new Object[size]);
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a){

        final T[] res;

        if(a.length < size){
            if(front<=rear){
                return (T[]) Arrays.copyOfRange(array, front+1, rear+1, a.getClass());
            }
            

            res = (T[]) Arrays.copyOfRange(array, 0, size, a.getClass());
            int rearlength = array.length - 1 - front;

            if(rearlength > 0) {
                System.arraycopy(array, front+1, res, 0, rearlength);
            }

            System.arraycopy(array, 0, res, rearlength, rear+1);

            return res; // final인데 어케 수정하냐? 초기값을 안잡아서 여기서 잡는 느낌?
        }

        if(front<=rear){
            System.arraycopy(array, front+1, a, 0, size);
        } else {
            int rearlength = array.length - 1 - front;

            if(rearlength > 0){ // 왜 0보다 커야할까요~
                System.arraycopy(array, front+1, a, 0, rearlength);
            }

            System.arraycopy(array, 0, a, rearlength, rear+1);
        }

        return a;

    }

    @Override
    protected Object clone() {
        
        try{
            @SuppressWarnings("unchecked")
            ArrayDeque<E> clone = (ArrayDeque<E>) super.clone();

            clone.array = Arrays.copyOf(array, array.length);
            return clone;
        }
        catch(CloneNotSupportedException e){
            throw new Error(e);
        }
    }

    public void sort(){
        sort(null);
    }

    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super E> c){
        Object[] res = toArray(); // null 접근 방지를 위해 toArray로 요소만 있는 배열을 얻어 정렬 후 덮어씌움

        Arrays.sort((E[]) res, 0, size, c); // 0부터 이쁘게 정렬하고

        clear();
        // front를 비워야 하니 1번째 인덱스부터 다시 ^0^
        System.arraycopy(res, 0, array, 1, res.length);

        this.rear = this.size = res.length;
    }
    
}
