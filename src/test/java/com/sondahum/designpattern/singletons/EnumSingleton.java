package com.sondahum.designpattern.singletons;

public enum EnumSingleton implements SingletonInterface {
    _instance;

    @Override
    public void printHello(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("hello enum");
        }
    }
}
