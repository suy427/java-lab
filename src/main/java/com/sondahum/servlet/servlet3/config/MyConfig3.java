package com.sondahum.servlet.servlet3.config;


import com.sondahum.servlet.servlet1.controller.MyController1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MyConfig3 implements WebMvcConfigurer {

    @Bean
    MyController3 registerController3() {
        return new MyController3();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }
}
