package Interface_form;

import java.util.Arrays;

public class LinkedHashSet<E> implements Set<E> { // 링크드가 왔어~
    
    private final static int DEFAULT_CAPACITY = 1 << 4; // recommend 2^n

    private static final float LOAD_FACTOR = 0.75f;

    HashNode<E>[] table;
    private int size;

    private HashNode<E> head; // 뚝배기
    private HashNode<E> tail; // 꼬다리

    @SuppressWarnings("unchecked")
    public LinkedHashSet(){
        table = (HashNode<E>[]) new HashNode[DEFAULT_CAPACITY];
        size = 0;
        head = null;
        tail = null;
    }

    private static final int hash(Object key){
        int hash;
        if(key == null){
            return 0;
        } else {
            return Math.abs(hash = key.hashCode()) ^ (hash >>> 16);
        }
    }

    private void linkLastNode(HashNode<E> o) {
        
        HashNode<E> last = tail;

        tail = o;

        if(last == null){ // 꼬랑지가 없다는 말은 연결되있지 않다는 소리! 즉 대가리도 없다는 소리!
            head = o; // 1빠 맨~
        } else {
            o.prevLink = last;
            last.nextLink = o;
        }
    }

    @Override
    public boolean add(E e) {
        return add(hash(e), e) == null;
    }

    private E add(int hash, E key){

        int idx = hash % table.length; // = hash & (table.length - 1); 같다~ 비트비트띠~

        HashNode<E> newNode = new HashNode<E>(hash, key, null); // 새친구 하이

        if(table[idx] == null){
            table[idx] = newNode;
        } else {
            HashNode<E> temp = table[idx];
            HashNode<E> prev = null;

            while(temp != null){
                if((temp.hash == hash) && (temp.key == key || temp.key.equals(key))){
                    return key; // 이봐 김씨 잘못들어왔어~ 중복이야!
                }
                prev = temp;
                temp = temp.next; // 뺑뺑이 돌아~
            }

            prev.next = newNode; // 중복검사 통과. 
        }
        size++;

        linkLastNode(newNode); // 쉽게 말해서 hash가 겹쳤을때의 해결을 위한 next가 있고 순서를 알고싶은 prev/nextLink가 있는겨~

        if(size >= LOAD_FACTOR * table.length){
            resize();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        int newCapacity = table.length * 2;

        final HashNode<E>[] newTable = (HashNode<E>[]) new HashNode[newCapacity];

        for(int i=0;i<table.length;i++){
            HashNode<E> value = table[i];

            if(value == null){
                continue;
            }

            table[i] = null; // gc

            HashNode<E> nextNode; // table[i]와 연결된 next친구를 잊지말도록

            while(value != null){
                int idx = value.hash % newCapacity; // 새집 주소

                if(newTable[idx] != null){ // 임자가 벌써 있네?
                    HashNode<E> tail = newTable[idx];
                    while(tail.next != null){ // 꼬리 찾으러 드가자~
                        tail = tail.next;
                    }

                    nextNode = value.next; // 친구 잊지마~
                    value.next = null; // 꼬리자르기 항상 생각해!
                    tail.next = value;
                } else {
                    nextNode = value.next;
                    value.next = null; // !!!!!!!!!
                    newTable[idx] = value;
                }

                value = nextNode; // table[i]에 같이 살던 뒷친구도 다 이사가야지
            }
        }

        table = null;
        table = newTable;
    }

    @SuppressWarnings("unchecked")
    private void resize2(){
        int oldCapacity = table.length;
        int newCapacity = table.length * 2; // == oldCapacity << 1;
        final HashNode<E>[] newTable = (HashNode<E>[]) new HashNode[newCapacity];

        for(int i=0;i<oldCapacity;i++){
            HashNode<E> data = table[i];

            if(data == null){
                continue;
            }

            table[i] = null;
            if(data.next == null){ // 이 집에 나 혼자살아~
                newTable[data.hash & (newCapacity -1)] = data;
                continue;
            }

            HashNode<E> lowHead = null;
            HashNode<E> lowTail = null;

            HashNode<E> highHead = null;
            HashNode<E> highTail = null;

            HashNode<E> next; // 뒷방친구

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
            } while (data != null);

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

    private void unlinkNode(HashNode<E> o){
    
        HashNode<E> prevNode = o.prevLink;
        HashNode<E> nextNode = o.nextLink;

        if(prevNode == null){
            head = nextNode;
        } else {
            prevNode.nextLink = nextNode;
            o.prevLink = null;
        }

        if(nextNode == null){
            tail = prevNode;
        } else {
            nextNode.prevLink = prevNode;
            o.nextLink = null;
        }

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
                } else {
                    prev.next = node.next;
                }

                unlinkNode(node);
                node = null;

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
            if(o == temp.key || (o != null && temp.key.equals(o))){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

    @Override
    public void clear() {
        if(table != null && size > 0) {
            for(int i=0;i<table.length;i++){
                table[i] = null;
            }
            size = 0;
        }
        head = tail = null; // 마지막에 이렇게 head tail을 끊어줘야 gc가 된다!
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if(o == this){
            return true;
        }
        if(!(o instanceof LinkedHashSet)){
            return false;
        }

        LinkedHashSet<E> oSet;

        try{
            oSet = (LinkedHashSet<E>) o;
            if(oSet.size() != size){
                return false;
            }

            for(int i=0;i<oSet.table.length;i++){
                HashNode<E> oTable = oSet.table[i];

                while(oTable != null){
                    if(!contains(oTable)){
                        return false;
                    }
                    oTable = oTable.next;
                }
            }
        } catch(ClassCastException e) {
            return false;
        }

        return true;
    }

    public Object[] toArray(){
        if(table == null || head == null){
            return null;
        }
        Object[] ret = new Object[size];
        int index = 0;

        for(HashNode<E> x = head; x!=null; x=x.nextLink){
            ret[index++] = x.key;
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
