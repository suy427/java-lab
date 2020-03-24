package com.sondahum.servlet.servlet2.service;


import com.sondahum.servlet.servlet2.repository.MyRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService2 {

    @Autowired
    private MyRepository2 repo2;

    public String sayHello() {
        return "hello my name is MyServlet2 from servelt2";
    }
}
