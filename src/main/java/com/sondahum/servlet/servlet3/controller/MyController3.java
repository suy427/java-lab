package com.sondahum.servlet.servlet3.controller;


import com.sondahum.servlet.servlet3.service.MyService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController3 {

    @Autowired
    MyService3 myService3;


    @GetMapping("/s3")
    public String s3_hello() {
        return myService3.sayHello();
    }
}
