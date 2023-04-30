package com.bci.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bci.api")
public class BciApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BciApiApplication.class, args);
	}

}
