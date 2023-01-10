package com.frcsprep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.frcsprep")
public class FrcsprepApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrcsprepApplication.class, args);
	}

}
