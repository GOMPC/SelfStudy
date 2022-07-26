package Interface_form;

import Interface_form.List;

public class ArrayList<T> implements List<T> {

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

        // if array's capacity is 0
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
    
}
