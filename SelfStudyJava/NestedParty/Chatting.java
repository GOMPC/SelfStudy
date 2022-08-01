package NestedParty;

public class Chatting {
    void startChat(String chatId){
        String nickName = "GOMPC";

    class Chat { // startChat 내부에 있는 로컬 클래스. 로컬 클래스이니 아우터 클래스의 멤버변수가 final로 고정이 된다.

        public void start(){
            while(true){
                String inputData = "Hello";
                String message = "[" + nickName + "]" + inputData;
                sendMessage(message);
            }
        }

        void sendMessage(String message){}

        }

    Chat chat = new Chat();
    chat.start();

    }

}
