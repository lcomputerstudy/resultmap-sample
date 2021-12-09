package com.dcp.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcpApplication.class, args);
		System.out.println("Hello World");
	}
}
