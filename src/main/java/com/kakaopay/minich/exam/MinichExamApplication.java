package com.kakaopay.minich.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.kakaopay.minich.exam.mapper")
public class MinichExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinichExamApplication.class, args);
	}

}
