package com.sondahum.designpattern.observer;

public interface Publisher {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObserver();
}
