package com.sondahum.servlet.servlet3.service;


import com.sondahum.servlet.servlet3.repository.MyRepository3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService3 {

    @Autowired
    private MyRepository3 repo3;

    public String sayHello() {
        return "my name is MyServlet3 from servlet3";
    }
}
