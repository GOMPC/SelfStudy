package Interface_form;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E>, Cloneable {
    
    private static final int DEFAULT_CAPACITY = 64; // 이집은 방이 크네

    private Object[] array;
    private int size;

    private int front; // 새식구들 하이~
    private int rear;

    public ArrayQueue(){
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayQueue(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    private void resize(int newCapacity){

        int arrayCapacity = array.length; // 지금 사는 집 크기

        Object[] newArray = new Object[newCapacity]; // 이사갈 집


        for(int i=1,j=front+1;i<=size;i++,j++){ // 이런 for문은 볼때마다 신기해
            newArray[i] = array[j%arrayCapacity]; // 이게 어떤 의미인지 이해하도록
        }
        // front는 비었고 front+1부터 값이 있으니 j = front+1; 그리고 i=1부터 돌려서 front를 0으로 해도 되도록 ㅇㅇ. j%arrayCapacity는 뭐냐. 생각해보도록.
        this.array = null;
        this.array = newArray;
        // 1부터 채웠으니 front는 0으로 설정.
        front = 0;
        rear = size;
    }

    @Override
    public boolean offer(E item) {
        // 가득 찬 경우. rear + 1 이 자꾸 늘어나면 원을 벗어나잖아. 나머지 값으로 돌아왓!
        if((rear+1) % array.length == front){ // 그리고 front를 만난다? 컷~
            resize(array.length*2);
        }
        rear = (rear+1) % array.length;

        array[rear] = item;
        size++;

        return true;
    }

    @Override
    public E poll() {
        if(size == 0){
            return null; // 예외가 아니라 이런걸 반환하넹.. 차피 널값 써먹으려면 NullPointException 생기니까?
        }

        front = (front + 1) % array.length; // 원 벗어나지마!

        @SuppressWarnings("unchecked")
        E item = (E) array[front]; // 갈땐 가더라도~

        array[front] = null; // 잘가~
        size--;

        if(array.length > DEFAULT_CAPACITY && size < (array.length/4)){
            resize(Math.max(DEFAULT_CAPACITY, array.length/2));
        } // 줄일땐 줄이더라도 최소용량은 ㅇㅇ Math.max 리하이~

        return item; 

    }

    public E remove(){

        E item = poll();

        if(item == null){ // 여기선 또 예외띄우네 ㅇㅅㅇ?
            throw new NoSuchElementException();
        }

        return item;
    }

    @Override
    public E peek() { // 삭제 없이 반환만 ㅎ
        if(size == 0){
            return null;
        }

        @SuppressWarnings("unchecked") // 어차피~ 킹갓제네럴 성님이 핸들링 해주신다구
        E item = (E) array[(front+1)%array.length];
        return item;
    }

    public E element(){
        E item = peek();

        if(item == null){ // ㅇㅅㅇ
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

        for(int i=0,idx=start;i<size;i++,idx=(idx+1)%array.length){
            if(array[idx].equals(value)){ // capacity만큼 전체 순회가 아닌 size만큼 컴팩트하게 순회
                return true;
            }
        }
        return false;
    }

    public void clear(){
        for(int i=0;i<array.length;i++){
            array[i] = null; // 혹시 몰라 모든 곳을 null로 가버렷~ GC형님 편하시라고^^
        }
        front = rear = size = 0;
    }

    public Object[] toArray(){
        return toArray(new Object[size]);
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a){

        final T[] res;

        if(a.length<size){ // 배열의 길이가 짧다!

            if(front<=rear){ // front가 앞에 있는 경우 / 또는 f==r 아무것도 없었다.
                return (T[]) Arrays.copyOfRange(array, front+1, rear+1, a.getClass());
            } // 왜 rear+1까지 해줄까? 비~밀~ <

            // if문 끝났으니 뭐겠어, front가 rear 뒤에 있는 경우겠지!
            res = (T[]) Arrays.copyOfRange(array, 0, size, a.getClass());
            int rearLength = array.length -1 -front; // 뒷 부분의 요소 개수

            if(rearLength>0){ // 뒷부분 복사
                System.arraycopy(array, front+1, res, 0, rearLength);
            } // 앞부분 복사
            System.arraycopy(array, 0, res, rearLength, rear+1); // 앞부분 복사
                            // From , F.index , To , To.index , ~까지 (<)
            return res; // 큰놈으로 맞춰서 보내드려요~
        }

        if(front <= rear){ // 정순
            System.arraycopy(array, front+1, a, 0, size);
        }

        else { // 역순. f가 뒤에 있는 경우
            int rearLength = array.length -1 -front; // 이게 왜 이렇게 됬을까?
            // 남은 개수 length - (front + 1)로 이해해도 되려나? 아닌거같은걸? (length - 1) - front인걸?
            if(rearLength>0){
                System.arraycopy(array, front+1, a, 0, rearLength);
            }
            System.arraycopy(array, 0, a, rearLength, rear +1);
        }

        return a;
    }

    @Override
    protected Object clone() {
        
        try{
            @SuppressWarnings("unchecked")
            ArrayQueue<E> clone = (ArrayQueue<E>) super.clone(); // 엄마 하이
            clone.array = Arrays.copyOf(array, array.length); // array로 값을 새로 찍어주기.
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

        Object[] res = toArray();

        Arrays.sort((E[])res, 0, size, c);

        clear();

        System.arraycopy(res, 0, array, 1, res.length);
        // front = 0 인덱스는 비워야 하므로 사실상 1번째 인덱스부터 채워야 한다? 납득 ㅇㅇ
        this.rear = this.size = res.length;
    }

}
