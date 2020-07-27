package com.sondahum.designpattern.observer;

public class Runner {
    public static void main(String[] args) {
        NewsMachine newsMachine = new NewsMachine();
        AnnualSubscriber annualSubscriber = new AnnualSubscriber(newsMachine);
        EventSubscriber eventSubscriber = new EventSubscriber(newsMachine);

        newsMachine.setNewsInfo("first","this is first news");
        newsMachine.setNewsInfo("second", "this is second news");
    }
}
