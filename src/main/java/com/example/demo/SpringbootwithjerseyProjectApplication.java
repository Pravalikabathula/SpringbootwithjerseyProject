package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootwithjerseyProjectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder bulider) {
		return bulider.sources(SpringbootwithjerseyProjectApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwithjerseyProjectApplication.class, args);
		System.out.println("Employee table is created ");
	}

}
