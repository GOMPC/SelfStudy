package Interface_form;

import java.util.Arrays;
import Interface_form.List;

public class ArrayList<E> implements List<E>, Cloneable { // clone()할려고 ㅎ Object에 protected라 ㅎ

    private static final int DEFAULT_CAPACITY = 10; //기본(최소) 크기
    private static final Object[] EMPTY_ARRAY = {}; //빈 배열

    private int size; // 개수

    Object[] array; // 요소를 담을 배열

    // 생성자1(초기 공간 할당 X)
    public ArrayList(){
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    // 생성자2(초기 공간 할당 O)
    public ArrayList(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize(){
        int array_capacity = array.length;

        // if array's capacity is 0 그러니까 빈 배열이다~ 라면?
        if(Arrays.equals(array, EMPTY_ARRAY)){
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        // 용량이 꽉 찰 경우
        if(size == array_capacity){
            int new_capacity = array_capacity *2;

            //
            array = Arrays.copyOf(array, new_capacity);
            return;
        }

        // 용량의 절반 미만으로 쓰고 있을 경우
        if(size < (array_capacity / 2)){
            int new_capacity = array_capacity / 2 ;

            array = Arrays.copyOf(array, Math.max(new_capacity, DEFAULT_CAPACITY));
            return;
        }
    }

    public boolean add(E value){
        addLast(value);
        return true;
    }

    public void addLast(E value){
        if(size == array.length){
            resize();
        }
        array[size] = value;
        size++;
    }

    public void add(int index, E value){
        if(index>size || index<0) { // 인덱스 숫자를 개똥같이 쓸때
            throw new IndexOutOfBoundsException();
        }
        if(index == size){
            addLast(value);
        } else {
            if(size == array.length){ // 위에도 있지? 매번 다 해야하나? 그냥 boolean add에 넣으면 안댐?
                resize();
            }

            for(int i=size;i>index;i--){ // 마지막 친구부터 한칸씩 밀기
                array[i] = array[i-1]; // i+1해야 하는거 아님? 뭐징? 은 대입연산자의 연산 방향을 보세요~
            }

            array[index] = value; // index위치에 value 삽입
            size++;
        }
    }

    public void addFirst(E value){
        add(0, value);
    }

    @SuppressWarnings("unchecked")
    public E get(int index){
        if(index>size || index<0) { // 인덱스 숫자를 개똥같이 쓸때
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index]; // Object타입에서 E타입으로 캐스팅 후 반환
        //위에 @SuppressWarnings("unchecked") 이놈은 Object->E 너 감당가능해? 경고 메세지.
        //우리는 차피 제네릭 성님이 구현해주시는 형 안정성이 보장되니까 예외 가능성 제로인 경우. suppress해버린다
    }

    public void set(int index, E value){
        if(index>size || index<0) { // 인덱스 숫자를 개똥같이 쓸때
            throw new IndexOutOfBoundsException(); // 중복 좀 멈춰..!
        }
        array[index] = value;
    }

    public int indexOf(Object value){
        int i = 0; // 왜 여기서 미리 잡아놓음? 걍 for문에 바로 넣어도 되지않나

        for(i=0;i<size;i++){ // 설마 진짜로 이렇게 되어있...겠어?
            if(array[i].equals(value)){ // 동등연산자 == 안쓰고 equals 메소드 쓰는 이유는.. 알겠지?
                return i;
            }
        }
        return -1; //없어~
    }

    public int lastIndexOf(Object value){
        for(int i=size-1;i>=0;i--){ // 마지막 인덱스니까 뒤에서 ㅎ
            if(array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object value){
        if(indexOf(value) >= 0){ // 찾는건 똑같으니께~ indexOf에서 -1이 나오면 없는거잖아~
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public E remove(int index){
        if(index>size || index<0) { // 인덱스 숫자를 개똥같이 쓸때
            throw new IndexOutOfBoundsException(); // 중복 멈춰!!!!!
        }

        E element = (E) array[index]; // ㅇㅅㅇ..
        array[index] = null; // 굳이 null 안잡아도..?

        for(int i=index;i<size-1;i++){ // size - 1 하는 이유는 알지?
            array[i] = array[i+1];
            array[i+1] = null; // 얘는 null 잡아야지 ㅇㅇ 마지막놈
        } // 여기서 size = 5일때, index4를 remove한다고 가정해보셈 ㅎ

        size--; // 줄었으니까
        resize(); // 메모리는 소중하니까
        return element; //리턴해야함? 그냥 void하고 없애면 되는거 아님? 이놈 인덱스로 지웟으니 뭐 지웟는지 보여줄라고?
    }

    public boolean remove(Object value){
        // value값을 삭제. 그러려면 일단 value가 있나 검사, 있으면 그놈 컷~
        // 컷했으면 또 다시 당겨야지.
        // 검사는 indexOf가 알아서 해주고, 컷하고 당기는건 remove가 알아서 해주잖아~ 차피 index가 있는걸
        int index = indexOf(value);

        if(index == -1) return false;

        remove(index);
        return true;
    }

    public int size(){
        return size; // 개꿀.. private 친구 반환띠~
    }

    public boolean isEmpty(){
        return size == 0; // 이쯤되면 size가 진짜 큰그림을 그렸나 싶다
    }

    public void clear(){
        // 파멸. 모든 요소 컷~ 그러면 size도 컷~
        // 배열 크기는 반만 줄여줍니다. Hoxy 비슷한 크기로 쓸까봐.. 안쓸거면 없앴겠지 왜 비웠겠어..?
        for(int i=0;i<size;i++){
            array[i] = null;
        }

        size = 0;
        resize(); // 그럼 굳이 resize 안해도?
    }

    public Object clone() throws CloneNotSupportedException {
        // 새 친구 하이~
        ArrayList<?> cloneList = (ArrayList<?>)super.clone(); //응애 나 클론해줘
        // 새 친구의 배열도 만들어야죠! (얕은 복사 멈춰!)
        cloneList.array = new Object[size];
        // 배열의 값 다 베껴~
        System.arraycopy(array, 0, cloneList.array, 0, size);

        return cloneList;
    }

    public Object[] toArray(){
        return Arrays.copyOf(array, size); // Object 타입의 똑같은 크기의 배열로 만들어 드렷읍니다^0^
    }

    @SuppressWarnings("unchecked") // 타입 안전해 이 짜식아
    public <T> T[] toArray(T[] a){ // 이미 있는 배열이나 다른 크기의 배열에 ㅇㅇ
        if(a.length < size){ // 이미 있는 집이 너무 좁다! 확장공사 드가자~
            return (T[]) Arrays.copyOf(array, size, a.getClass()); // 상위 타입에 대해서도 담을수 있게 ㅇㅇ? getClass() 찾아보도록
        }           // T[] 타입으로 강제변환이었다!!!! 그냥 어려워 보였는데 알고보니 개쉬움
        System.arraycopy(array, 0, a, 0, size);
        return a;
    }

    // clone() 이랑 toArray() sort()는 이 집 안에 놓을까? 아님 밖으로 뺄까?
    // 집 안에 둬야 쓸 수 있는거 아님? 밖에 빼면 어떻게 쓸껴? ㅇㅈ
    
    
}
