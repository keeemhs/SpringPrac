package com.example.Example.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorld {
    public static void main(String[] args) {

        // 스프링 컨텍스트를 실행하는 단계
        var context = new AnnotationConfigApplicationContext( HelloWorldConfiguration.class );

        System.out.println( context.getBean("name") );
        System.out.println( context.getBean("person") );
    }
}
