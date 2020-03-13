package com.sondahum.designpattern.templatemethod;

import org.junit.Test;

public class TemplateMethodTest {

    ChildOne kid = new ChildOne();


    @Test
    public void test() {
        kid.greeting();
        // 나는 자식 클래스에 greeting이 override안돼있으니까 super.greeting() 호출할텐데.. 그러면
        // greeting() 안에 printName()도 super class 것을 쓰는건지 헷갈렸다.. 근데 아니었다..!!
    }
}
