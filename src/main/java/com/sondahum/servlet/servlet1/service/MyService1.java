package com.sondahum.servlet.servlet1.service;


import com.sondahum.servlet1.repository.MyRepository1;
import org.springframework.stereotype.Service;

@Service
public class MyService1 {

    private final MyRepository1 repo1;


    public MyService1(MyRepository1 repo1) {
        this.repo1 = repo1;
    }
}
