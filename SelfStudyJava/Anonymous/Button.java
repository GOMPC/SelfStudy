package Anonymous;

public class Button {
    OnClickListener listener;

    void SetOnClickListener(OnClickListener listener){
        this.listener = listener;
    }

    void touch(){
        listener.onClick();
    }

    static interface OnClickListener{
        void onClick();
    }
}
