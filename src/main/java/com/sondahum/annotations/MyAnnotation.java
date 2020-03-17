package com.sondahum.annotations;

public class MyAnnotation {

    @InsertValue(intValue = 30)
    int num1;

    @InsertValue(stringValue = "hello world!")
    String string1;

    void say() {
        System.out.println(num1);
        System.out.println(string1);
    }
}
