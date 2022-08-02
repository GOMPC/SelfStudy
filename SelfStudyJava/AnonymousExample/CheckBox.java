package AnonymousExample;

public class CheckBox {
    OnSelectListener listener;

    public void setOnSelectListener(OnSelectListener listener) {
        this.listener = listener;
    }

    void select(){
        listener.onSelect();
    }

    static interface OnSelectListener{
        void onSelect();
    }
}
