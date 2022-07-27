package Singleton;

public class ShopServiceSingleton {
    private static ShopServiceSingleton singleton = new ShopServiceSingleton();

    private ShopServiceSingleton(){};

    static ShopServiceSingleton getInstance(){
        return singleton; // 어느 것이 클래스명이고 어느 것이 인스턴스 이름인지 안헷갈리도록
    }
}
