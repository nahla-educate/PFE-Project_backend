package com.myProject.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;




@SpringBootApplication
@EnableAsync
@EnableJpaRepositories
@EnableJpaAuditing
@ComponentScan("com.myProject.demo")
public class SpringBootBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackEndApplication.class, args);
	}

	
	//for upload file
	
	
}
