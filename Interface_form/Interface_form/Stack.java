package Interface_form;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E> {

    private static final int DEFAULT_CAPACITY = 10; // 디폴트!
    private static final Object[] EMPTY_ARRAY = {}; // 빈 배열

    private Object[] array; // 배열띠 리하이
    private int size; // 빅픽처 형님

    // 생성자. 크기 선언 X
    public Stack(){
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    public Stack(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize(){

        if(Arrays.equals(array, EMPTY_ARRAY)){ // 집 비었니? ( capacity = 0 )
            array = new Object[DEFAULT_CAPACITY]; // 기숙사로 가~
            return;
        }

        int arrayCapacity = array.length;

        if(size == arrayCapacity){ // 꽉찼니?
            int newSize = arrayCapacity * 2;
            array = Arrays.copyOf(array, newSize);
            return;
        }

        if(size < (arrayCapacity / 2)){ // 왜 안쓰니?
            int newCapacity = arrayCapacity / 2;
                                        // 둘중에 더 큰거로 ㅇㅇ DEFAULT_CAPACITY보다 작은 방은 시러잉
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
            return;
        }

    }

    @Override
    public E push(E item) {
        
        if(size==array.length){
            resize();
        }
        array[size] = item;
        size++;

        return item;
    }

    @Override
    public E pop() {
        
        if(size==0) { // 정신차려!
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        E obj = (E) array[size-1]; // 잘가라
        array[size-1] = null;

        size--;
        resize();

        return obj;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        if(size==0){ // 정신차리라고!
            throw new EmptyStackException();
        }

        return (E) array[size-1];
    }

    @Override
    public int search(Object value) {
        
        for(int idx = size - 1; idx>-1;idx--){
            if(array[idx].equals(value)){
                return size - idx;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        
        for(int i=0;i<size;i++){
            array[i] = null; // 명시적으로 컷~
        }
        size = 0;
        resize(); // 딴돈의 반만 가져가
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        
        // 새로운 스택 객체 생성
        Stack<?> cloneStack = (Stack<?>) super.clone();

        // 새로운 스택의 배열도 만드러잇~ 얕복 멈춰!
        cloneStack.array = new Object[size];

        // 복사 드가자~
        System.arraycopy(array, 0, cloneStack.array, 0, size);
        return cloneStack;
    }

    public Object[] toArray(){
        return Arrays.copyOf(array, size);
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a){
        if(a.length<size){
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        }
        
        System.arraycopy(array, 0, a, 0, size);

        return a;
    }

    public void sort(){
        sort(null);
    }

    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super E> c){
        Arrays.sort((E[]) array, 0, size, c);
    }

    
}
