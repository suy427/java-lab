package com.sondahum.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@interface MySourceAnnotation {
    String name() default "source";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
@interface MyClassAnnotation {
    String name() default "class";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyRuntimeAnnotation {
    String name() default "runtime";
}

class AnnotationTest {

    @MySourceAnnotation(name = "john")
    static String john;

    @MyClassAnnotation(name = "mike")
    static String mike;

    @MyRuntimeAnnotation(name = "alice")
    static String alice;

    public static void main(String[] args) {
        System.out.println("hi myname is " + john);
        System.out.println("hi myname is " + mike);
        System.out.println("hi myname is " + alice);
    }
}