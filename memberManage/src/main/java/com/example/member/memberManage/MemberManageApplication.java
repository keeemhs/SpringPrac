package com.example.member.memberManage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.member.memberManage.mapper")
public class MemberManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberManageApplication.class, args);
	}

}
