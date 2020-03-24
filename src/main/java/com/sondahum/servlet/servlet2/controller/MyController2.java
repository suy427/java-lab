package com.sondahum.servlet.servlet2.controller;


import com.sondahum.servlet.servlet2.service.MyService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController2 {

    @Autowired
    MyService2 myService2;

    @GetMapping("/s2")
    public String s2_hello() {
        return myService2.sayHello();
    }
}
