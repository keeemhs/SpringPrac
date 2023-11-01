package com.example.jdbsExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbsExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbsExampleApplication.class, args);
	}

	/*
	* @Component에서 파생되어 나온 어노테이션
	*
	* @Repository: 데이터 계층 컴포넌트, 특징, 데이터베이스에서 연산에서 발생할 수 있는 예외를 Spring의 'DataAccessException'으로
	* 변하는 기능이 포함됨.
	*
	* @Service: 서브시 계층 컴포넌트, 비즈니스 로직을 담당하는 클래스에 사용
	*
	* @Controller: 주로 어플리케이션에서 MVC패턴의 컨트롤러 역할을 담당
	*
	* */

}
