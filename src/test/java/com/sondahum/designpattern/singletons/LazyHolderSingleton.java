package com.sondahum.designpattern.singletons;

public class LazyHolderSingleton implements SingletonInterface {
    private LazyHolderSingleton() {}

    public static LazyHolderSingleton getInstance() {
        return LazyHolder._instance;
    }

    private static class LazyHolder {
        private static final LazyHolderSingleton _instance = new LazyHolderSingleton();
    }

    @Override
    public void printHello(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("hello lazy");
        }
    }
}
