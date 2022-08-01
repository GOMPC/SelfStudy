package NestedParty;

public class Button {
    
    OnClickListener listener; // 인터페이스 타입 필드?

    void setOnClickListener(OnClickListener listener){ // Setter +매개변수의 다형성을 맛보자.
        this.listener = listener;
    }

    void touch(){
        listener.onClick(); // 구현 객체의 각자 다른 맛의 onClick 드루와!
    }

    static interface OnClickListener{
        void onClick();
    }

}
