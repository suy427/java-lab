package com.sondahum.servlet.servlet1.service;


import com.sondahum.servlet.servlet1.repository.MyRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService1 {

    @Autowired
    private MyRepository1 repo1;


    public MyService1(MyRepository1 repo1) {
        this.repo1 = repo1;
    }

    public String sayHello() {
        return "Hello my name is MyService1 from servlet1";
    }
}
