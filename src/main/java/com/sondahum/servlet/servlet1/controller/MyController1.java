package com.sondahum.servlet.servlet1.controller;

import com.sondahum.servlet.servlet1.service.MyService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController1 {

    @Autowired
    MyService1 myService1;

    @GetMapping("/s1")
    public String s1_hello() {
        return myService1.sayHello();
    }
}
