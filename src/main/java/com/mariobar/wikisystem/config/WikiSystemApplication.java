package com.mariobar.wikisystem.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.mariobar")
@SpringBootApplication
@MapperScan("com.mariobar.wikisystem.mapper")
public class WikiSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(WikiSystemApplication.class, args);
	}

}
