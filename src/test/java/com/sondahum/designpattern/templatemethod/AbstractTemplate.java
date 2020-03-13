package com.sondahum.designpattern.templatemethod;

public abstract class AbstractTemplate {

    protected void printName() {
        System.out.println("and my name is father.");
    }

    void greeting() {
        System.out.println("hello i am korean.");
        System.out.println("i can speak korean");
        System.out.println("i love korea.");
        printName();
    }
}
