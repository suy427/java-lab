package com.sondahum.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsMachine implements Publisher {
    private List<Observer> subscribers;
    private String title;
    private String content;

    public NewsMachine() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer subscriber : subscribers) {
            subscriber.update(this.title, this.content);
        }
    }

    public void setNewsInfo(String title, String content) {
        this.title = title;
        this.content = content;
        notifyObserver();
    }

}
