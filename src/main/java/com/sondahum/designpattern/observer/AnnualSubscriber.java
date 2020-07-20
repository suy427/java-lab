package com.sondahum.designpattern.observer;

public class AnnualSubscriber implements Observer {
    private String newsString;
    private Publisher publisher;


    public AnnualSubscriber(Publisher publisher) {
        this.publisher = publisher;
        publisher.addObserver(this);
    }

    @Override
    public void update(String title, String content) {
        this.newsString = "**Annual User**\n" + "TITLE : " + title + "\n=============\n" + content;
        display();
    }

    public void display() {
        System.out.println(this.newsString);
    }
}
