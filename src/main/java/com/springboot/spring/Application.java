package com.springboot.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"com.springboot.*"})

public class Application {

	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
		
		System.out.println("Congrulations, you made it!");
	}

}
