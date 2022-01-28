package com.mariobar.wikisystem.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan("com.mariobar")
@SpringBootApplication
@MapperScan("com.mariobar.wikisystem.mapper")
@EnableScheduling
@EnableAsync
public class WikiSystemApplication {
	private static final Logger LOG = LoggerFactory.getLogger(WikiSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication app =new SpringApplication(WikiSystemApplication.class);
		Environment env = app.run(args).getEnvironment();
		LOG.info("Run Successfully!");
		LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
	}

}
