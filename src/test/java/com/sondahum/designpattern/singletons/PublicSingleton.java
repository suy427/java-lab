package com.sondahum.designpattern.singletons;

public class PublicSingleton implements SingletonInterface {
    public static final PublicSingleton _instance = new PublicSingleton();

    private PublicSingleton(){}

    @Override
    public void printHello(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("hello public");
        }
    }
}
