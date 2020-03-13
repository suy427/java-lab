package com.sondahum.designpattern.singletons;

public class NormalSingleton implements SingletonInterface {
    private static NormalSingleton _instance;

    private NormalSingleton() {}

    public static NormalSingleton getInstance() {
        if (_instance == null) {
            _instance = new NormalSingleton();
        }
        return _instance;
    }

    @Override
    public void printHello(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("hello normal");
        }
    }
}
