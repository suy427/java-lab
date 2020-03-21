package com.sondahum.servlet.servlet1.config;


import com.sondahum.servlet.servlet1.controller.MyController1;
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
    public MyService1 myService1() {
        return new MyService1(new MyRepository1() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }
}
