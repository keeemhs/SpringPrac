package com.example.Example.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {}

record Address(String address, int postcode) {}

record Information(String name, int age, Address address) {}
@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "keeemhs";
    }

    @Bean
    public Person person() {
        return new Person("TOM", 24);
    }

    @Bean(name="myAddress")
    public Address address() {
        return new Address("KOREA", 140);
    }

    @Bean
    public Information info(String name, int age, Address myAddress) {
        return new Information(name, age, myAddress);
    }
}
