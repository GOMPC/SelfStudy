package Interface_form;

import java.util.Arrays;

public class HashSet<E> implements Set<E> {
    
    private final static int DEFAULT_CAPACITY = 1 << 4; // 기본 용적. 2^n이 이쁘대. 비트연산자 하이~
    
    private final static float LOAD_FACTOR = 0.75f; // 3/4이상 채워지면 업업! 속도상승

    HashNode<E>[] table; // 요소의 정보를 담고있는 Node를 저장할 Node타입 배열. Separate Chaining!
    private int size;

    @SuppressWarnings("unchecked")
    public HashSet(){
        table = (HashNode<E>[]) new HashNode[DEFAULT_CAPACITY];
        size = 0;
    }

    private static final int hash(Object key){ // 보조 해시 함수. 상속 방지를 위해 private static final 선언
        int hash;
        if(key == null){
            return 0;
        } else { // 음수가 나올 수 있으니 abs로 양수 반환.
            return Math.abs(hash = key.hashCode()) ^ (hash >>> 16);
        } // 최대한 해시 충돌을 피하기 위해 이렇게 보조 해시함수가 있을 수 있다. key.hashCode()의 절대값과 그 값을 16비트 왼쪽으로 밀어낸 값하고의 XOR값을 반환.
    }

    @Override
    public boolean add(E e) {
        return add(hash(e), e) == null;
    }

    private E add(int hash, E key){
        int idx = hash % table.length; // 큐,덱에서 배운거처럼 ㅇㅋ? 용적이 2^n일때는 비트연산자로도 가능!
        /*
        int idx = hash % table.length;
        int idx = hash & (table.length-1);

        2의 n승 꼴은 비트로 표현하면 다음과 같다.
 
        0000..001000...00(2)  <-- n번째 자리에 1이 됨을 의미
 
        위 식에서 1을 빼면 n-1번째 및 하위의 비트는 모두 1이 됨
        0000..000111...11(2)  
 
        hash & 0000..000111...11(2)
        이는 즉, 2^n승으로 떨어지는 값 및 그 상위 비트 부분은 제외된, hash와 AND연산이 되므로
        이는 곧 hash에 2^n을 나눈 나머지 값이 됨. 용적이 2^n일때만!
        */
        if(table[idx] == null){ // 집 비었니?
            table[idx] = new HashNode<E>(hash, key, null); // 내가 1빠!
        } else { // 아니네?
            HashNode<E> temp = table[idx]; // 1빠형 하이
            HashNode<E> prev = null; // 1빠니까 당연하지!

            while(temp != null) {
                if(temp.hash == hash && temp.key == key || temp.key.equals(key)){
                    return key; // 여기 중복이요 ㅡㅡ
                }

                prev = temp;
                temp = temp.next; // 한칸씩 이동~
            }

            prev.next = new HashNode<E>(hash, key, null); // 연결!

        }
        size++;

        if(size >= LOAD_FACTOR * table.length){ 
            resize(); // 방이 좁아서 좀 넓힐게요
        }

        return null; // 무소식이 희소식이다

    }

    @SuppressWarnings("unchecked")
    private void resize(){
        int newCapacity = table.length * 2;

        final HashNode<E>[] newTable = (HashNode<E>[]) new HashNode[newCapacity];

        for(int i=0;i<table.length;i++){
            HashNode<E> value = table[i];

            if(value == null){ // 비었어요
                continue;
            }
            table[i] = null; // gc

            HashNode<E> nextNode; // 현재 노드의 다음 노드를 가리키는 변수

            while(value != null){ // 여기 사람있어요!
                int idx = value.hash % newCapacity; // 새 집으로 가자~

                if(newTable[idx] != null){ // 1빠가 아니야ㅠ
                    HashNode<E> tail = newTable[idx];

                    while(tail.next != null){ // 맨뒤로 달려~
                        tail = tail.next;
                    }

                    nextNode = value.next;
                    value.next = null; // 주의하세요! 무조건 null 명시해야! 이전에 혹시나 next있다면 끔찍한 일이 생길지도
                    tail.next = value; // 꼬리 뒤에 붙여~
                } else {
                    nextNode = value.next;
                    value.next = null; // 주의해!
                    newTable[idx] = value;
                }

                value = nextNode;
            }
        }

        table = null;
        table = newTable;
    }

    @SuppressWarnings("unchecked")
    private void resize2(){ // 용적이 2^n일 경우 비트연산자로 어떻게 해보나! 다시 복습해볼것
        
        int oldCapacity = table.length;
        int newCapacity = oldCapacity << 1; // 두배요~
        final HashNode<E>[] newTable = (HashNode<E>[]) new HashNode[newCapacity];

        for(int i=0;i<oldCapacity;i++){

            HashNode<E> data = table[i];
            if(data == null){
                continue;
            }

            table[i] = null; // gc
            if(data.next == null){
                newTable[data.hash & (newCapacity - 1)] = data;
                continue;
            }

            HashNode<E> lowHead = null; // 이사 안가는 친구들
            HashNode<E> lowTail = null;

            HashNode<E> highHead = null; // 이사가는 친구들
            HashNode<E> highTail = null;

            HashNode<E> next;

            do{
                next = data.next;

                if((data.hash & oldCapacity) == 0){

                    if(lowHead == null){
                        lowHead = data;
                    } else {
                        lowTail.next = data;
                    }
                    lowTail = data;
                } else {
                    if(highHead == null){
                        highHead = data;
                    } else {
                        highTail.next = data;
                    }
                    highTail = data;
                }

                data = next;
            } while(data != null);

            if(lowTail != null){
                lowTail.next = null;
                newTable[i] = lowHead;
            }

            if(highTail != null){
                highTail.next = null;
                newTable[i + oldCapacity] = highHead;
            }
        }

        table = newTable;

    }

    @Override
    public boolean remove(Object o) {
        return remove(hash(o), o) != null;
    }

    private Object remove(int hash, Object key){

        int idx = hash % table.length;

        HashNode<E> node = table[idx];
        HashNode<E> removedNode = null;
        HashNode<E> prev = null;

        if(node == null){
            return null;
        }

        while(node != null){
            if(node.hash == hash && (node.key == key || node.key.equals(key))){
                removedNode = node;
                if(prev == null){
                    table[idx] = node.next;
                    node = null;
                } else {
                    prev.next = node.next;
                    node = null;
                }
                size--;
                break;
            }
            prev = node;
            node = node.next;
        }
        return removedNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        int idx = hash(o) % table.length;
        HashNode<E> temp = table[idx];

        while(temp != null){
            if(o == temp.key || (o != null && o.equals(temp.key))){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    @Override
    public void clear() {
        if(table != null && size > 0){
            for(int i=0;i<table.length;i++){
                table[i] = null;
            }
            size = 0;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        
        if(o==this){
            return true;
        }
        if(!(o instanceof HashSet)){ // 호환이 안된다고? 컷!
            return false;
        }

        HashSet<E> oSet;

        try{
            oSet = (HashSet<E>) o;
            if(oSet.size != size){ // 싸이즈가 달라? 컷!
                return false;
            }

            for(int i=0;i<oSet.table.length;i++){
                HashNode<E> oTable = oSet.table[i];
                while(oTable != null){
                    if(!contains(oTable)){ // 왜 돌면서 비교안하고 contains를 쓸까? 생각해보세요!
                        return false; // 포함하지 않아? 컷!
                    }
                    oTable = oTable.next; // 서로 용적이 다를 수 있으니! contains를 쓴다.
                }
            }
        } catch(ClassCastException e) { // 호환 맨~
            return false;
        }
        return true; // 합격자에게 주어지는 true
    }

    public Object[] toArray(){

        if(table == null){
            return null;
        }
        Object[] ret = new Object[size];
        int index = 0;

        for(int i=0;i<table.length;i++){
            HashNode<E> node = table[i];

            while(node != null){
                ret[index++] = node.key;
                node = node.next;
            }
        }
        return ret;
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a){

        Object[] copy = toArray();

        if(a.length < size){
            return (T[]) Arrays.copyOf(copy, size, a.getClass());
        }

        System.arraycopy(copy, 0, a, 0, size);

        return a;
    }

}
