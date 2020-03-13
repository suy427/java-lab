package com.sondahum.designpattern.templatemethod;

public class ChildOne extends AbstractTemplate {

    @Override
    protected void printName() {
        System.out.println("my name is child one.");
    }
}
