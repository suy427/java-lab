package com.sondahum.servlet.servlet1.config;


import com.sondahum.servlet.servlet1.controller.MyController1;
import com.sondahum.servlet.servlet1.repository.MyRepository1;
import com.sondahum.servlet.servlet1.service.MyService1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class MyConfig1 implements WebMvcConfigurer {

    @Bean
    public MyController1 registerController1() {
        return new MyController1();
    }

    @Bean
    public MyRepository1 myRepository1() {
        return new MyRepository1() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
    }

    @Bean
    public MyService1 myService1(MyRepository1 repo1) {
        return new MyService1(repo1);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }
}
