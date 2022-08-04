package Interface_form;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
    
    private final Comparator<? super E> comparator; // 기본타입 말고 다른애들도 받아부려~
    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private Object[] array;

    public Heap(){
        this(null);
    }

    public Heap(Comparator<? super E> comparator){
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    public Heap(int capacity){
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator){
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    private int getParent(int index){ // 엄마~
        return index/2;
    }

    private int getLeftChild(int index){ // 첫째야~
        return index*2;
    }

    private int getRightChild(int index){ // 둘째야~
        return index*2 + 1;
    }

    private void resize(int newCapacity){
        Object[] newArray = new Object[newCapacity];

        for(int i=1;i<=size;i++){ // 왜 1부터일까요?
            newArray[i] = array[i];
        }

        this.array = null;
        this.array = newArray;
    }

    public void add(E value){
        if(size+1 == array.length){
            resize(array.length*2);
        }

        siftUp(size+1, value); // 일단 들어가세요~
        size++;
    }

    private void siftUp(int idx, E target){
        if(comparator != null){
            siftUpComparator(idx, target, comparator);
        } else {
            siftUpComparable(idx, target);
        }
    }

    @SuppressWarnings("unchecked") // Comparator가 있어요~
    private void siftUpComparator(int idx, E target, Comparator<? super E> comp){
        
        while(idx>1){ // 조상님한테까지는 안감(Why?)
            int parant = getParent(idx); // 엄마~
            Object parentVal = array[parant]; // ㅇㅇ?

            if(comp.compare(target, (E) parentVal) >= 0){ // 컷~
                break;
            }

            array[idx] = parentVal;
            idx = parant;
        }

        array[idx] = target;
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int idx, E target){
        // 여기서 왜 comp를 따로 빼 둘까요? 헤헤
        Comparable<? super E> comp = (Comparable<? super E>) target;

        while(idx>1){
            int parent = getParent(idx);
            Object parentVal = array[parent];

            if(comp.compareTo((E)parentVal) >= 0){
                break;
            }
            array[idx] = parentVal;
            idx = parent;
        }
        array[idx] = comp;
    } // 최대 힙을 구하고 싶다면 compare(To) 비교연산자를 <=로 바꿔주면 끗

    @SuppressWarnings("unchecked")
    public E remove(){
        if(array[1]==null){ // 이게 무슨 일이야~
            throw new NoSuchElementException();
        }

        E result = (E) array[1]; // 대가리를 컷하는데
        E target = (E) array[size]; // 꼬다리를 대가리에 꽂아서 내릴거임
        array[size] = null; // ㅇㅋ?

        siftDown(1, target); // 대가리 자리로 꽂아버려~

        return result;
    }

    private void siftDown(int idx, E target){
        if(comparator != null){
            siftDownComparator(idx, target, comparator);
        } else {
            siftDownComparable(idx, target);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparator(int idx, E target, Comparator<? super E> comp){
        
        array[idx] = null;
        size--;

        int parent = idx;
        int child; // 첫째야~

        while((child = getLeftChild(parent)) <= size){ // 선넘지마
            int right = getRightChild(parent); // 둘째야~

            Object childVal = array[child]; // 첫째띠~

            if(right <= size && comp.compare((E) childVal, (E) array[right]) > 0){ // 어떤 방식으로 내려가는지를 이해할 것. 왼쪽이 더 크다고 왼쪽이랑 오른쪽을 바꾸는게 아니다.
                child = right;
                childVal = array[child]; // 뇌가 뻑뻑하다... 왼쪽 값이 크면 큰거로 바꿔치기하면 안되니까 작은쪽 값으로 바꾼다는거임 ㅇㅋ?
            }

            if(comp.compare(target, (E) childVal) <= 0){ // 여기선 다 작으니까 컷~ 하는거고 ㅇㅇ
                break;
            }

            array[parent] = childVal; // 그래서 왼쪽이 작으면 그냥 이러면 되고 오른쪽이 작아도 바꾼걸로 내려감 ㅇㅋ?
            parent = child;
        }

        array[parent] = target;

        if(array.length > DEFAULT_CAPACITY && size < array.length / 4){
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int idx, E target){

        Comparable<? super E> comp = (Comparable<? super E>) target;

        array[idx] = null;
        size--;

        int parent = idx;
        int child;

        while((child = getLeftChild(parent)) <= size){

            int right = getRightChild(parent);

            Object childVal = array[child]; // 일단 왼쪽 값으로 담아주고

            if(right <= size && ((Comparable<? super E>) childVal).compareTo((E)array[right]) > 0){ // 왼쪽이 더 크면
                child = right;
                childVal = array[child]; // 오른쪽걸로 바꿔치기하고 = 그럼 둘중 작은 값이 childVal잖아
            }

            if(comp.compareTo((E) childVal) <= 0){ // 컷되면 끝내는거고
                break;
            }
            array[parent] = childVal; // 안되면 작은값으로 바꿔치기 해버렷~
            parent = child; // 더 내려가~ while while 맨~
        }
        array[parent] = comp;

        if(array.length > DEFAULT_CAPACITY && size < array.length / 4){
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }
    }

    public int size(){
        return this.size;
    }

    @SuppressWarnings("unchecked")
    public E peek(){
        if(array[1] == null){
            throw new NoSuchElementException();
        }
        return (E) array[1];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object[] toArray(){
        return Arrays.copyOf(array, size + 1);
    }
}
