package com.sondahum.designpattern.observer;

public class EventSubscriber implements Observer {
    private String newsString;
    private Publisher publisher;

    public EventSubscriber(Publisher publisher) {
        this.publisher = publisher;
        publisher.addObserver(this);
    }

    @Override
    public void update(String title, String content) {
        this.newsString = "**Event User**\n" + "TITLE : " + title + "\n=============\n" + content+"\n\n";
        display();
    }

    public void display() {
        System.out.println(this.newsString);
    }
}
