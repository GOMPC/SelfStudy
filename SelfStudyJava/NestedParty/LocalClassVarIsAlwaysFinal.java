package NestedParty;

public class LocalClassVarIsAlwaysFinal {
    
    public void method1(int arg){ // 매개변수도 필드값도(로컬변수도) final 안해줘도 알아서 final 해줍니다.
        int localVar = 1;
        // arg = 100;
        // localVar = 100; // 그러니 이렇게 못바꾸겠죠? 바꾸면 컴파일에러 ㅎㅇ~

        class Inner{
            public void method(){
                int result = arg + localVar;
            }
        }
    }
}
