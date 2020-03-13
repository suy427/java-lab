package com.sondahum.designpattern.singletons;

import org.junit.Test;

public class SingletonTest {


    @Test
    public void enumSingletonTest() {
       SingletonInterface enumSingleton = EnumSingleton._instance;
       enumSingleton.printHello(1);
    }

    @Test
    public void lazyHolderSingletonTest() {
        SingletonInterface lazySingleton = LazyHolderSingleton.getInstance();
        lazySingleton.printHello(1);
    }

    @Test
    public void normalSingletonTest() {
        SingletonInterface normalSingleton = NormalSingleton.getInstance();
        normalSingleton.printHello(1);
    }

    @Test
    public void publicSingletonTest() {
        SingletonInterface publicSingleton = PublicSingleton._instance;
        publicSingleton.printHello(1);
    }
}
