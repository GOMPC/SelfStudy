package Interface_form;

import java.util.EmptyStackException;

public class StackExtendArrayList<E> extends ArrayList<E> implements StackInterface<E> {

    public StackExtendArrayList(){
        super();
    }

    public StackExtendArrayList(int capacity){
        super(capacity);
    }

    @Override
    public E push(E item) { // 이친구 왜 맛탱이갔냐 >> implements StackInterface에 <E>안붙여서 맛탱이감 ㅋㅋ
        addLast(item); // ArrayList의 친구
        return item;
    }

    @Override
    public E pop() {
        int length = size();
        E obj = remove(length-1); // ArrayList친구 다써먹어

        return obj;
    }

    @Override
    public E peek() {
        
        int length = size();
        if(length == 0){
            throw new EmptyStackException();
        }

        E obj = get(length-1);

        return obj;
    }

    @Override
    public int search(Object value) {
        int idx = lastIndexOf(value);
        
        if(idx >=0){
            return size() - idx;
        }
        return -1;
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }
    
}
