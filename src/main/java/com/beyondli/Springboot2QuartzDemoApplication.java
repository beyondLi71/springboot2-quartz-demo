package com.beyondli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.beyondli.repository")
public class Springboot2QuartzDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2QuartzDemoApplication.class, args);
	}

}
